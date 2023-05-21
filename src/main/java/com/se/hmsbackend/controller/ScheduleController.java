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
import com.se.hmsbackend.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin
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
    public R<Schedule> getSchedule(HttpServletRequest request,@RequestParam String token){
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        Schedule schedule = scheduleService.getScheduleByDoctorId(nowLoggedInId);
        return R.success(schedule);
    }
}
