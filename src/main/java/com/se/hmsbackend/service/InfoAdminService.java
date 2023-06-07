package com.se.hmsbackend.service;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.dao.DoctorDao;
import com.se.hmsbackend.dao.InfoAdminDao;
import com.se.hmsbackend.dao.InfoAdminDetailDao;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoAdminDetail;
import com.se.hmsbackend.pojo.Schedule;
import com.se.hmsbackend.utils.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class InfoAdminService {
    @Autowired
    private InfoAdminDao infoAdminDao;
    @Autowired
    private InfoAdminDetailDao infoAdminDetailDao;
    @Autowired
    private DoctorDao doctorDao;
    @Autowired
    private ScheduleService scheduleService;

    public List<InfoAdmin> getAllInfoAdmin(){
        List<InfoAdmin> infoAdminList = infoAdminDao.getAllInfo();
        infoAdminList.removeIf(infoAdmin -> !Const.INFOADMIN_STATUS_WAITING.equals(infoAdmin.getInfoStatus()));
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

            LocalDate st = LocalDate.parse("2023-06-05", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            Schedule schedule = new Schedule();
            schedule.setDoctorId(doctor.getDoctorId());
            schedule.setStartDate(st);

            schedule.setMon1(Const.SCHEDULE_DEFAULT);
            schedule.setTue1(Const.SCHEDULE_DEFAULT);
            schedule.setWed1(Const.SCHEDULE_DEFAULT);
            schedule.setThu1(Const.SCHEDULE_DEFAULT);
            schedule.setFri1(Const.SCHEDULE_DEFAULT);
            schedule.setSat1(Const.SCHEDULE_DEFAULT);
            schedule.setSun1(Const.SCHEDULE_DEFAULT);
            schedule.setMon2(Const.SCHEDULE_DEFAULT);
            schedule.setTue2(Const.SCHEDULE_DEFAULT);
            schedule.setWed2(Const.SCHEDULE_DEFAULT);
            schedule.setThu2(Const.SCHEDULE_DEFAULT);
            schedule.setFri2(Const.SCHEDULE_DEFAULT);
            schedule.setSat2(Const.SCHEDULE_DEFAULT);
            schedule.setSun2(Const.SCHEDULE_DEFAULT);
            scheduleService.addSchedule(schedule);
        } else if(type.equals(Const.INFOADMIN_TYPE_UPDATE)){
            doctorDao.updateDoctorExceptPWAndImg(doctor);
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
        infoAdmin.setInfoTime(LocalDateTime.now());
        infoAdmin.setInfoStatus(Const.INFOADMIN_STATUS_WAITING);
        infoAdminDao.addInfo(infoAdmin);
    }
}
