package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Schedule;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ScheduleDao {
    @Select("SELECT * FROM schedule WHERE schedule_id = #{scheduleId}")
    public Schedule getById(Integer scheduleId);

    @Select("SELECT * FROM schedule WHERE doctor_id = #{doctorId}")
    public List<Schedule> getByDoctorId(String doctorId);

    @Select("SELECT * FROM schedule WHERE doctor_id = #{doctorId} AND day = #{day}")
    public List<Schedule> getByDoctorIdAndDay(String doctorId, LocalDate day);

    @Select("SELECT * FROM schedule WHERE doctor_id = #{doctorId} AND time_start = #{timeStart} AND time_end = #{timeEnd}")
    public Schedule getByDoctorIdAndTime(String doctorId, LocalDateTime timeStart, LocalDateTime timeEnd);

    @Insert("INSERT INTO schedule (doctor_id, day, time_start, time_end,schedule_status) " +
            "VALUES (#{doctorId},#{day},#{timeStart},#{timeEnd},#{scheduleStatus})")
    @Options(useGeneratedKeys = true,keyProperty = "scheduleId")
    public void addSchedule(Schedule schedule);

    @Update("UPDATE schedule SET doctor_id=#{doctorId}, time_start=#{timeStart}, time_end=#{timeEnd}, " +
            "schedule_status=#{scheduleStatus} WHERE schedule_id = #{scheduleId}")
    public void updateSchedule(Schedule schedule);

    @Delete("DELETE FROM schedule WHERE schedule_id = #{scheduleId}")
    public void deleteSchedule(Schedule schedule);
}
