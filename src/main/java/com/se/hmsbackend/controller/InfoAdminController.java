package com.se.hmsbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoAdminDetail;
import com.se.hmsbackend.pojo.Section;
import com.se.hmsbackend.service.InfoAdminService;
import com.se.hmsbackend.service.SectionService;
import com.se.hmsbackend.utils.JsonUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class InfoAdminController {
    @Autowired
    private InfoAdminService infoAdminService;
    @Autowired
    private SectionService sectionService;

    @GetMapping("/getAllNotifications")
    public R<List<JSONObject>> getAllInfoAdmin(){
        List<JSONObject> list = new ArrayList<JSONObject>();
        List<InfoAdmin> infoList = infoAdminService.getAllInfoAdmin();
        for(InfoAdmin info : infoList){
            InfoAdminDetail infoDetail = infoAdminService.getInfoDetailByID(info.getDetailId());
            Section section = sectionService.getById(infoDetail.getDoctorSection());
            JSONObject infoObj = new JSONObject(true);
            infoObj.put("infoType",info.getInfoType());
            infoObj.put("detailId",info.getDetailId());
            infoObj.put("name",infoDetail.getDoctorName());
            infoObj.put("sectionFirName",section.getSectionFirname());
            infoObj.put("sectionSecName",section.getSectionSecname());
            infoObj.put("time",info.getInfoTime());
            list.add(infoObj);
        }
        list.sort(JsonUtil.orderByTime);
        return R.success(list);
    }

    @PostMapping("/getNotifyInfoByID")
    public R<InfoAdminDetail> getNotifyInfoByID(@RequestParam Integer detailId){
        InfoAdminDetail info = infoAdminService.getInfoDetailByID(detailId);
        return R.success(info);
    }

    @PostMapping("/acceptNotify")
    public R<InfoAdmin> acceptInfo(@RequestParam Integer infoId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(!Const.NOW_LOGGED_IN_TYPE_ADMIN.equals(session.getAttribute(Const.NOW_LOGGED_IN_TYPE)))return R.error("当前登录用户非管理员");
        InfoAdmin info = infoAdminService.acceptInfo(infoId);
        return R.success(info);
    }

    @PostMapping("/declineNotify")
    public R<InfoAdmin> denyInfo(@RequestParam Integer infoId, HttpServletRequest request){
        HttpSession session = request.getSession();
        if(!Const.NOW_LOGGED_IN_TYPE_ADMIN.equals(session.getAttribute(Const.NOW_LOGGED_IN_TYPE)))return R.error("当前登录用户非管理员");
        InfoAdmin info = infoAdminService.denyInfo(infoId);
        return R.success(info);
    }
}
