package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Order;
import com.se.hmsbackend.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/getAppointmentList")
    public R<List<Order>> getAppointmentListDoctor(HttpServletRequest request){
        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        return R.success(orderService.getByDoctorId(nowLoggedInId));
    }

    @GetMapping("/getPatientAppointment")
    public R<List<Order>> getAppointmentListPatient(HttpServletRequest request){
        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        return R.success(orderService.getByPatientId(nowLoggedInId));
    }

    @PostMapping("/addAppointment")
    public R<String> addAppointment(HttpServletRequest request){
//    TODO:
        return R.error("test");
    }
}
