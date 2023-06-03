package com.se.hmsbackend.utils;

import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.InfoAdminDetail;

public class TransferUtil {
    public static Doctor infoAdminDetailToDoctor(InfoAdminDetail info){
        Doctor doctor = new Doctor();
        doctor.setDoctorId(info.getDoctorId());
        doctor.setDoctorName(info.getDoctorName());
        doctor.setDoctorNumber(info.getDoctorNumber());
        doctor.setDoctorMail(info.getDoctorMail());
        doctor.setDoctorPhone(info.getDoctorPhone());
        doctor.setDoctorPassword(info.getDoctorPassword());
        doctor.setDoctorStatus(info.isDoctorStatus());
        doctor.setDoctorSection(info.getDoctorSection());
        doctor.setDoctorTitle(info.getDoctorTitle());
        doctor.setDoctorIntroduction(info.getDoctorIntroduction());
        doctor.setDoctorImg(info.getDoctorImg());
        return doctor;
    }
    public static InfoAdminDetail doctorToInfoAdminDetail(Doctor doctor){
        InfoAdminDetail info = new InfoAdminDetail();
        info.setDoctorId(doctor.getDoctorId());
        info.setDoctorName(doctor.getDoctorName());
        info.setDoctorNumber(doctor.getDoctorNumber());
        info.setDoctorMail(doctor.getDoctorMail());
        info.setDoctorPhone(doctor.getDoctorPhone());
        info.setDoctorPassword(doctor.getDoctorPassword());
        info.setDoctorStatus(doctor.isDoctorStatus());
        info.setDoctorSection(doctor.getDoctorSection());
        info.setDoctorTitle(doctor.getDoctorTitle());
        info.setDoctorIntroduction(doctor.getDoctorIntroduction());
        info.setDoctorImg(doctor.getDoctorImg());
        return info;
    }
}
