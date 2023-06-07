package com.se.hmsbackend.utils;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.pojo.Schedule;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScheduleUtil {
    public static LocalDateTime getLocalDateTime(LocalDate day,Integer tem){
        if(tem==0)return day.atTime(8,0,0);
        if(tem==1)return day.atTime(8,30,0);
        if(tem==2)return day.atTime(9,0,0);
        if(tem==3)return day.atTime(9,30,0);
        if(tem==4)return day.atTime(10,0,0);
        if(tem==5)return day.atTime(10,30,0);
        if(tem==6)return day.atTime(11,0,0);

        if(tem==7)return day.atTime(14,0,0);
        if(tem==8)return day.atTime(14,30,0);
        if(tem==9)return day.atTime(15,0,0);
        if(tem==10)return day.atTime(15,30,0);
        if(tem==11)return day.atTime(16,0,0);
        if(tem==12)return day.atTime(16,30,0);
        return null;
    }
    public static Integer localDateTimeToInt(LocalDateTime startTime){
        for(int i=0;i<=12;i++){
            LocalDateTime res = getLocalDateTime(startTime.toLocalDate(),i);
            if(res.isEqual(startTime))return i;
        }
        return -1;
    }
    public static LocalDateTime getLocalDateTimeED(LocalDate day, Integer tem){
        LocalDateTime res = getLocalDateTime(day, tem);
        return res.plusMinutes(30);
    }
    public static List<Integer> scheduleStrToList(String str){
        if(!str.matches("\\[.{0,}\\]"))return null;

        str = str.substring(1,str.length()-1);
        String[] list = str.split(",");
        List<Integer> result = new ArrayList<Integer>();
        for(String item : list){
            result.add(Integer.valueOf(item));
        }
        return result;
    }
    public static String scheduleListToString(List<Integer> list){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(Integer item : list){
            sb.append(item+",");
        }
        int len = sb.length();
        sb.deleteCharAt(len-1);
        sb.append("]");
        return sb.toString();
    }
    public static String getScheduleOnDate(Schedule schedule, String date){
        LocalDate newDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int tem = (int) ChronoUnit.DAYS.between(schedule.getStartDate(), newDate);
//        System.out.println(schedule+" "+date+" "+tem);
        if(tem==0)return schedule.getMon1();
        if(tem==1)return schedule.getTue1();
        if(tem==2)return schedule.getWed1();
        if(tem==3)return schedule.getThu1();
        if(tem==4)return schedule.getFri1();
        if(tem==5)return schedule.getSat1();
        if(tem==6)return schedule.getSun1();

        if(tem==7)return schedule.getMon2();
        if(tem==8)return schedule.getTue2();
        if(tem==9)return schedule.getWed2();
        if(tem==10)return schedule.getThu2();
        if(tem==11)return schedule.getFri2();
        if(tem==12)return schedule.getSat2();
        if(tem==13)return schedule.getSun2();
        return "[]";
    }
    public static boolean isFullSchedule(List<Integer> item){
        for(Integer i:item){
            if(Const.SCHEDULE_STATUS_EMPTY.equals(i))return false;
        }
        return true;
    }

    public static String updateOnTime(String str, Integer time, Integer newStatus){
        List<Integer> res = scheduleStrToList(str);
        res.set(time, newStatus);
        return scheduleListToString(res);
    }
    public static Schedule updateScheduleOnDate(Schedule schedule, String date, Integer time, Integer newStatus){
        LocalDate newDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int tem = (int) ChronoUnit.DAYS.between(schedule.getStartDate(), newDate);
        if(tem==0)schedule.setMon1(updateOnTime(schedule.getMon1(),time,newStatus));
        if(tem==1)schedule.setTue1(updateOnTime(schedule.getTue1(),time,newStatus));
        if(tem==2)schedule.setWed1(updateOnTime(schedule.getWed1(),time,newStatus));
        if(tem==3)schedule.setThu1(updateOnTime(schedule.getThu1(),time,newStatus));
        if(tem==4)schedule.setFri1(updateOnTime(schedule.getFri1(),time,newStatus));
        if(tem==5)schedule.setSat1(updateOnTime(schedule.getSat1(),time,newStatus));
        if(tem==6)schedule.setSun1(updateOnTime(schedule.getSun1(),time,newStatus));

        if(tem==7)schedule.setMon2(updateOnTime(schedule.getMon2(),time,newStatus));
        if(tem==8)schedule.setTue2(updateOnTime(schedule.getTue2(),time,newStatus));
        if(tem==9)schedule.setWed2(updateOnTime(schedule.getWed2(),time,newStatus));
        if(tem==10)schedule.setThu2(updateOnTime(schedule.getThu2(),time,newStatus));
        if(tem==11)schedule.setFri2(updateOnTime(schedule.getFri2(),time,newStatus));
        if(tem==12)schedule.setSat2(updateOnTime(schedule.getSat2(),time,newStatus));
        if(tem==13)schedule.setSun2(updateOnTime(schedule.getSun2(),time,newStatus));
        return schedule;
    }
    public static void changeHalfDay(List<Integer> t, Integer half){
        if(half == 0){
            for(int i=0;i<=6;i++){
                t.set(i,2);
            }
        }
        if(half == 1){
            for(int i=7;i<=12;i++){
                t.set(i,2);
            }
        }
    }
    public static void submit(Schedule schedule,Integer day, Integer half){
        if(day == 1){
            List<Integer> t1 = scheduleStrToList(schedule.getMon1());
            List<Integer> t2 = scheduleStrToList(schedule.getMon2());
            changeHalfDay(t1,half);
            changeHalfDay(t2,half);
            schedule.setMon1(scheduleListToString(t1));
            schedule.setMon2(scheduleListToString(t2));
        }
        if(day == 2){
            List<Integer> t1 = scheduleStrToList(schedule.getTue1());
            List<Integer> t2 = scheduleStrToList(schedule.getTue2());
            changeHalfDay(t1,half);
            changeHalfDay(t2,half);
            schedule.setTue1(scheduleListToString(t1));
            schedule.setTue2(scheduleListToString(t2));
        }
        if(day == 3){
            List<Integer> t1 = scheduleStrToList(schedule.getWed1());
            List<Integer> t2 = scheduleStrToList(schedule.getWed2());
            changeHalfDay(t1,half);
            changeHalfDay(t2,half);
            schedule.setWed1(scheduleListToString(t1));
            schedule.setWed2(scheduleListToString(t2));
        }
        if(day == 4){
            List<Integer> t1 = scheduleStrToList(schedule.getThu1());
            List<Integer> t2 = scheduleStrToList(schedule.getThu2());
            changeHalfDay(t1,half);
            changeHalfDay(t2,half);
            schedule.setThu1(scheduleListToString(t1));
            schedule.setThu2(scheduleListToString(t2));
        }
        if(day == 5){
            List<Integer> t1 = scheduleStrToList(schedule.getFri1());
            List<Integer> t2 = scheduleStrToList(schedule.getFri2());
            changeHalfDay(t1,half);
            changeHalfDay(t2,half);
            schedule.setFri1(scheduleListToString(t1));
            schedule.setFri2(scheduleListToString(t2));
        }
        if(day == 6){
            List<Integer> t1 = scheduleStrToList(schedule.getSat1());
            List<Integer> t2 = scheduleStrToList(schedule.getSat2());
            changeHalfDay(t1,half);
            changeHalfDay(t2,half);
            schedule.setSat1(scheduleListToString(t1));
            schedule.setSat2(scheduleListToString(t2));
        }
        if(day == 7){
            List<Integer> t1 = scheduleStrToList(schedule.getSun1());
            List<Integer> t2 = scheduleStrToList(schedule.getSun2());
            changeHalfDay(t1,half);
            changeHalfDay(t2,half);
            schedule.setSun1(scheduleListToString(t1));
            schedule.setSun2(scheduleListToString(t2));
        }
    }
}
