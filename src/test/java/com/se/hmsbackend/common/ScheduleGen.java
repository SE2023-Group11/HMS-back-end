package com.se.hmsbackend.common;

import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.Schedule;
import com.se.hmsbackend.service.DoctorService;
import com.se.hmsbackend.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
public class ScheduleGen {
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private DoctorService doctorService;

    private LocalDate st = LocalDate.parse("2023-05-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    private LocalDate en = LocalDate.parse("2023-05-14", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

    @Test
    public void scheduleGen(){
        List<Doctor> doctors = doctorService.getAllDoctor();
//        for(Doctor doctor : doctors){
        for(int i=419;i<=419;i++){
//            String doctorId = "D00000000"+i;
//
//            System.out.println(doctorId);
//            Doctor doctor = doctorService.getDoctorById(doctorId);
//            Schedule schedule = new Schedule();
//            schedule.setDoctorId(doctor.getDoctorId());
//            schedule.setStartDate(st);
//
//            schedule.setMon1(Const.SCHEDULE_DEFAULT);
//            schedule.setTue1(Const.SCHEDULE_DEFAULT);
//            schedule.setWed1(Const.SCHEDULE_DEFAULT);
//            schedule.setThu1(Const.SCHEDULE_DEFAULT);
//            schedule.setFri1(Const.SCHEDULE_DEFAULT);
//            schedule.setSat1(Const.SCHEDULE_DEFAULT);
//            schedule.setSun1(Const.SCHEDULE_DEFAULT);
//            schedule.setMon2(Const.SCHEDULE_DEFAULT);
//            schedule.setTue2(Const.SCHEDULE_DEFAULT);
//            schedule.setWed2(Const.SCHEDULE_DEFAULT);
//            schedule.setThu2(Const.SCHEDULE_DEFAULT);
//            schedule.setFri2(Const.SCHEDULE_DEFAULT);
//            schedule.setSat2(Const.SCHEDULE_DEFAULT);
//            schedule.setSun2(Const.SCHEDULE_DEFAULT);
//            scheduleService.addSchedule(schedule);
        }
    }
}
