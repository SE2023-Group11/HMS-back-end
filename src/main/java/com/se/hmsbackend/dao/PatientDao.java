package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Patient;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PatientDao {
    @Select("SELECT COUNT(*) FROM patient")
    public Integer getNum();
    @Select("SELECT * FROM patient WHERE patient_id = #{patientId}")
    public Patient getById(String patientId);

    @Select("SELECT * FROM patient WHERE patient_number = #{patientNumber}")
    public Patient getByNumber(String patientNumber);

    @Insert("INSERT INTO patient (patient_id, patient_name, patient_number, patient_mail, patient_phone, patient_sex, patient_birthday, patient_password, patient_img) " +
            "VALUES (#{patientId}, #{patientName}, #{patientNumber}, #{patientMail}, #{patientPhone}, #{patientSex},#{patientBirthday},#{patientPassword}, #{patientImg})")
    public void addPatient(Patient patient);

    @Update("UPDATE patient SET patient_name = #{patientName},patient_number = #{patientNumber},patient_mail = #{patientMail}, patient_phone=#{patientPhone}," +
            " patient_sex=#{patientSex}, patient_birthday = #{patientBirthday},patient_password = #{patientPassword}, patient_img = #{patientImg} WHERE patient_id = #{patientId}")
    public void updatePatient(Patient patient);

    @Delete("DELETE FROM patient WHERE patient_id = #{patientId}")
    public void deletePatient(Patient patient);
}
