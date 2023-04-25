package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.DoctorDao;
import com.se.hmsbackend.pojo.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorDao doctorDao;

    public List<Doctor> getDoctorInfo(String doctorName){
        return doctorDao.getByName(doctorName);
    }

    public Doctor changeDoctorInfo(String doctorId, String doctorInfo)
    {
        Doctor doctor = doctorDao.getById(doctorId);
        if(doctor == null)return doctor;
        doctor.setDoctorIntroduction(doctorInfo);
        doctorDao.updateDoctor(doctor);
        return doctor;
    }
}

