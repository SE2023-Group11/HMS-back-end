package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.AdminDao;
import com.se.hmsbackend.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public Admin getAdminById(Integer id){
        try {
            return adminDao.getById(id);
        }catch (Exception e){
            return null;
        }
    }
}
