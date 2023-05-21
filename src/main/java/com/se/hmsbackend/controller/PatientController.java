package com.se.hmsbackend.controller;

import com.se.hmsbackend.common.Const;
import com.se.hmsbackend.common.R;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.InfoDoctor;
import com.se.hmsbackend.pojo.InfoPatient;
import com.se.hmsbackend.pojo.Patient;
import com.se.hmsbackend.service.CheckCodeService;
import com.se.hmsbackend.service.InfoPatientService;
import com.se.hmsbackend.service.PatientService;
import com.se.hmsbackend.utils.TokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin
@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;
    @Autowired
    private InfoPatientService infoPatientService;
    @Autowired
    private CheckCodeService checkCodeService;

    @PostMapping("/patientRegister")
    public R<Patient> doctorRegister(@RequestParam String code, @RequestParam String confirmPW, @RequestBody Patient patient, HttpSession session){
        log.info("code: ("+code+")" + "cofirmPW: ("+confirmPW+")"+"patient: ("+patient+")");
        String email = patient.getPatientMail();
//        Object codeInSession = session.getAttribute(Const.PATIENT_REGISTER_CODE+email);
        String codeInSession = checkCodeService.getCode(Const.CODE_TYPE_PATIENT_REGISTER, email);
        log.info("("+Const.PATIENT_REGISTER_CODE+email+") "+"codeInSession: ("+codeInSession+") sessionId: "+session.getId());
        if(!code.equals(codeInSession))return R.error("验证码错误");
        if(!confirmPW.equals(patient.getPatientPassword()))return R.error("两次密码不一致");
        if(patientService.hasNumber(patient.getPatientNumber()))return R.error("该身份证号已注册");
        if(patientService.hasMail(patient.getPatientMail()))return R.error("邮箱已注册");
//        生成患者的id
        patient.setPatientId(patientService.getNewPatientId());
        patient.setPatientImg("https://f.pz.al/pzal/2023/05/03/5e6420e7ffe6f.png");
        boolean res = patientService.addPatient(patient);

        if(res)return R.success(patient);
        else return R.error("注册失败");
    }

    @PostMapping("/patientChangepwd")
    public R<String> patientChangepwd(@RequestParam String code, @RequestParam String patient_pwd, @RequestParam String email, HttpSession session){
//        Object codeInSession = session.getAttribute(Const.PATIENT_FORGET_CODE+email);
        String codeInSession = checkCodeService.getCode(Const.CODE_TYPE_PATIENT_FORGET, email);
        if(!code.equals(codeInSession))return R.error("验证码错误");

        Patient patient = patientService.getPatientByMail(email);
        patient.setPatientPassword(patient_pwd);
        patientService.updatePatient(patient);
        return R.success("密码重置成功");
    }

    @PostMapping("/loginPatient")
    public R<String> loginDoctor(@RequestParam String uid, @RequestParam String password, HttpServletRequest request) {
        Patient patient = patientService.getPatientById(uid);
        if(patient == null)patient = patientService.getPatientByNumber(uid);
        if(patient == null)return R.error("用户不存在");
        if(!password.equals(patient.getPatientPassword()))return R.error("密码错误");

//        HttpSession session = request.getSession();
//        session.setAttribute(Const.NOW_LOGGED_IN_TYPE,Const.NOW_LOGGED_IN_TYPE_PATIENT);
//        session.setAttribute(Const.NOW_LOGGED_IN_ID,patient.getPatientId());
//        session.setAttribute(Const.TOKEN, session.getId());
        String token = TokenUtil.getToken(Const.NOW_LOGGED_IN_TYPE_PATIENT, patient.getPatientId());
        return R.success(token);
    }
    @PostMapping("/changePatient")
    public R<String> changeNowLoggedDoctor(HttpServletRequest request, @RequestBody Patient patient, @RequestParam String token){
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        Patient oldPatient = patientService.getPatientById(nowLoggedInId);
        patient.setPatientId(nowLoggedInId);
        patient.setPatientPassword(oldPatient.getPatientPassword());
        patient.setPatientImg(oldPatient.getPatientImg());
        patientService.updatePatient(patient);
        return R.success("修改成功");
    }
    @PostMapping("/getPatientMessage")
    public R<List<InfoPatient>> getPatientMessage(HttpServletRequest request, @RequestParam String token){
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        List<InfoPatient> infoPatients = infoPatientService.getInfoPatient(nowLoggedInId);
        return R.success(infoPatients);
    }
    @GetMapping("/getPatientInformation")
    public R<Patient> getPatientInformation(HttpServletRequest request, @RequestParam String token){
//        String nowLoggedInId = (String) request.getSession().getAttribute(Const.NOW_LOGGED_IN_ID);
        String nowLoggedInId = (String) TokenUtil.parse(token).get(Const.NOW_LOGGED_IN_ID);
        return R.success(patientService.getPatientById(nowLoggedInId));
    }

    @PostMapping("/getPatientName")
    public R<String> getPatientName(@RequestParam String patientId){
        Patient patient = patientService.getPatientById(patientId);
        return R.success(patient.getPatientName());
    }
}
