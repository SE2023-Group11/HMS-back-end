package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.OrderDao;
import com.se.hmsbackend.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getByDoctorId(String doctorId) {
        return orderDao.getByDoctorId(doctorId);
    }
    public List<Order> getByPatientId(String patientId) {
        return orderDao.getByPatientId(patientId);
    }
}
