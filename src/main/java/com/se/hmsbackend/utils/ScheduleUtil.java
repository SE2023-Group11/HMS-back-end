package com.se.hmsbackend.utils;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.pojo.Schedule;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScheduleUtil {
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
    public static String getScheduleOnDate(Schedule schedule, String date){
        LocalDate newDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int tem = (int) ChronoUnit.DAYS.between(schedule.getStartDate(), newDate);
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
}
