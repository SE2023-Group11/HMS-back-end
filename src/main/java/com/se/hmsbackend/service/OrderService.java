package com.se.hmsbackend.service;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.dao.OrderDao;
import com.se.hmsbackend.pojo.Order;
import com.se.hmsbackend.utils.ScheduleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getAllOrders(){return orderDao.getAllOrders();}
    public Order getByOrderId(Integer orderId) {
        return orderDao.getByOrderId(orderId);
    }

    public List<Order> getByDoctorId(String doctorId) {
        return orderDao.getByDoctorId(doctorId);
    }
    public List<Order> getByPatientId(String patientId) {
        return orderDao.getByPatientId(patientId);
    }
    public boolean addOrder(String patientId, String doctorId, String day, Integer time) {
        LocalDate date = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDateTime timeStart = ScheduleUtil.getLocalDateTime(date, time);
        LocalDateTime timeEnd = ScheduleUtil.getLocalDateTimeED(date, time);

        Order order = new Order();
        order.setPatientId(patientId);
        order.setDoctorId(doctorId);
        order.setDay(date);
        order.setTime_start(timeStart);
        order.setTime_end(timeEnd);
        order.setOrderStatus(Const.ORDER_STATUS_WAITING);

        orderDao.addOrder(order);
        return true;
    }
    public boolean deleteOrder(Integer orderId) {
        orderDao.deleteOrder(orderId);
        return true;
    }
    public boolean updateOrderStatus(Integer orderId, Integer newStatus) {
        Order order = getByOrderId(orderId);
        order.setOrderStatus(newStatus);
        orderDao.updateOrder(order);
        return true;
    }
}
