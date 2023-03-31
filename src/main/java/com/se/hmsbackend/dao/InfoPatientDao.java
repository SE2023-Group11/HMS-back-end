package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.InfoPatient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoPatientDao {
//    TODO:Testing
    @Select("SELECT * FROM info_patient WHERE info_id = #{infoId}")
    public InfoPatient getById(Integer infoId);

    @Select("SELECT * FROM info_patient WHERE patient_id = #{patientId}")
    public List<InfoPatient> getByPatientId(String patientId);

    @Insert("INSERT INTO info_patient (patient_id, info_body) VALUES (#{patientId}, #{infoBody})")
    @Options(useGeneratedKeys = true,keyProperty = "infoId")
    public void addInfo(InfoPatient infoPatient);

    @Update("UPDATE info_patient SET patient_id = #{patientId}, info_body = #{infoBody} WHERE info_id = #{infoId}")
    public void updateInfo(InfoPatient infoPatient);

    @Delete("DELETE FROM info_patient WHERE info_id = #{infoId}")
    public void deleteInfo(InfoPatient infoPatient);
}
