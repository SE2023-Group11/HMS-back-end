package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Section;
import com.se.hmsbackend.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SectionController {
    @Autowired
    private SectionService sectionService;

    @PostMapping("/getRoomInfo")
    public R<String> getRoomInfo(@RequestParam String roomName) {
        Section section = sectionService.getRoomInfo(roomName);
        if(section == null)return R.error("科室不存在");
        return R.success(section.getSectionIntroduction());
    }
    @PostMapping("/changeRoomInfo")
    public R<Section> changeRoomInfo(@RequestParam String roomName, @RequestParam String roomInfo){
        if(sectionService.updateRoomInfo(roomName, roomInfo))return R.success(null);
        return R.error("修改失败");
    }
}
