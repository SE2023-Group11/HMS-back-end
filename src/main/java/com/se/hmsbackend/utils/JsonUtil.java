package com.se.hmsbackend.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.se.hmsbackend.pojo.InfoDoctor;
import com.se.hmsbackend.pojo.InfoPatient;
import com.se.hmsbackend.pojo.Section;

import java.time.LocalDateTime;
import java.util.Comparator;

public class JsonUtil {
    public static Comparator<JSONObject> orderByTime = (o1, o2) -> {
        LocalDateTime date1 = (LocalDateTime) o1.get("time");
        LocalDateTime date2 = (LocalDateTime) o2.get("time");
        return date2.compareTo(date1);
    };
    public static Comparator<InfoDoctor> orderInfoDoctorByTime = (o1, o2) -> {
        LocalDateTime date1 = o1.getInfoTime();
        LocalDateTime date2 = o2.getInfoTime();
        return date2.compareTo(date1);
    };
    public static Comparator<InfoPatient> orderInfoPatientByTime = (o1, o2) -> {
        LocalDateTime date1 = o1.getInfoTime();
        LocalDateTime date2 = o2.getInfoTime();
        return date2.compareTo(date1);
    };
    public static Comparator<JSONObject> orderOrderByTime = (o1, o2) -> {
        LocalDateTime date1 = (LocalDateTime) o1.get("timeStart");
        LocalDateTime date2 = (LocalDateTime) o2.get("timeStart");
        return date1.compareTo(date2);
    };
    public static Comparator<JSONObject> orderBySectionId = (o1, o2) -> {
        Integer id1 =(Integer) o1.get("id");
        Integer id2 =(Integer) o2.get("id");
        return id1.compareTo(id2);
    };
}
