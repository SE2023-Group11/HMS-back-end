package com.se.hmsbackend.utils;

import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.InfoDoctor;
import com.se.hmsbackend.pojo.InfoPatient;
import com.se.hmsbackend.pojo.Patient;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class InfoUtil {
    public static InfoPatient getInfoPatientOnOrderSuccess(String patientId, Doctor doctor, String day, Integer time){
        InfoPatient infoPatient = new InfoPatient();
        infoPatient.setPatientId(patientId);
        infoPatient.setInfoTime(LocalDateTime.now());
        LocalDate newDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String infoBody = "您好，您已成功预约，请于" + ScheduleUtil.getLocalDateTime(newDate, time) + "按时就诊。";
        String infoBody = "尊敬的患者，\n" +
                "\n" +
                "感谢您选择我们的诊所进行就诊。我很高兴地通知您，您已成功预约了我们的医生，以下是您的预约细节：\n" +
                "\n" +
                "医生姓名：" + doctor.getDoctorName() + "\n" +
                "预约时间：" + ScheduleUtil.getLocalDateTime(newDate, time) + "\n" +
                "请您务必按时到达，如有需要请提前做好相关检查和准备医疗文件和病历，以便医生更好地为您提供诊疗服务。\n" +
                "\n" +
                "如果您需要取消预约或者有任何疑问，请及时联系我们以便我们为您提供帮助。\n" +
                "\n" +
                "谢谢！";
        infoPatient.setInfoBody(infoBody);
        return infoPatient;
    }
    public static InfoDoctor getInfoDoctorOnOrderSuccess(String doctorId, Patient patient, String day, Integer time){
        InfoDoctor infoDoctor = new InfoDoctor();
        infoDoctor.setDoctorId(doctorId);
        infoDoctor.setInfoTime(LocalDateTime.now());
        LocalDate newDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String infoBody = "您好，您已成功预约，请于" + ScheduleUtil.getLocalDateTime(newDate, time) + "请按时看诊。";
        String infoBody = "尊敬的医生，\n" +
                "\n" +
                "我是您诊所的前台，我想通过这封邮件通知您，我们的患者已经成功预约了您在某个时间段的挂号。\n" +
                "\n" +
                "以下是挂号细节：\n" +
                "\n" +
                "患者姓名：" + patient.getPatientName() + "\n" +
                "预约时间：" + ScheduleUtil.getLocalDateTime(newDate, time) + "\n" +
                "请您准备好相关的医疗文件和病历，以便在患者到达时能够为他们提供最好的医疗服务。\n" +
                "\n" +
                "如果您有任何问题或需要更多信息，请随时与我们联系。\n" +
                "\n" +
                "谢谢！";
        infoDoctor.setInfoBody(infoBody);
        return infoDoctor;
    }
    public static InfoPatient getInfoPatientOnOrderDeleted(String patientId, Doctor doctor, LocalDateTime timeStart){
        InfoPatient infoPatient = new InfoPatient();
        infoPatient.setPatientId(patientId);
        infoPatient.setInfoTime(LocalDateTime.now());
//        LocalDate newDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String infoBody = "您好，您已成功预约，请于" + ScheduleUtil.getLocalDateTime(newDate, time) + "按时就诊。";
        String infoBody = "尊敬的患者，\n" +
                "\n" +
                "经过您的申请，我们确认您已成功取消了预约。以下是取消预约的细节：\n" +
                "\n" +
                "医生姓名：" + doctor.getDoctorName() + "\n" +
                "预约时间：" + timeStart + "\n" +
                "如果您需要重新预约或者有任何其他问题，请随时联系我们，我们将竭诚为您服务。\n" +
                "\n" +
                "谢谢！";
        infoPatient.setInfoBody(infoBody);
        return infoPatient;
    }
    public static InfoDoctor getInfoDoctorOnOrderDeleted(String doctorId, Patient patient, LocalDateTime timeStart){
        InfoDoctor infoDoctor = new InfoDoctor();
        infoDoctor.setDoctorId(doctorId);
        infoDoctor.setInfoTime(LocalDateTime.now());
//        LocalDate newDate = LocalDate.parse(day, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String infoBody = "您好，您已成功预约，请于" + ScheduleUtil.getLocalDateTime(newDate, time) + "请按时看诊。";
        String infoBody = "尊敬的医生，\n" +
                "\n" +
                "患者已取消了您在某个时间段的预约。以下是取消预约的细节：\n" +
                "\n" +
                "患者姓名：" + patient.getPatientName() + "\n" +
                "预约时间：" + timeStart + "\n" +
                "如果您有任何问题或需要更多信息，请随时与我们联系。\n" +
                "\n" +
                "谢谢！";
        infoDoctor.setInfoBody(infoBody);
        return infoDoctor;
    }
}
