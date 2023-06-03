package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
public class ScheduleDaoTest {
    @Autowired
    private ScheduleDao scheduleDao;
//    @Test
//    public void addScheduleTest(){
//        Schedule schedule = new Schedule();
//        schedule.setScheduleId(0);
//        schedule.setDoctorId("D00000000001");
//
//        LocalDate day = LocalDate.now();
//        LocalDateTime timeStart = LocalDateTime.now();
//        LocalDateTime timeEnd = LocalDateTime.now();
//
//        schedule.setDay(day);
//        schedule.setTimeStart(timeStart);
//        schedule.setTimeEnd(timeEnd);
//        schedule.setScheduleStatus(1);
//        scheduleDao.addSchedule(schedule);
//    }
//    @Test
//    public void getByIdTest(){
//        Schedule schedule = scheduleDao.getById(1);
//        System.out.println(schedule);
//    }
//    @Test
//    public void getByDoctorIdTest(){
//        List<Schedule> schedules = scheduleDao.getByDoctorId("D00000000001");
//        System.out.println(schedules);
//    }
//    @Test
//    public void getByDoctorIdAndDayTest(){
//        LocalDate day = LocalDate.parse("2023-03-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        List<Schedule> schedules = scheduleDao.getByDoctorIdAndDay("D00000000001",day);
//        System.out.println(schedules);
//    }
//    @Test
//    public void getByDoctorIdAndTimeTest(){
//        LocalDateTime timeStart=LocalDateTime.parse("2023-03-01 12:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        LocalDateTime timeEnd=LocalDateTime.parse("2023-03-01 12:30:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        Schedule schedules = scheduleDao.getByDoctorIdAndTime("D00000000001",timeStart,timeEnd);
//        System.out.println(schedules);
//    }
//    @Test
//    public void updateScheduleTest(){
////        Schedule schedule = scheduleDao.getById(1);
////        schedule.setScheduleStatus(2);
////        scheduleDao.updateSchedule(schedule);
//    }
//    @Test
//    public void deleteScheduleTest(){
//        Schedule schedule = scheduleDao.getById(2);
//        scheduleDao.deleteSchedule(schedule);
//    }
}
