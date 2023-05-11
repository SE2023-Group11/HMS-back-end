package com.se.hmsbackend.dao;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.pojo.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
public class OrderDaoTest {
    @Autowired
    private OrderDao orderDao;

//    @Test
//    public void addOrderTest(){
//        LocalDate day = LocalDate.parse("2023-03-28", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        LocalDateTime timeStart = LocalDateTime.parse("2023-03-28 14:20:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        LocalDateTime timeEnd = LocalDateTime.parse("2023-03-28 14:40:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
//        Order order = new Order(0,"P00000000001","D00000000001",day,timeStart,timeEnd, Const.ORDER_STATUS_WAITING);
//        orderDao.addOrder(order);
//        System.out.println(order.getOrderId());
//    }
//    @Test
//    public void deleteOrderTest(){
//        orderDao.deleteOrder(4);
//    }
//    @Test
//    public void getByOrderIdTest(){
//        Order order = orderDao.getByOrderId(1);
//        System.out.println(order);
//    }
//    @Test
//    public void updateOrderTest(){
//        Order order = orderDao.getByOrderId(1);
//        order.setOrderStatus(1);
//        orderDao.updateOrder(order);
//    }
//    @Test
//    public void getByPatientIdTest(){
//        List<Order> orders = orderDao.getByPatientId("P00000000001");
//        System.out.println(orders);
//    }
//    @Test
//    public void getByDoctorIdTest(){
//        List<Order> orders = orderDao.getByPatientId("P00000000001");
//        System.out.println(orders);
//    }
}
