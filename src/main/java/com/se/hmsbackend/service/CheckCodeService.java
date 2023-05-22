package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.CheckCodeDao;
import com.se.hmsbackend.pojo.CheckCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class CheckCodeService {
    @Autowired
    private CheckCodeDao checkCodeDao;

    public CheckCode getByEmailAndType(String email, Integer type){
        try {
            CheckCode checkCode = checkCodeDao.getByEmailAndType(email,type);
            LocalDateTime now = LocalDateTime.now();
            LocalDateTime tim = checkCode.getTime();
            Duration duration = Duration.between(tim,now);
            if(duration.toMinutes() >= 5){
                checkCodeDao.deleteByEmailAndType(email, type);
                return null;
            }
            return checkCode;
        }catch (Exception e){
            return null;
        }
    }

    public boolean addCheckCode(Integer type, String email, String code){
        try {
            CheckCode oldCheckCode = getByEmailAndType(email, type);
            if(oldCheckCode!=null)checkCodeDao.deleteByEmailAndType(email, type);
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
