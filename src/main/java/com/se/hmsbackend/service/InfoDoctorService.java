package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.InfoDoctorDao;
import com.se.hmsbackend.pojo.InfoDoctor;
import com.se.hmsbackend.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InfoDoctorService {
    @Autowired
    private InfoDoctorDao infoDoctorDao;
    public List<InfoDoctor> getInfoDoctor(String doctorId){
        List<InfoDoctor> res = infoDoctorDao.getByDoctorId(doctorId);
        res.sort(JsonUtil.orderInfoDoctorByTime);
        return res;
    }
    public boolean sendInfoToDoctor(InfoDoctor infoDoctor){
        infoDoctorDao.addInfo(infoDoctor);
        return true;
    }
}
