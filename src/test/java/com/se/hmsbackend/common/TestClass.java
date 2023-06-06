package com.se.hmsbackend.common;

import com.se.hmsbackend.pojo.Schedule;
import com.se.hmsbackend.service.PatientService;
import com.se.hmsbackend.service.ScheduleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class TestClass {
    @Autowired
    private ScheduleService scheduleService;
//    @org.junit.jupiter.api.Test
//    public void test(){
//        List<Schedule> scheduleList = scheduleService.getAllSchedules();
//        for(Schedule schedule : scheduleList){
//            schedule.setStartDate(LocalDate.parse("2023-06-05"));
//            System.out.println(schedule.getStartDate());
//            scheduleService.updateSchedule(schedule);
//        }
//    }
    @Autowired
    private PatientService patientService;
//    @Test
//    public void test1(){
////        System.out.println(System.currentTimeMillis());
////        System.out.println(patientService.getNewPatientId());
////        System.out.println(patientService.getNewPatientId());
////        System.out.println(patientService.getNewPatientId());
//        System.out.println(patientService.getNewPatientId());
//        System.out.println(patientService.getNewPatientId());
//        System.out.println(patientService.getNewPatientId());
////
//    }
}
