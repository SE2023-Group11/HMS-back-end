package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.R;
import com.se.hmsbackend.dao.DoctorDao;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping("/getDoctorInfo")
    public R<Doctor> getDoctor(@RequestParam String doctorName){
        Doctor doctor = doctorService.getDoctorInfo(doctorName);
        if(doctor == null)return R.error("不存在");
        return R.success(doctor);
    }
    @PostMapping("/changeDoctorInfo")
    public R<Doctor> changeDoctorInfo(@RequestParam String id, @RequestParam String info){
        if(doctorService.changeDoctorInfo(id, info))return R.success(null);
        return R.error("修改失败");
    }
}
