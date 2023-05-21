package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.CheckCodeDao;
import com.se.hmsbackend.pojo.CheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CheckCodeService {
    @Autowired
    private CheckCodeDao checkCodeDao;

    public CheckCode getByEmailAndType(String email, Integer type){
        try {
            return checkCodeDao.getByEmailAndType(email,type);
        }catch (Exception e){
            return null;
        }
    }

    public boolean addCheckCode(Integer type, String email, String code){
        try {
            CheckCode checkCode = new CheckCode();
            checkCode.setEmail(email);
            checkCode.setType(type);
            checkCode.setCode(code);
            checkCode.setTime(LocalDateTime.now());
            checkCodeDao.addCheckCode(checkCode);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String getCode(Integer type, String email){
        try {
            CheckCode checkCode = getByEmailAndType(email,type);
            return checkCode.getCode();
        }catch (Exception e){
            return null;
        }
    }
}
