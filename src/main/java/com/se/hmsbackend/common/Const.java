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
//    InfoAdmin
    public static final Integer INFOADMIN_TYPE_REGISTER = 1;//审核医生账号注册
    public static final Integer INFOADMIN_TYPE_UPDATE = 2;//审核医生信息修改
    public static final Integer INFOADMIN_STATUS_WAITING = 0;
    public static final Integer INFOADMIN_STATUS_PASSED = 1;
    public static final Integer INFOADMIN_STATUS_DENYED = 2;
}
