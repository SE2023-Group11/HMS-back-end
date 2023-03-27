package com.se.hmsbackend.pojo;

public class InfoPatient {
    private Integer infoId;
    private String patientId;
    private String infoBody;

    public InfoPatient() {
    }

    public InfoPatient(Integer infoId, String patientId, String infoBody) {
        this.infoId = infoId;
        this.patientId = patientId;
        this.infoBody = infoBody;
    }

    @Override
    public String toString() {
        return "InfoPatient{" +
                "infoId=" + infoId +
                ", patientId='" + patientId + '\'' +
                ", infoBody='" + infoBody + '\'' +
                '}';
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
