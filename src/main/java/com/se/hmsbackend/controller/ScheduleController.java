package com.se.hmsbackend.controller;

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

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        Schedule schedule = scheduleService.getScheduleByDoctorId(nowLoggedInId);
        return R.success(schedule);
    }

    @PostMapping("/getJob")
    public R<Schedule> getJob(@RequestParam String doctorID){
        Schedule schedule = scheduleService.getScheduleByDoctorId(doctorID);
        return R.success(schedule);
    }

    @PostMapping("/clearJob")
    public R<String> clearJob(@RequestParam String doctorID){
        Schedule schedule = scheduleService.getScheduleByDoctorId(doctorID);
        schedule.setMon1(Const.SCHEDULE_CLEARED);

        schedule.setMon1(Const.SCHEDULE_CLEARED);
        schedule.setTue1(Const.SCHEDULE_CLEARED);
        schedule.setWed1(Const.SCHEDULE_CLEARED);
        schedule.setThu1(Const.SCHEDULE_CLEARED);
        schedule.setFri1(Const.SCHEDULE_CLEARED);
        schedule.setSat1(Const.SCHEDULE_CLEARED);
        schedule.setSun1(Const.SCHEDULE_CLEARED);

        schedule.setMon2(Const.SCHEDULE_CLEARED);
        schedule.setTue2(Const.SCHEDULE_CLEARED);
        schedule.setWed2(Const.SCHEDULE_CLEARED);
        schedule.setThu2(Const.SCHEDULE_CLEARED);
        schedule.setFri2(Const.SCHEDULE_CLEARED);
        schedule.setSat2(Const.SCHEDULE_CLEARED);
        schedule.setSun2(Const.SCHEDULE_CLEARED);

        scheduleService.updateSchedule(schedule);
        return R.success("修改成功");
    }

    @PostMapping("/submitJob")
    public R<String> submitJob(@RequestBody Map params){
        List<Integer> weekDay = (List<Integer>) params.get("weekDay");
        List<Integer> halfDay = (List<Integer>) params.get("halfDay");
        String doctorId = (String) params.get("doctorID");
        Schedule schedule = scheduleService.getScheduleByDoctorId(doctorId);

        for(Integer day : weekDay){
            for(Integer half : halfDay){
                ScheduleUtil.submit(schedule,day, half);
            }
        }

        scheduleService.updateSchedule(schedule);
        return R.success("修改成功");
    }
}
