package com.se.hmsbackend.pojo;

public class InfoDoctor {
    private Integer infoId;
    private String doctorId;
    private String infoBody;

    public InfoDoctor() {
    }

    public InfoDoctor(Integer infoId, String doctorId, String infoBody) {
        this.infoId = infoId;
        this.doctorId = doctorId;
        this.infoBody = infoBody;
    }

    @Override
    public String toString() {
        return "InfoDoctor{" +
                "infoId=" + infoId +
                ", doctorId='" + doctorId + '\'' +
                ", infoBody='" + infoBody + '\'' +
                '}';
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
