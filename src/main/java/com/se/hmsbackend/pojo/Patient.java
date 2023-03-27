package com.se.hmsbackend.pojo;

import java.time.LocalDateTime;

public class Patient {
    private String patientId;
    private String patientName;
    private String patientNumber;
    private String patientMail;
    private String patientPhone;
    private boolean patientSex;
    private LocalDateTime patientBirthday;
    private String patientPassword;

    public Patient() {
    }

    public Patient(String patientId, String patientName, String patientNumber, String patientMail, String patientPhone, boolean patientSex, LocalDateTime patientBirthday, String patientPassword) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientNumber = patientNumber;
        this.patientMail = patientMail;
        this.patientPhone = patientPhone;
        this.patientSex = patientSex;
        this.patientBirthday = patientBirthday;
        this.patientPassword = patientPassword;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", patientName='" + patientName + '\'' +
                ", patientNumber='" + patientNumber + '\'' +
                ", patientMail='" + patientMail + '\'' +
                ", patientPhone='" + patientPhone + '\'' +
                ", patientSex=" + patientSex +
                ", patientBirthday=" + patientBirthday +
                ", patientPassword='" + patientPassword + '\'' +
                '}';
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientMail() {
        return patientMail;
    }

    public void setPatientMail(String patientMail) {
        this.patientMail = patientMail;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public boolean isPatientSex() {
        return patientSex;
    }

    public void setPatientSex(boolean patientSex) {
        this.patientSex = patientSex;
    }

    public LocalDateTime getPatientBirthday() {
        return patientBirthday;
    }

    public void setPatientBirthday(LocalDateTime patientBirthday) {
        this.patientBirthday = patientBirthday;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }
}
