package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.CheckCode;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CheckCodeDao {
    @Select("SELECT * FROM check_code WHERE email = #{email} AND type=#{type}")
    public CheckCode getByEmailAndType(String email, Integer type);

    @Insert("INSERT INTO check_code (code,type,email,time) VALUES (#{code}, #{type}, #{email}, #{time})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void addCheckCode(CheckCode checkCode);

    @Update("UPDATE check_code SET code=#{code}, type=#{type}, email=#{email}, time=#{time} WHERE id=#{id}")
    public void updateCheckCode(CheckCode checkCode);
    @Delete("DELETE FROM check_code WHERE email = #{email}")
    public void deleteByEmail(String email);
}
