package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Admin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminDao {
    @Select("SELECT * FROM admin WHERE admin_id = #{adminId}")
    public Admin getById(Integer adminId);

    @Insert("INSERT INTO admin (admin_id,admin_password) VALUES (#{adminId},#{adminPassword})")
    public void addAdmin(Admin admin);

    @Update("UPDATE admin SET admin_password = #{adminPassword} WHERE admin_id = #{adminId}")
    public void updateAdmin(Admin admin);

    @Delete("DELETE FROM admin WHERE admin_id = #{adminId}")
    public void deleteAdmin(Admin admin);
}
