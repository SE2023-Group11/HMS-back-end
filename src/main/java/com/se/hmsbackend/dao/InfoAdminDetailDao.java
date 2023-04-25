package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoAdminDetail;
import com.se.hmsbackend.pojo.InfoDoctor;
import org.apache.ibatis.annotations.*;

@Mapper
public interface InfoAdminDetailDao {
    @Select("SELECT * FROM info_admin_detail WHERE detail_id = #{detailId}")
    public InfoAdminDetail getById(Integer detailId);

    @Insert("INSERT INTO info_admin_detail (detail_id,doctor_id, doctor_name, doctor_number, doctor_mail, doctor_phone, doctor_password, doctor_status, doctor_section,doctor_title,doctor_introduction)" +
            "VALUES (#{detailID},#{doctorId}, #{doctorName}, #{doctorNumber}, #{doctorMail}, #{doctorPhone}, #{doctorPassword}, #{doctorStatus}, #{doctorSection}, #{doctorTitle}, #{doctorIntroduction})" )
    @Options(useGeneratedKeys = true,keyProperty = "detailId")
    public void addInfo(InfoAdminDetail infoAdminDetail);

    @Update("UPDATE info_admin_detail SET doctor_id=#{doctorId}, doctor_name = #{doctorName}, doctor_number = #{doctorNumber}, doctor_mail = #{doctorMail}, doctor_phone = #{doctorPhone}, doctor_introduction = #{doctorIntroduction}," +
            "doctor_password = #{doctorPassword}, doctor_status = #{doctorStatus}, doctor_section = #{doctorSection}, doctor_title = #{doctorTitle} WHERE detail_id = #{detailId}")
    public void updateInfo(InfoAdminDetail detailAdminDetail);

    @Delete("DELETE FROM info_admin_detail WHERE detail_id = #{detailId}")
    public void deleteInfo(InfoAdminDetail detailAdminDetail);
}
