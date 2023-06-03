package com.se.hmsbackend.pojo;

import java.time.LocalDateTime;

public class InfoPatient {
    private Integer infoId;
    private String patientId;
    private String infoBody;
    private LocalDateTime infoTime;
    public InfoPatient() {
    }

    public InfoPatient(Integer infoId, String patientId, String infoBody, LocalDateTime infoTime) {
        this.infoId = infoId;
        this.patientId = patientId;
        this.infoBody = infoBody;
        this.infoTime = infoTime;
    }

    @Override
    public String toString() {
        return "InfoPatient{" +
                "infoId=" + infoId +
                ", patientId='" + patientId + '\'' +
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

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getInfoBody() {
        return infoBody;
    }

    public void setInfoBody(String infoBody) {
        this.infoBody = infoBody;
    }
}
