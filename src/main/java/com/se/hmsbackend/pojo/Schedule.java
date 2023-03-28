package com.se.hmsbackend.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Schedule {
    private Integer scheduleId;
    private String doctorId;
    private LocalDate day;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Integer scheduleStatus;

    public Schedule() {
    }

    public Schedule(Integer scheduleId, String doctorId, LocalDate day, LocalDateTime timeStart, LocalDateTime timeEnd, Integer scheduleStatus) {
        this.scheduleId = scheduleId;
        this.doctorId = doctorId;
        this.day = day;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.scheduleStatus = scheduleStatus;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", doctorId='" + doctorId + '\'' +
                ", day=" + day +
                ", timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", scheduleStatus=" + scheduleStatus +
                '}';
    }

    public Integer getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Integer scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public LocalDateTime getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(LocalDateTime timeStart) {
        this.timeStart = timeStart;
    }

    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(LocalDateTime timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getScheduleStatus() {
        return scheduleStatus;
    }

    public void setScheduleStatus(Integer scheduleStatus) {
        this.scheduleStatus = scheduleStatus;
    }
}
