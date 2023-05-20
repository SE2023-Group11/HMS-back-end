package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.InfoDoctor;
import com.se.hmsbackend.pojo.InfoPatient;
import com.se.hmsbackend.pojo.Order;
import com.se.hmsbackend.service.*;
import com.se.hmsbackend.utils.InfoUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.time.LocalDateTime;
import java.util.List;

@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ScheduleService scheduleService;
    @Autowired
    private InfoPatientService infoPatientService;
    @Autowired
    private InfoDoctorService infoDoctorService;
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private PatientService patientService;

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
//            更改排班信息
            scheduleService.updateScheduleToWork(doctorId,day,time);
//            向患者发送消息通知
            infoPatientService.sendInfoToPatient(InfoUtil.getInfoPatientOnOrderSuccess(nowLoggedInId, doctorService.getDoctorById(doctorId),day, time));
//            向医生发送消息通知
            infoDoctorService.sendInfoToDoctor(InfoUtil.getInfoDoctorOnOrderSuccess(doctorId, patientService.getPatientById(nowLoggedInId), day, time));
            return R.success("预约成功");
        }
        return R.error("预约失败");
    }
    @Transactional
    @DeleteMapping("/deleteAppointment")
    public R<String> deleteAppointment(HttpServletRequest request, @RequestParam Integer orderId){
        Order order = orderService.getByOrderId(orderId);
        String patientId = order.getPatientId();
        String doctorId = order.getDoctorId();
        if(orderService.deleteOrder(orderId)){
//            更改排班信息
            scheduleService.updateScheduleToEmpty(order.getDoctorId(),order.getDay(),order.getTime_start());
//            向患者发送消息通知
            infoPatientService.sendInfoToPatient(InfoUtil.getInfoPatientOnOrderDeleted(patientId, doctorService.getDoctorById(doctorId),order.getTime_start()));
//            向医生发送消息通知
            infoDoctorService.sendInfoToDoctor(InfoUtil.getInfoDoctorOnOrderDeleted(doctorId, patientService.getPatientById(patientId), order.getTime_start()));
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
