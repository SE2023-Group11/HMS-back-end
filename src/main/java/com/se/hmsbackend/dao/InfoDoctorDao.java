package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.InfoDoctor;
import com.se.hmsbackend.pojo.InfoPatient;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoDoctorDao {
//    TODO:TESTing
    @Select("SELECT * FROM info_doctor WHERE info_id = #{infoId}")
    public InfoDoctor getById(Integer infoId);

    @Select("SELECT * FROM info_doctor WHERE doctor_id = #{doctorId}")
    public List<InfoDoctor> getByDoctorId(String doctorId);

    @Insert("INSERT INTO info_doctor (doctor_id, info_body) VALUES (#{doctorId}, #{infoBody})")
    @Options(useGeneratedKeys = true,keyProperty = "infoId")
    public void addInfo(InfoDoctor infoDoctor);

    @Update("UPDATE info_doctor SET doctor_id = #{doctorId}, info_body = #{infoBody} WHERE info_id = #{infoId}")
    public void updateInfo(InfoDoctor infoDoctor);

    @Delete("DELETE FROM info_doctor WHERE info_id = #{infoId}")
    public void deleteInfo(InfoDoctor infoDoctor);
}
