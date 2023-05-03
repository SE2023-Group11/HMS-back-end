package com.se.hmsbackend.service;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.dao.DoctorDao;
import com.se.hmsbackend.dao.InfoAdminDao;
import com.se.hmsbackend.dao.InfoAdminDetailDao;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoAdminDetail;
import com.se.hmsbackend.utils.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoAdminService {
    @Autowired
    private InfoAdminDao infoAdminDao;
    @Autowired
    private InfoAdminDetailDao infoAdminDetailDao;
    @Autowired
    private DoctorDao doctorDao;

    public List<InfoAdmin> getAllInfoAdmin(){
        List<InfoAdmin> infoAdminList = infoAdminDao.getAllInfo();
        for(InfoAdmin infoAdmin : infoAdminList){
            if(!Const.INFOADMIN_STATUS_WAITING.equals(infoAdmin.getInfoStatus())){
                infoAdminList.remove(infoAdmin);
            }
        }
        return infoAdminList;
    }

    public InfoAdminDetail getInfoDetailByID(Integer detailId){
        return infoAdminDetailDao.getById(detailId);
    }

    public InfoAdmin acceptInfo(Integer infoId){
        InfoAdmin infoAdmin = infoAdminDao.getById(infoId);
        infoAdmin.setInfoStatus(Const.INFOADMIN_STATUS_PASSED);
        infoAdminDao.updateInfo(infoAdmin);

        InfoAdminDetail infoAdminDetail = infoAdminDetailDao.getById(infoAdmin.getDetailId());
        Doctor doctor = TransferUtil.infoAdminDetailToDoctor(infoAdminDetail);
        Integer type = infoAdmin.getInfoType();
        if(type.equals(Const.INFOADMIN_TYPE_REGISTER)){
            doctor.setDoctorStatus(Const.DOCTOR_STATUS_VERIFIED);
            doctorDao.updateDoctorExceptPW(doctor);
        } else if(type.equals(Const.INFOADMIN_TYPE_UPDATE)){
            doctorDao.updateDoctorExceptPW(doctor);
        }
        return infoAdmin;
    }

    public InfoAdmin denyInfo(Integer infoId){
        InfoAdmin infoAdmin = infoAdminDao.getById(infoId);
        infoAdmin.setInfoStatus(Const.INFOADMIN_STATUS_DENYED);
        infoAdminDao.updateInfo(infoAdmin);
        return infoAdmin;
    }

    public void addInfo(Integer type, Doctor doctor){
        InfoAdminDetail infoAdminDetail = TransferUtil.doctorToInfoAdminDetail(doctor);
        infoAdminDetailDao.addInfo(infoAdminDetail);

        InfoAdmin infoAdmin = new InfoAdmin();
        infoAdmin.setDetailId(infoAdminDetail.getDetailId());
        infoAdmin.setInfoType(type);
        infoAdmin.setInfoStatus(Const.INFOADMIN_STATUS_WAITING);
        infoAdminDao.addInfo(infoAdmin);
    }
}
