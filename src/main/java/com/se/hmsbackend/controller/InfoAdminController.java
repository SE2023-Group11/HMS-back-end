package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.InfoAdmin;
import com.se.hmsbackend.pojo.InfoAdminDetail;
import com.se.hmsbackend.service.InfoAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InfoAdminController {
    @Autowired
    private InfoAdminService infoAdminService;

    @GetMapping("/getAllNotifications")
    public R<List<InfoAdmin>> getAllInfoAdmin(){
        List<InfoAdmin> infoList = infoAdminService.getAllInfoAdmin();
        return R.success(infoList);
    }

    @PostMapping("/getNotifyInfoByID")
    public R<InfoAdminDetail> getNotifyInfoByID(@RequestParam Integer detailId){
        InfoAdminDetail info = infoAdminService.getInfoDetailByID(detailId);
        return R.success(info);
    }

    @PostMapping("/acceptNotify")
    public R<InfoAdmin> acceptInfo(@RequestParam Integer infoId){
        InfoAdmin info = infoAdminService.acceptInfo(infoId);
        return R.success(info);
    }

    @PostMapping("/declineNotify")
    public R<InfoAdmin> denyInfo(@RequestParam Integer infoId){
        InfoAdmin info = infoAdminService.denyInfo(infoId);
        return R.success(info);
    }
}
