package com.se.hmsbackend.service;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.dao.InfoAdminDao;
import com.se.hmsbackend.dao.InfoAdminDetailDao;
import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoAdminDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoAdminService {
    @Autowired
    private InfoAdminDao infoAdminDao;
    @Autowired
    private InfoAdminDetailDao infoAdminDetailDao;

    public List<InfoAdmin> getAllInfoAdmin(){
        return infoAdminDao.getAllInfo();
    }

    public InfoAdminDetail getInfoDetailByID(Integer detailId){
        return infoAdminDetailDao.getById(detailId);
    }

    public InfoAdmin acceptInfo(Integer infoId){
        InfoAdmin infoAdmin = infoAdminDao.getById(infoId);
        infoAdmin.setInfoStatus(Const.INFOADMIN_STATUS_PASSED);
        infoAdminDao.updateInfo(infoAdmin);
        return infoAdmin;
    }

    public InfoAdmin denyInfo(Integer infoId){
        InfoAdmin infoAdmin = infoAdminDao.getById(infoId);
        infoAdmin.setInfoStatus(Const.INFOADMIN_STATUS_DENYED);
        infoAdminDao.updateInfo(infoAdmin);
        return infoAdmin;
    }
}
