package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface OrderDao {
    @Select("SELECT * FROM `order`")
    public List<Order> getAllOrders();

    @Select("SELECT * FROM `order` WHERE order_id = #{orderId}")
    public Order getByOrderId(Integer orderId);

    @Select("SELECT * FROM `order` WHERE patient_id = #{patientId}")
    public List<Order> getByPatientId(String patientId);

    @Select("SELECT * FROM `order` WHERE doctor_id = #{doctorId}")
    public List<Order> getByDoctorId(String doctorId);

    @Insert("Insert INTO `order` (patient_id,doctor_id,`day`,time_start,time_end,order_status) " +
            "VALUES (#{patientId}, #{doctorId}, #{day}, #{timeStart}, #{timeEnd}, #{orderStatus})")
    @Options(useGeneratedKeys = true,keyProperty = "orderId")
    public void addOrder(Order order);

    @Update("UPDATE `order` SET patient_id=#{patientId},doctor_id=#{doctorId},day=#{day},time_start=#{timeStart}," +
            "time_end=#{timeEnd},order_status=#{orderStatus} WHERE order_id=#{orderId}")
    public void updateOrder(Order order);

    @Delete("DELETE FROM `order` WHERE order_id=#{orderId}")
    public void deleteOrder(Integer orderId);
}
