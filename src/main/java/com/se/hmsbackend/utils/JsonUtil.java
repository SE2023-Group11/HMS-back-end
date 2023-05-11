package com.se.hmsbackend.utils;

import com.alibaba.fastjson.JSONObject;

import java.time.LocalDateTime;
import java.util.Comparator;

public class JsonUtil {
    public static Comparator<JSONObject> orderByTime = new Comparator<JSONObject>(){
        @Override
        public int compare(JSONObject o1, JSONObject o2){
            LocalDateTime date1 = (LocalDateTime) o1.get("time");
            LocalDateTime date2 = (LocalDateTime) o2.get("time");
            return date2.compareTo(date1);
        }
    };
}
