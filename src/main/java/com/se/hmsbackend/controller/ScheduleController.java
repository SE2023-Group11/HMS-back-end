package com.se.hmsbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.Schedule;
import com.se.hmsbackend.pojo.Section;
import com.se.hmsbackend.service.DoctorService;
import com.se.hmsbackend.service.ScheduleService;
import com.se.hmsbackend.service.SectionService;
import com.se.hmsbackend.utils.ScheduleUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ScheduleController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private SectionService sectionService;

    @GetMapping("/getDoctorsBySchedule")
    public R<List<Doctor>> getDoctorsBySchedule(@RequestParam String roomName, @RequestParam String date){
//        TODO: 查询科室当日排班医生
        Section section = sectionService.getRoomInfo(roomName);
        List<Doctor> doctors = doctorService.getDoctorBySectionId(section.getSectionId());
        doctors.removeIf(doctor -> ScheduleUtil.isFullSchedule(
                ScheduleUtil.scheduleStrToList(
                        ScheduleUtil.getScheduleOnDate(
                                scheduleService.getScheduleByDoctorId(doctor.getDoctorId()),date
                        )
                )
        ));
        return R.success(doctors);
    }

    @GetMapping("/getDoctorSchedule")
    public R<String> getDoctorSchedule(@RequestParam String doctorId, @RequestParam String date) {
        Schedule schedule = scheduleService.getScheduleByDoctorId(doctorId);
        String str = ScheduleUtil.getScheduleOnDate(schedule, date);
        return R.success(str);
    }

    @PostMapping("/getSchedule")
    public R<Schedule> getSchedule(HttpServletRequest request){
        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        Schedule schedule = scheduleService.getScheduleByDoctorId(nowLoggedInId);
        return R.success(schedule);
    }
}
