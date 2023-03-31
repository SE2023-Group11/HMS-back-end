package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DoctorDaoTest {
    @Autowired
    private DoctorDao doctorDao;

    @Test
    public void addDoctorTest(){
        Doctor doctor = new Doctor();
        doctor.setDoctorId("D00000000002");
        doctor.setDoctorName("Doctor");
        doctor.setDoctorNumber("130202133009876543");
        doctor.setDoctorMail("2604307870@qq.ccom");
        doctor.setDoctorPhone("12312331233");
        doctor.setDoctorPassword("213");
        doctor.setDoctorStatus(true);
        doctor.setDoctorSection(1);
        doctor.setDoctorTitle("Doctor");
        doctorDao.addDoctor(doctor);
    }
    @Test
    public void getByIdTest(){
        Doctor doctor = doctorDao.getById("D00000000002");
        System.out.println(doctor);
    }
    @Test
    public void getByNumberTest(){
        Doctor doctor = doctorDao.getByNumber("130535100000002345");
        System.out.println(doctor);
    }
    @Test
    public void updateDoctorTest(){
        Doctor doctor = doctorDao.getByNumber("130535100000002345");
        doctor.setDoctorName("zhangsan");
        doctorDao.updateDoctor(doctor);
    }
    @Test
    public void deleteDoctorTest(){
        Doctor doctor = doctorDao.getById("D00000000002");
        doctorDao.deleteDoctor(doctor);
    }
}
