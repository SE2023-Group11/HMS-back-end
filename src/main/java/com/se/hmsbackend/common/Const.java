package com.se.hmsbackend.common;

public class Const {
//    Patient
    public static final boolean PATIENT_SEX_MALE = true;
    public static final boolean PATIENT_SEX_FEMALE = false;
//    Doctor
    public static final boolean DOCTOR_STATUS_VERIFIED = true;//已审核
    public static final boolean DOCTOR_STATUS_UNVERIFIED = false;//未审核
//    Order
    public static final Integer ORDER_STATUS_FINISHED = 1;//已完成
    public static final Integer ORDER_STATUS_BROKEN = 2;//已失约
    public static final Integer ORDER_STATUS_WAITING = 3;//待就诊
//    Schedule
    public static final Integer SCHEDULE_STATUS_REST =  1;//未排班
    public static final Integer SCHEDULE_STATUS_EMPTY = 2;//有排班但无预约
    public static final Integer SCHEDULE_STATUS_WORK = 3;//有排班有预约
    public static final String SCHEDULE_DEFAULT = "[2,2,2,2,2,2,2,2,2,2,2,2,2]";
    public static final String SCHEDULE_CLEARED = "[1,1,1,1,1,1,1,1,1,1,1,1,1]";
//    InfoAdmin
    public static final Integer INFOADMIN_TYPE_REGISTER = 1;//审核医生账号注册
    public static final Integer INFOADMIN_TYPE_UPDATE = 2;//审核医生信息修改
    public static final Integer INFOADMIN_STATUS_WAITING = 0;
    public static final Integer INFOADMIN_STATUS_PASSED = 1;
    public static final Integer INFOADMIN_STATUS_DENYED = 2;

//    checkCode
    public static final Integer CODE_TYPE_DOCTOR_REGISTER = 1;
    public static final Integer CODE_TYPE_DOCTOR_FORGET = 2;
    public static final Integer CODE_TYPE_PATIENT_REGISTER = 3;
    public static final Integer CODE_TYPE_PATIENT_FORGET = 4;
    public static final String DOCTOR_REGISTER_CODE = "doctorRegisterCode:";
    public static final String DOCTOR_FORGET_CODE = "doctorForgetCode:";
    public static final String PATIENT_REGISTER_CODE = "patientRegisterCode:";
    public static final String PATIENT_FORGET_CODE = "patientForgetCode:";

//    login
    public static final String NOW_LOGGED_IN_TYPE = "nowLoggedInType";
    public static final String NOW_LOGGED_IN_TYPE_DOCTOR = "nowLoggedInTypeDoctor";
    public static final String NOW_LOGGED_IN_TYPE_PATIENT = "nowLoggedInTypePatient";
    public static final String NOW_LOGGED_IN_TYPE_ADMIN = "nowLoggedInTypeAdmin";
    public static final String NOW_LOGGED_IN_ID = "nowLoggedInId";
    public static final String TOKEN = "token";

//    Authority
    public static final String NO_AUTHORITY = "noAuthority";
    public static final String PATIENT_AUTHORITY = "patientAuthority";
    public static final String DOCTOR_AUTHORITY = "doctorAuthority";
    public static final String ADMIN_AUTHORITY = "adminAuthority";
}
