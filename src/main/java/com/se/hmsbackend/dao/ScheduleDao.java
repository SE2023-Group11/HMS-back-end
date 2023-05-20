package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Schedule;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface ScheduleDao {
    @Select("SELECT * FROM schedule")
    public List<Schedule> getAllSchedules();

    @Select("SELECT * FROM schedule WHERE schedule_id = #{scheduleId}")
    public Schedule getById(Integer scheduleId);

    @Select("SELECT * FROM schedule WHERE doctor_id = #{doctorId}")
    public Schedule getByDoctorId(String doctorId);

    @Insert("INSERT INTO schedule (doctor_id, start_date, mon1, tue1, wed1, thu1, fri1, sat1, sun1," +
            "mon2, tue2, wed2, thu2, fri2, sat2, sun2) " +
            "VALUES (#{doctorId},#{startDate},#{mon1},#{tue1},#{wed1},#{thu1},#{fri1},#{sat1},#{sun1}," +
            "#{mon2},#{tue2},#{wed2},#{thu2},#{fri2},#{sat2},#{sun2})")
    @Options(useGeneratedKeys = true,keyProperty = "scheduleId")
    public void addSchedule(Schedule schedule);

    @Update("UPDATE schedule SET doctor_id=#{doctorId}, start_date=#{startDate}, mon1=#{mon1}, tue1=#{tue1}," +
            "wed1=#{wed1},thu1=#{thu1},fri1=#{fri1},sat1=#{sat1},sun1=#{sun1}," +
            "mon2=#{mon2},tue2=#{tue2},wed2=#{wed2},thu2=#{thu2},fri2=#{fri2}," +
            "sat2=#{sat2},sun2=#{sun2} WHERE schedule_id = #{scheduleId}")
    public void updateSchedule(Schedule schedule);

    @Delete("DELETE FROM schedule WHERE schedule_id = #{scheduleId}")
    public void deleteSchedule(Schedule schedule);
}
