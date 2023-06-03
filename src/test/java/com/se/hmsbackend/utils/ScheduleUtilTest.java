package com.se.hmsbackend.utils;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.pojo.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@SpringBootTest
public class ScheduleUtilTest {
    @Test
    public void test(){
        List<Integer> list = ScheduleUtil.scheduleStrToList(Const.SCHEDULE_DEFAULT);
        System.out.println(list);
    }
    @Test
    public void test2(){
        String tem = ScheduleUtil.updateOnTime(Const.SCHEDULE_DEFAULT, 0 , 3);
        System.out.println(tem);
    }
    @Test
    public void test3(){
        LocalDateTime time = LocalDateTime.parse("2023-03-28 14:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(ScheduleUtil.localDateTimeToInt(time));
    }
}
