package com.se.hmsbackend.timer;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.pojo.Order;
import com.se.hmsbackend.pojo.Schedule;
import com.se.hmsbackend.service.OrderService;
import com.se.hmsbackend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Component
public class staticTimer {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ScheduleService scheduleService;
    @Async
    @Scheduled(cron = "0 0 4 * * ?")
    public void orderBroken(){
        LocalDate day = LocalDate.now();
        day = day.minusDays(1);
        List<Order> orders = orderService.getAllOrders();
        for(Order order : orders){
            if(day.equals(order.getDay()) && Const.ORDER_STATUS_WAITING.equals(order.getOrderStatus())){
                orderService.updateOrderStatus(order.getOrderId(), Const.ORDER_STATUS_BROKEN);
            }
        }
    }
    @Async
    @Scheduled(cron = "0 0 0 ? * 2")
    public void updateScheduleStartDate(){
        LocalDate now = LocalDate.now();
        List<Schedule> schedules = scheduleService.getAllSchedules();
        for(Schedule schedule : schedules){
            LocalDate oldDate = schedule.getStartDate();
            int days = (int) ChronoUnit.DAYS.between(oldDate, now);
            if(days <= 7 )return;
            LocalDate newDate = oldDate.plusWeeks(1);
            schedule.setStartDate(newDate);
            scheduleService.updateSchedule(schedule);
        }
    }
}
