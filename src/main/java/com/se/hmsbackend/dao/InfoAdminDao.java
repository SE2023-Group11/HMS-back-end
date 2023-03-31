package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoDoctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoAdminDao {
//    TODO:Testing
    @Select("SELECT * FROM info_admin WHERE info_id = #{infoId}")
    public InfoDoctor getById(Integer infoId);

    @Select("SELECT * FROM info_admin WHERE admin_id = #{adminId}")
    public List<InfoAdmin> getByAdminId(Integer adminId);

    @Insert("INSERT INTO info_admin (admin_id, info_body, info_type) VALUES (#{adminId}, #{infoBody}, #{infoType})")
    @Options(useGeneratedKeys = true,keyProperty = "infoId")
    public void addInfo(InfoAdmin infoAdmin);

    @Update("UPDATE info_admin SET admin_id = #{adminId}, info_body = #{infoBody}, info_type = #{infoType} WHERE info_id = #{infoId}")
    public void updateInfo(InfoAdmin infoAdmin);

    @Delete("DELETE FROM info_admin WHERE info_id = #{infoId}")
    public void deleteInfo(InfoAdmin infoAdmin);
}
