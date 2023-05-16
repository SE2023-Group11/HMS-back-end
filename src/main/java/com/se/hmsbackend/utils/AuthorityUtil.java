package com.se.hmsbackend.utils;

import com.se.hmsbackend.common.Const;
import org.springframework.util.AntPathMatcher;

public class AuthorityUtil {
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    private static final String[] noAuthority = new String[]{
        "/sendToEmail",
        "/doctorRegister",
        "/docterChangepwd",
        "/loginDoctor",

        "/patientRegister",
        "/patientChangepwd",
        "/loginPatient",

        "/getRoomInfo",
        "/getDoctorsByRoom",

//            TODO: 返回值带有密码等信息，可能需要修改
        "/getDoctorsBySchedule",
        "/getDoctorSchedule",
        "/getRoomName",
        "/getPatientName"
    };
    private static final String[] patientAuthority = new String[]{
        "/getPatientMessage",
        "/changePatient",
        "/getPatientInformation",
        "/getPatientAppointment",
        "/addAppointment",
        "/deleteAppointment"
    };
    private static final String[] doctorAuthority = new String[]{
        "/getDoctorMessage",
        "/changeDoctor",
        "/saveIntroduction",
        "/logoutDoctor",
        "/getDoctorInformation",
        "/getAppointmentList",
        "/getSchedule",
        "/ChangeAppointmentStatus"
    };
    private static final String[] adminAuthority = new String[]{
        "/changeRoomInfo",
        "/changeDoctorInfo",
        "/getDoctorInfo",
        "/getAllNotifications",
        "/getNotifyInfoByID",
        "/acceptNotify",
        "/declineNotify"
    };
    public static String getAuthority(String uri){
        if(check(noAuthority,uri))return Const.NO_AUTHORITY;
        if(check(patientAuthority,uri))return Const.PATIENT_AUTHORITY;
        if(check(doctorAuthority,uri))return Const.DOCTOR_AUTHORITY;
        if(check(adminAuthority,uri))return Const.ADMIN_AUTHORITY;
        return null;
    }
    public static boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }
}
