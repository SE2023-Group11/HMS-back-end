package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.Section;
import com.se.hmsbackend.service.DoctorService;
import com.se.hmsbackend.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class SectionController {
    @Autowired
    private SectionService sectionService;
    @Autowired
    private DoctorService doctorService;
    @PostMapping("/getRoomInfo")
    public R<String> getRoomInfo(@RequestParam String roomName) {
        Section section = sectionService.getRoomInfo(roomName);
        if(section == null)return R.error("科室不存在");
        return R.success(section.getSectionIntroduction());
    }
    @PostMapping("/changeRoomInfo")
    public R<Section> changeRoomInfo(@RequestParam String roomName, @RequestParam String roomInfo){
        Section section =sectionService.updateRoomInfo(roomName, roomInfo);
        if(section!=null)return R.success(section);
        return R.error("修改失败");
    }

    @GetMapping("/getDoctorsByRoom")
    public R<List<Doctor>> getDoctorsByRoom(@RequestParam String roomName){
        Section section = sectionService.getRoomInfo(roomName);
        if(section==null)return R.error("科室不存在");
        List<Doctor> list = doctorService.getDoctorBySectionId(section.getSectionId());
        return R.success(list);
    }

    @GetMapping("/getRoomName")
    public R<List<Section>> getAllSection(){
        List<Section> list = sectionService.getAllSections();
        return R.success(list);
    }
}
