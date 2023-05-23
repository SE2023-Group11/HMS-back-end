package com.se.hmsbackend.controller;

import com.alibaba.fastjson.JSONObject;
import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Admin;
import com.se.hmsbackend.pojo.CheckCode;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.InfoDoctor;
import com.se.hmsbackend.service.*;
import com.se.hmsbackend.service.MailService;
import com.se.hmsbackend.utils.StringUtil;
import com.se.hmsbackend.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.el.parser.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private InfoAdminService infoAdminService;
    @Autowired
    private InfoDoctorService infoDoctorService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private MailService mailService;
    @Autowired
    private CheckCodeService checkCodeService;

    @PostMapping("/sendToEmail")
    public R<String> sendToEmail(@RequestParam Integer type, @RequestParam String name,@RequestParam String email, HttpSession session) {
        String code = mailService.getCheckCode();
        checkCodeService.addCheckCode(type, email, code);
        mailService.sendMail(name,email,code);
        log.info(type+ " sendToEmail: ("+Const.PATIENT_REGISTER_CODE+email+")"+code+" insession:"+session.getAttribute(Const.PATIENT_REGISTER_CODE+email)+"sessionId:"+session.getId());
        return R.success("验证码邮件发送成功");
    }

    @PostMapping("/doctorRegister")
    public R<Doctor> doctorRegister(@RequestParam String code,@RequestParam String confirmPW, @RequestBody Doctor doctor, HttpSession session){
        String email = doctor.getDoctorMail();
//        Object codeInSession = session.getAttribute(Const.DOCTOR_REGISTER_CODE+email);
        String codeInSession = checkCodeService.getCode(Const.CODE_TYPE_DOCTOR_REGISTER, email);

        if(!code.equals(codeInSession))return R.error("验证码错误或已过期");
        if(!confirmPW.equals(doctor.getDoctorPassword()))return R.error("两次密码不一致");
        if(doctorService.hasNumber(doctor.getDoctorNumber()))return R.error("该身份证号已注册");
        if(doctorService.hasMail(doctor.getDoctorMail()))return R.error("邮箱已注册");
//        生成医生的id
        doctor.setDoctorId(doctorService.getNewDoctorId());
//        更新医生的状态为未验证
        doctor.setDoctorStatus(Const.DOCTOR_STATUS_UNVERIFIED);
        doctor.setDoctorImg("https://f.pz.al/pzal/2023/05/03/5e6420e7ffe6f.png");
        doctor.setDoctorIntroduction("暂无");
        boolean res = doctorService.addDoctor(doctor);

//        将此条注册信息添加到管理员消息库，等待管理员验证
        infoAdminService.addInfo(Const.INFOADMIN_TYPE_REGISTER, doctor);

        if(res)return R.success(doctor);
        else return R.error("注册失败");
    }

    @PostMapping("/docterChangepwd")
    public R<String> docterChangepwd(@RequestParam String code, @RequestParam String doctor_pwd, @RequestParam String email, HttpSession session){
//        Object codeInSession = session.getAttribute(Const.DOCTOR_FORGET_CODE+email);
        String codeInSession = checkCodeService.getCode(Const.CODE_TYPE_DOCTOR_FORGET,email);
        if(!code.equals(codeInSession))return R.error("验证码错误或已过期");

        Doctor doctor = doctorService.getDoctorByMail(email);
        doctor.setDoctorPassword(doctor_pwd);
        doctorService.updateDoctor(doctor);
        return R.success("密码重置成功");
    }

    @PostMapping("/loginDoctor")
    public R<String> loginDoctor(@RequestParam String uid, @RequestParam String password, HttpServletRequest request){
        Admin admin = null;
        try{
            admin = adminService.getAdminById(Integer.valueOf(uid));
        }catch (Exception ignored){}
        if(admin != null){
            if(!password.equals(admin.getAdminPassword()))return R.error("密码错误");
            String token = TokenUtil.getToken(Const.NOW_LOGGED_IN_TYPE_ADMIN, admin.getAdminId().toString());
            return R.successAdmin(token);
        }

        Doctor doctor = doctorService.getDoctorById(uid);
        if(doctor == null)doctor = doctorService.getDoctorByNumber(uid);
        if(doctor == null)return R.error("用户不存在");
        if(!password.equals(doctor.getDoctorPassword()))return R.error("密码错误");

        String token = TokenUtil.getToken(Const.NOW_LOGGED_IN_TYPE_DOCTOR, doctor.getDoctorId());
        return R.success(token);
    }
    @PostMapping("/getDoctorMessage")
    public R<List<InfoDoctor>> getDoctorMessage(HttpServletRequest request, @RequestParam String token){
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        List<InfoDoctor> infoDoctors = infoDoctorService.getInfoDoctor(nowLoggedInId);
        return R.success(infoDoctors);
    }
    @PostMapping("/changeDoctor")
    public R<String> changeNowLoggedDoctor(HttpServletRequest request, @RequestBody Doctor doctor, @RequestParam String token){
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        Doctor oldDoctor = doctorService.getDoctorById(nowLoggedInId);
        doctor.setDoctorId(nowLoggedInId);
        doctor.setDoctorPassword(oldDoctor.getDoctorPassword());
        doctor.setDoctorStatus(oldDoctor.isDoctorStatus());
        doctor.setDoctorIntroduction(oldDoctor.getDoctorIntroduction());
        doctor.setDoctorImg(oldDoctor.getDoctorImg());
        infoAdminService.addInfo(Const.INFOADMIN_TYPE_UPDATE, doctor);
        return R.success("等待管理员审核中");
    }
    @PostMapping("/saveIntroduction")
    public R<String> changeNowLoggedDoctorInfo(HttpServletRequest request, @RequestBody JSONObject json, @RequestParam String token) {
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        String doctorIntroduction = json.getString("doctorIntroduction");
        Doctor doctor = doctorService.getDoctorById(nowLoggedInId);
        doctor.setDoctorIntroduction(doctorIntroduction);
        infoAdminService.addInfo(Const.INFOADMIN_TYPE_UPDATE, doctor);
        return R.success("等待管理员审核中");
    }
    @PostMapping("/logoutDoctor")
    public R<String> logoutDoctor(@RequestParam String token,HttpServletRequest request){
        TokenUtil.addTokenToBlack(token);
        return R.success("退出成功");
    }
    @GetMapping("/getDoctorInformation")
    public R<Doctor> getDoctorInformation(HttpServletRequest request, @RequestParam String token){
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        return R.success(doctorService.getDoctorById(nowLoggedInId));
    }
}
