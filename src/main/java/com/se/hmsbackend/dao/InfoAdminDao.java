package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoDoctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoAdminDao {
//    TODO:Testing
    @Select("SELECT * FROM info_admin WHERE info_id = #{infoId}")
    public InfoAdmin getById(Integer infoId);

    @Select("SELECT * FROM info_admin WHERE admin_id = #{adminId}")
    public List<InfoAdmin> getByAdminId(Integer adminId);

    @Insert("INSERT INTO info_admin (admin_id, detail_id, info_type, info_status) VALUES (#{adminId}, #{detailId}, #{infoType}, #{infoStatus})")
    @Options(useGeneratedKeys = true,keyProperty = "infoId")
    public void addInfo(InfoAdmin infoAdmin);

    @Update("UPDATE info_admin_detail SET doctor_id=#{doctorId}, doctor_name = #{doctorName}, doctor_number = #{doctorNumber}, doctor_mail = #{doctorMail}, doctor_phone = #{doctorPhone}, doctor_introduction = #{doctorIntroduction}," +
            "doctor_password = #{doctorPassword}, doctor_status = #{doctorStatus}, doctor_section = #{doctorSection}, doctor_title = #{doctorTitle} WHERE detail_id = #{detailId}")
    public void updateInfo(InfoAdmin infoAdmin);

    @Delete("DELETE FROM info_admin WHERE info_id = #{infoId}")
    public void deleteInfo(InfoAdmin infoAdmin);
}
