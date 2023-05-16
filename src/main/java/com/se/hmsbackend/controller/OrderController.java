package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Order;
import com.se.hmsbackend.service.OrderService;
import com.se.hmsbackend.service.ScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ScheduleService scheduleService;

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

    @Transactional
    @PostMapping("/addAppointment")
    public R<String> addAppointment(HttpServletRequest request, @RequestParam String doctorId, @RequestParam String day, @RequestParam Integer time){
        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        if(orderService.addOrder(nowLoggedInId,doctorId,day,time)){
            scheduleService.updateScheduleToWork(doctorId,day,time);
            return R.success("预约成功");
        }
        return R.error("预约失败");
    }
    @Transactional
    @DeleteMapping("/deleteAppointment")
    public R<String> deleteAppointment(HttpServletRequest request, @RequestParam Integer orderId){
        Order order = orderService.getByOrderId(orderId);
        if(orderService.deleteOrder(orderId)){
            scheduleService.updateScheduleToEmpty(order.getDoctorId(),order.getDay(),order.getTime_start());
            return R.success("操作成功");
        }
        return R.error("操作失败");
    }
    @Transactional
    @PostMapping("/ChangeAppointmentStatus")
    public R<String> changeAppointmentStatus(HttpServletRequest request, @RequestParam Integer orderId){
        Order order = orderService.getByOrderId(orderId);
        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        if(orderService.updateOrderStatus(orderId,Const.ORDER_STATUS_FINISHED))return R.success("操作成功");
        return R.error("操作失败");
    }
}
