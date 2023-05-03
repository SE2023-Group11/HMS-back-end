package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.InfoDoctorDao;
import com.se.hmsbackend.pojo.InfoDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoDoctorService {
    @Autowired
    private InfoDoctorDao infoDoctorDao;
    public List<InfoDoctor> getInfoDoctor(String doctorId){
        return infoDoctorDao.getByDoctorId(doctorId);
    }
}
