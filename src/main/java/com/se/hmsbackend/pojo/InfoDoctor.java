package com.se.hmsbackend.pojo;

import java.time.LocalDateTime;

public class InfoDoctor {
    private Integer infoId;
    private String doctorId;
    private String infoBody;
    private LocalDateTime infoTime;

    public InfoDoctor() {
    }

    public InfoDoctor(Integer infoId, String doctorId, String infoBody, LocalDateTime infoTime) {
        this.infoId = infoId;
        this.doctorId = doctorId;
        this.infoBody = infoBody;
        this.infoTime = infoTime;
    }

    @Override
    public String toString() {
        return "InfoDoctor{" +
                "infoId=" + infoId +
                ", doctorId='" + doctorId + '\'' +
                ", infoBody='" + infoBody + '\'' +
                ", infoTime=" + infoTime +
                '}';
    }

    public LocalDateTime getInfoTime() {
        return infoTime;
    }

    public void setInfoTime(LocalDateTime infoTime) {
        this.infoTime = infoTime;
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getInfoBody() {
        return infoBody;
    }

    public void setInfoBody(String infoBody) {
        this.infoBody = infoBody;
    }
}
