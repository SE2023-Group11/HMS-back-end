package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoDoctor;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoAdminDao {
//    TODO:Testing
    @Select("SELECT * FROM info_admin")
    public List<InfoAdmin> getAllInfo();
    @Select("SELECT * FROM info_admin WHERE info_id = #{infoId}")
    public InfoAdmin getById(Integer infoId);
    @Insert("INSERT INTO info_admin (detail_id, info_type, info_status) VALUES (#{detailId}, #{infoType}, #{infoStatus})")
    @Options(useGeneratedKeys = true,keyProperty = "infoId")
    public void addInfo(InfoAdmin infoAdmin);

    @Update("UPDATE info_admin SET detail_id = #{detailId}, info_type = #{infoType}, info_status = #{infoStatus} WHERE info_id = #{infoId}")
    public void updateInfo(InfoAdmin infoAdmin);

    @Delete("DELETE FROM info_admin WHERE info_id = #{infoId}")
    public void deleteInfo(InfoAdmin infoAdmin);
}
