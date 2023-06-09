package com.se.hmsbackend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.InfoDoctor;
import com.se.hmsbackend.pojo.InfoPatient;
import com.se.hmsbackend.pojo.Order;
import com.se.hmsbackend.pojo.Patient;
import com.se.hmsbackend.service.*;
import com.se.hmsbackend.utils.InfoUtil;
import com.se.hmsbackend.utils.JsonUtil;
import com.se.hmsbackend.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    public R<List<JSONObject>> getAppointmentListDoctor(HttpServletRequest request, @RequestParam String token){
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        List<Order> orderList = orderService.getByDoctorId(nowLoggedInId);
        List<JSONObject> jsonObjectList = new ArrayList<>();
        for(Order order : orderList){
            JSONObject jsonObject = (JSONObject) JSON.toJSON(order);
            Patient patient = patientService.getPatientById(order.getPatientId());
            jsonObject.put("patientName", patient.getPatientName());
            jsonObjectList.add(jsonObject);
        }
        jsonObjectList.sort(JsonUtil.orderOrderByTime);
        return R.success(jsonObjectList);
    }

    @GetMapping("/getPatientAppointment")
    public R<List<Order>> getAppointmentListPatient(HttpServletRequest request,@RequestParam String token){
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        return R.success(orderService.getByPatientId(nowLoggedInId));
    }

    @Transactional
    @PostMapping("/addAppointment")
    public R<String> addAppointment(HttpServletRequest request, @RequestParam String doctorId, @RequestParam String day, @RequestParam Integer time,@RequestParam String token){
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
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
//        判断是否是在一天前取消预约
        LocalDate nowDay = LocalDate.now();
        LocalDate ordDay = order.getDay();
        if(!nowDay.isBefore(ordDay))return R.error("必须在约定时间一天前取消预约");
//        取消预约
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
        if(orderService.updateOrderStatus(orderId,Const.ORDER_STATUS_FINISHED))return R.success("操作成功");
        return R.error("操作失败");
    }
}
