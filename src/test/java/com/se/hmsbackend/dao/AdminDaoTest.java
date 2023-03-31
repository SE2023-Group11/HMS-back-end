package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Admin;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AdminDaoTest {
    @Autowired
    private AdminDao adminDao;
    @Test
    public void getByIdTest(){
        Admin admin = adminDao.getById(114514);
        System.out.println(admin);
    }
    @Test
    public void addAdminTest(){
        Admin admin = new Admin();
        admin.setAdminId(1234);
        admin.setAdminPassword("114514");
        adminDao.addAdmin(admin);
    }
    @Test
    public void updateAdminTest(){
        Admin admin = adminDao.getById(114514);
        admin.setAdminPassword("1919");
        adminDao.updateAdmin(admin);
    }
    @Test
    public void deleteAdminTest(){
        Admin admin = adminDao.getById(1234);
        adminDao.deleteAdmin(admin);
    }
}
