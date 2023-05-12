package com.se.hmsbackend.utils;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.pojo.Schedule;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ScheduleUtilTest {
    @Test
    public void test(){
        List<Integer> list = ScheduleUtil.scheduleStrToList(Const.SCHEDULE_DEFAULT);
        System.out.println(list);
    }
}
