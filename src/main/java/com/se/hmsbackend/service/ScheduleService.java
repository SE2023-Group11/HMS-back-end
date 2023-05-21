package com.se.hmsbackend.service;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.dao.ScheduleDao;
import com.se.hmsbackend.pojo.Schedule;
import com.se.hmsbackend.utils.ScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    public List<Schedule> getAllSchedules(){return scheduleDao.getAllSchedules();}

    public void addSchedule(Schedule schedule){
        scheduleDao.addSchedule(schedule);
    }
    public Schedule getScheduleByDoctorId(String doctorId){
        return scheduleDao.getByDoctorId(doctorId);
    }

    public boolean updateScheduleToWork(String doctorId, String day, Integer time){
        Schedule schedule = getScheduleByDoctorId(doctorId);
        ScheduleUtil.updateScheduleOnDate(schedule, day, time, Const.SCHEDULE_STATUS_WORK);
        scheduleDao.updateSchedule(schedule);
        return true;
    }
    public boolean updateScheduleToEmpty(String doctorId, LocalDate day, LocalDateTime timeStart){
        Schedule schedule = getScheduleByDoctorId(doctorId);
        String dayStr = day.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Integer time = ScheduleUtil.localDateTimeToInt(timeStart) ;
        ScheduleUtil.updateScheduleOnDate(schedule, dayStr, time, Const.SCHEDULE_STATUS_EMPTY);
        scheduleDao.updateSchedule(schedule);
        return true;
    }

//    @Async
//    @Scheduled(cron = "0 0 0 ? * 2")
//    public void updateScheduleStartDate(){
//        LocalDate now = LocalDate.now();
//        List<Schedule> schedules = getAllSchedules();
//        for(Schedule schedule : schedules){
//            LocalDate oldDate = schedule.getStartDate();
//            int days = (int) ChronoUnit.DAYS.between(oldDate, now);
//            if(days <= 7 )return;
//            LocalDate newDate = oldDate.plusWeeks(1);
//            schedule.setStartDate(newDate);
//            scheduleDao.updateSchedule(schedule);
//        }
//    }
}
