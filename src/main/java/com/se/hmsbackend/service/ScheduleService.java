package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.ScheduleDao;
import com.se.hmsbackend.pojo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleDao scheduleDao;

    public void addSchedule(Schedule schedule){
        scheduleDao.addSchedule(schedule);
    }
    public Schedule getScheduleByDoctorId(String doctorId){
        return scheduleDao.getByDoctorId(doctorId);
    }
}
