package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.PatientDao;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @Autowired
    private PatientDao patientDao;

    public Patient getPatientById(String patientId) {
        return patientDao.getById(patientId);
    }
    public Patient getPatientByNumber(String number){
        return patientDao.getByNumber(number);
    }
    public Patient getPatientByMail(String mail){
        return patientDao.getByMail(mail);
    }
    public boolean updatePatient(Patient patient){
        patientDao.updatePatient(patient);
        return true;
    }
    public boolean hasNumber(String number){
        Patient patient = patientDao.getByNumber(number);
        return patient!=null;
    }
    public boolean hasMail(String mail){
        Patient patient = patientDao.getByMail(mail);
        return patient!=null;
    }
    private String pad(int length,long num){
        return String.format("%0".concat(String.valueOf(length)).concat("d"), num);
    }
    public String getNewPatientId(){
        return "P"+pad(11,patientDao.getNum());
    }
    public boolean addPatient(Patient patient){
        patientDao.addPatient(patient);
        return true;
    }
}
