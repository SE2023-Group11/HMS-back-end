package com.se.hmsbackend.pojo;

public class Doctor {
    private String doctorId;
    private String doctorName;
    private String doctorNumber;
    private String doctorMail;
    private String doctorPhone;
    private String doctorPassword;
    private Integer doctorSection;
    private String doctorTitle;
    private boolean doctorStatus;
    private String doctorIntroduction;

    public Doctor() {
    }

    public Doctor(String doctorId, String doctorName, String doctorNumber, String doctorMail, String doctorPhone, String doctorPassword, Integer doctorSection, String doctorTitle, boolean doctorStatus, String doctorIntroduction) {
        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.doctorNumber = doctorNumber;
        this.doctorMail = doctorMail;
        this.doctorPhone = doctorPhone;
        this.doctorPassword = doctorPassword;
        this.doctorSection = doctorSection;
        this.doctorTitle = doctorTitle;
        this.doctorStatus = doctorStatus;
        this.doctorIntroduction = doctorIntroduction;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId='" + doctorId + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorNumber='" + doctorNumber + '\'' +
                ", doctorMail='" + doctorMail + '\'' +
                ", doctorPhone='" + doctorPhone + '\'' +
                ", doctorPassword='" + doctorPassword + '\'' +
                ", doctorSection=" + doctorSection +
                ", doctorTitle='" + doctorTitle + '\'' +
                ", doctorStatus=" + doctorStatus +
                ", doctorIntroduction='" + doctorIntroduction + '\'' +
                '}';
    }

    public String getDoctorIntroduction() {
        return doctorIntroduction;
    }

    public void setDoctorIntroduction(String doctorIntroduction) {
        this.doctorIntroduction = doctorIntroduction;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorNumber() {
        return doctorNumber;
    }

    public void setDoctorNumber(String doctorNumber) {
        this.doctorNumber = doctorNumber;
    }

    public String getDoctorMail() {
        return doctorMail;
    }

    public void setDoctorMail(String doctorMail) {
        this.doctorMail = doctorMail;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword;
    }

    public Integer getDoctorSection() {
        return doctorSection;
    }

    public void setDoctorSection(Integer doctorSection) {
        this.doctorSection = doctorSection;
    }

    public String getDoctorTitle() {
        return doctorTitle;
    }

    public void setDoctorTitle(String doctorTitle) {
        this.doctorTitle = doctorTitle;
    }

    public boolean isDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(boolean doctorStatus) {
        this.doctorStatus = doctorStatus;
    }
}
