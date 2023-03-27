package com.se.hmsbackend.pojo;

import java.time.LocalDateTime;

public class Order {
    private Integer orderId;
    private String patientId;
    private String doctorId;
    private LocalDateTime day;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Integer orderStatus;

    public Order() {
    }

    public Order(Integer orderId, String patientId, String doctorId, LocalDateTime day, LocalDateTime timeStart, LocalDateTime timeEnd, Integer orderStatus) {
        this.orderId = orderId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.day = day;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", day=" + day +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", orderStatus=" + orderStatus +
                '}';
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

    public LocalDateTime getTime_start() {
        return timeStart;
    }

    public void setTime_start(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTime_end() {
        return timeEnd;
    }

    public void setTime_end(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
