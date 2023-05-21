package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.service.DoctorService;
import com.se.hmsbackend.service.InfoAdminService;
import com.se.hmsbackend.service.InfoDoctorService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class AdminController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private InfoAdminService infoAdminService;
    @Autowired
    private InfoDoctorService infoDoctorService;

    @PostMapping("/getDoctorInfo")
    public R<List<Doctor>> getDoctor(@RequestParam String doctorName){
        List<Doctor> doctors = doctorService.getDoctorInfo(doctorName);
        if(doctors.size() == 0)return R.error("不存在");
        return R.success(doctors);
    }
    @PostMapping("/changeDoctorInfo")
    public R<Doctor> changeDoctorInfo(@RequestParam String id, @RequestParam String info, HttpServletRequest request){
        Doctor doctor = doctorService.changeDoctorInfo(id, info);
        if(doctor != null)return R.success(doctor);
        return R.error("修改失败");
    }
}
