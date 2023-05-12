package com.se.hmsbackend.pojo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Schedule {
    private Integer scheduleId;
    private String doctorId;
    private LocalDate startDate;
    private String mon1;
    private String tue1;
    private String wed1;
    private String thu1;
    private String fri1;
    private String sat1;
    private String sun1;
    private String mon2;
    private String tue2;
    private String wed2;
    private String thu2;
    private String fri2;
    private String sat2;
    private String sun2;


    public Schedule() {

    }

    public Schedule(Integer scheduleId, String doctorId, LocalDate startDate, String mon1, String tue1, String wed1, String thu1, String fri1, String sat1, String sun1, String mon2, String tue2, String wed2, String thu2, String fri2, String sat2, String sun2) {
        this.scheduleId = scheduleId;
        this.doctorId = doctorId;
        this.startDate = startDate;
        this.mon1 = mon1;
        this.tue1 = tue1;
        this.wed1 = wed1;
        this.thu1 = thu1;
        this.fri1 = fri1;
        this.sat1 = sat1;
        this.sun1 = sun1;
        this.mon2 = mon2;
        this.tue2 = tue2;
        this.wed2 = wed2;
        this.thu2 = thu2;
        this.fri2 = fri2;
        this.sat2 = sat2;
        this.sun2 = sun2;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "scheduleId=" + scheduleId +
                ", doctorId='" + doctorId + '\'' +
                ", startDate=" + startDate +
                ", mon1='" + mon1 + '\'' +
                ", tue1='" + tue1 + '\'' +
                ", wed1='" + wed1 + '\'' +
                ", thu1='" + thu1 + '\'' +
                ", fri1='" + fri1 + '\'' +
                ", sat1='" + sat1 + '\'' +
                ", sun1='" + sun1 + '\'' +
                ", mon2='" + mon2 + '\'' +
                ", tue2='" + tue2 + '\'' +
                ", wed2='" + wed2 + '\'' +
                ", thu2='" + thu2 + '\'' +
                ", fri2='" + fri2 + '\'' +
                ", sat2='" + sat2 + '\'' +
                ", sun2='" + sun2 + '\'' +
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getMon1() {
        return mon1;
    }

    public void setMon1(String mon1) {
        this.mon1 = mon1;
    }

    public String getTue1() {
        return tue1;
    }

    public void setTue1(String tue1) {
        this.tue1 = tue1;
    }

    public String getWed1() {
        return wed1;
    }

    public void setWed1(String wed1) {
        this.wed1 = wed1;
    }

    public String getThu1() {
        return thu1;
    }

    public void setThu1(String thu1) {
        this.thu1 = thu1;
    }

    public String getFri1() {
        return fri1;
    }

    public void setFri1(String fri1) {
        this.fri1 = fri1;
    }

    public String getSat1() {
        return sat1;
    }

    public void setSat1(String sat1) {
        this.sat1 = sat1;
    }

    public String getSun1() {
        return sun1;
    }

    public void setSun1(String sun1) {
        this.sun1 = sun1;
    }

    public String getMon2() {
        return mon2;
    }

    public void setMon2(String mon2) {
        this.mon2 = mon2;
    }

    public String getTue2() {
        return tue2;
    }

    public void setTue2(String tue2) {
        this.tue2 = tue2;
    }

    public String getWed2() {
        return wed2;
    }

    public void setWed2(String wed2) {
        this.wed2 = wed2;
    }

    public String getThu2() {
        return thu2;
    }

    public void setThu2(String thu2) {
        this.thu2 = thu2;
    }

    public String getFri2() {
        return fri2;
    }

    public void setFri2(String fri2) {
        this.fri2 = fri2;
    }

    public String getSat2() {
        return sat2;
    }

    public void setSat2(String sat2) {
        this.sat2 = sat2;
    }

    public String getSun2() {
        return sun2;
    }

    public void setSun2(String sun2) {
        this.sun2 = sun2;
    }
}
