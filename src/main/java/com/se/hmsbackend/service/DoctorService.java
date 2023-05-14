package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.DoctorDao;
import com.se.hmsbackend.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import java.util.List;

@Service
@Transactional
public class DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    public List<Doctor> getDoctorInfo(String doctorName){
        return doctorDao.getByName(doctorName);
    }
    public List<Doctor> getAllDoctor(){
        return doctorDao.getAllDoctor();
    }
    public Doctor getDoctorById(String doctorId){
        return doctorDao.getById(doctorId);
    }
    public Doctor getDoctorByNumber(String number){
        return doctorDao.getByNumber(number);
    }
    public Doctor getDoctorByMail(String mail){
        return doctorDao.getByMail(mail);
    }
    public List<Doctor> getDoctorBySectionId(Integer sectionId){
        return doctorDao.getBySectionId(sectionId);
    }
    public boolean updateDoctor(Doctor doctor){
        doctorDao.updateDoctor(doctor);
        return true;
    }
    public Doctor changeDoctorInfo(String doctorId, String doctorInfo)
    {
        Doctor doctor = doctorDao.getById(doctorId);
        if(doctor == null)return doctor;
        doctor.setDoctorIntroduction(doctorInfo);
        doctorDao.updateDoctor(doctor);
        return doctor;
    }
    private String pad(int length,long num){
        return String.format("%0".concat(String.valueOf(length)).concat("d"), num);
    }
    public String getNewDoctorId(){
        return "D"+pad(11,doctorDao.getNum());
    }
    public boolean hasNumber(String number){
        Doctor doctor = doctorDao.getByNumber(number);
        return doctor!=null;
    }
    public boolean hasMail(String mail){
        Doctor doctor = doctorDao.getByMail(mail);
        return doctor!=null;
    }
    public boolean addDoctor(Doctor doctor){
        doctorDao.addDoctor(doctor);
        return true;
    }

}

