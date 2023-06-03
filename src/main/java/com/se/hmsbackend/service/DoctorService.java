package com.se.hmsbackend.service;

import com.se.hmsbackend.common.Const;
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
        List<Doctor> doctors = doctorDao.getByName(doctorName);
        doctors.removeIf(doctor -> doctor.isDoctorStatus() == Const.DOCTOR_STATUS_UNVERIFIED);
        return doctors;
    }
    public List<Doctor> getAllDoctor(){
        List<Doctor> doctors = doctorDao.getAllDoctor();
        doctors.removeIf(doctor -> doctor.isDoctorStatus() == Const.DOCTOR_STATUS_UNVERIFIED);
        return doctors;
    }
    public Doctor getDoctorById(String doctorId){
        try {
            Doctor doctor = doctorDao.getById(doctorId);
            if(doctor.isDoctorStatus())return doctor;
            return null;
        }catch (Exception e){
            return null;
        }
    }
    public Doctor getDoctorByNumber(String number){
        try {
            Doctor doctor = doctorDao.getByNumber(number);
            if(doctor.isDoctorStatus())return doctor;
            return null;
        }catch (Exception e){
            return null;
        }
    }
    public Doctor getDoctorByMail(String mail){
        Doctor doctor = doctorDao.getByMail(mail);
        if(doctor.isDoctorStatus() == Const.DOCTOR_STATUS_UNVERIFIED)return null;
        return doctor;
    }
    public List<Doctor> getDoctorBySectionId(Integer sectionId){
        List<Doctor> doctors = doctorDao.getBySectionId(sectionId);
        doctors.removeIf(doctor -> doctor.isDoctorStatus() == Const.DOCTOR_STATUS_UNVERIFIED);
        return doctors;
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

