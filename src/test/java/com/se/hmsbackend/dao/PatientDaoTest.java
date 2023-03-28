package com.se.hmsbackend.dao;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.pojo.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class PatientDaoTest {
    @Autowired
    private PatientDao patientDao;

    @Test
    public void addPatientTest(){
        Patient patient = new Patient();
        patient.setPatientId("P00000000002");
        patient.setPatientName("wangwu");
        patient.setPatientNumber("130540200001010293");
        patient.setPatientMail("2604307870@qq.com");
        patient.setPatientPhone("15100932896");
        patient.setPatientSex(Const.PATIENT_SEX_MALE);
        LocalDate birthDay = LocalDate.now();
        patient.setPatientBirthday(birthDay);
        patient.setPatientPassword("123312321");
        patientDao.addPatient(patient);
    }
    @Test
    public void getByIdTest(){
        Patient patient = patientDao.getById("P00000000002");
        System.out.println(patient);
    }
    @Test
    public void getByNumberTest(){
        Patient patient = patientDao.getByNumber("130540200001010293");
        System.out.println(patient);
    }
    @Test
    public void updatePatientTest(){
        Patient patient = patientDao.getById("P00000000002");
        patient.setPatientMail("213");
        patientDao.updatePatient(patient);
    }
    @Test
    public void deletePatientTest(){
        Patient patient = patientDao.getById("P00000000002");
        patientDao.deletePatient(patient);
    }
}
