package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.AdminDao;
import com.se.hmsbackend.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public Admin getAdminById(Integer id){
        return adminDao.getById(id);
    }
}
