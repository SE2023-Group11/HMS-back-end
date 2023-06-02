package com.se.hmsbackend.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.Section;
import com.se.hmsbackend.service.DoctorService;
import com.se.hmsbackend.service.SectionService;
import com.se.hmsbackend.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @GetMapping("/getFirstRooms")
    public R<List<JSONObject>> getFirstRooms(){
        List<JSONObject> res = new ArrayList<>();
        List<Section> sections = sectionService.getAllSections();
        String oldName = "";
        for(Section section : sections){
            JSONObject t = new JSONObject(1);
            t.put("id", section.getSectionId());
            t.put("name", section.getSectionFirname());
            if(!section.getSectionFirname().equals(oldName))res.add(t);
            oldName = section.getSectionFirname();
        }
        res.sort(JsonUtil.orderBySectionId);
        return R.success(res);
    }
    @PostMapping("/getSecondRoomsByFID")
    public R<List<JSONObject>> getSecondRoomsByID(@RequestParam Integer id){
        Section section = sectionService.getById(id);
        String firName = section.getSectionFirname();
        List<JSONObject> res = new ArrayList<>();
        List<Section> sections = sectionService.getAllSections();
        for(Section section1 : sections){
            if(firName.equals(section1.getSectionFirname())){
                JSONObject t = new JSONObject(1);
                t.put("id",section1.getSectionId());
                t.put("name", section1.getSectionSecname());
                res.add(t);
            }
        }
        res.sort(JsonUtil.orderBySectionId);
        return R.success(res);
    }
}
