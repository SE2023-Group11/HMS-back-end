package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.InfoPatientDao;
import com.se.hmsbackend.pojo.InfoPatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class InfoPatientService {
    @Autowired
    private InfoPatientDao infoPatientDao;

    public List<InfoPatient> getInfoPatient(String patientId){
        return infoPatientDao.getByPatientId(patientId);
    }

    public boolean sendInfoToPatient(InfoPatient info){
        infoPatientDao.addInfo(info);
        return true;
    }
}
