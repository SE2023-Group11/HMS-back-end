package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.InfoPatientDao;
import com.se.hmsbackend.pojo.InfoPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoPatientService {
    @Autowired
    private InfoPatientDao infoPatientDao;

    public List<InfoPatient> getInfoPatient(String patientId){
        return infoPatientDao.getByPatientId(patientId);
    }
}
