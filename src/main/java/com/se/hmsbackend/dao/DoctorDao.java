package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Doctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DoctorDao {
    @Select("SELECT COUNT(*) FROM doctor")
    public Integer getNum();
    @Select("SELECT * FROM doctor WHERE doctor_id = #{doctorId}")
    public Doctor getById(String doctorId);

    @Select("SELECT * FROM doctor WHERE doctor_number = #{doctorNumber}")
    public Doctor getByNumber(String doctorNumber);

    @Select("SELECT * FROM doctor WHERE doctor_name = #{doctorName}")
    public List<Doctor> getByName(String doctorName);

    @Insert("INSERT INTO doctor (doctor_id, doctor_name, doctor_number, doctor_mail, doctor_phone, doctor_password, doctor_status, doctor_section,doctor_title,doctor_introduction)" +
            "VALUES (#{doctorId}, #{doctorName}, #{doctorNumber}, #{doctorMail}, #{doctorPhone}, #{doctorPassword}, #{doctorStatus}, #{doctorSection}, #{doctorTitle}, #{doctorIntroduction})" )
    public void addDoctor(Doctor doctor);

    @Update("UPDATE doctor SET doctor_name = #{doctorName}, doctor_number = #{doctorNumber}, doctor_mail = #{doctorMail}, doctor_phone = #{doctorPhone}, doctor_introduction = #{doctorIntroduction}," +
            "doctor_password = #{doctorPassword}, doctor_status = #{doctorStatus}, doctor_section = #{doctorSection}, doctor_title = #{doctorTitle} WHERE doctor_id = #{doctorId}")
    public void updateDoctor(Doctor doctor);

    @Delete("DELETE FROM doctor WHERE doctor_id = #{doctorId}")
    public void deleteDoctor(Doctor doctor);
}
