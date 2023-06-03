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
    public static InfoPatient getInfoPatientOnOrderStart(String patientId){
        InfoPatient infoPatient = new InfoPatient();
        infoPatient.setPatientId(patientId);
        infoPatient.setInfoTime(LocalDateTime.now());
        String infoBody = "尊敬的患者，\n" +
                "\n" +
                "您好！您的一份预约即将到达就诊时间，请您提前安排好行程，按时前往就诊。\n" +
                "\n" +
                "请您注意以下几点：\n" +
                "\n" +
                "   1. 如果您不能按时前往，请提前至少1天联系医院/诊所取消预约，以免浪费医疗资源。\n" +
                "\n" +
                "   2. 在前往医院/诊所的路上，务必注意交通安全，确保安全到达。\n" +
                "\n" +
                "   3. 如果您有任何疑问或需要帮助，请随时联系我们的客服人员。\n" +
                "\n" +
                "祝您身体健康！\n" +
                "\n";
        infoPatient.setInfoBody(infoBody);
        return infoPatient;
    }
    public static InfoDoctor getInfoDoctorOnOrderStart(String doctorId){
        InfoDoctor infoDoctor = new InfoDoctor();
        infoDoctor.setDoctorId(doctorId);
        infoDoctor.setInfoTime(LocalDateTime.now());
        String infoBody = "尊敬的医生，\n" +
                "\n" +
                "您好！您有一位患者即将到预约就诊时间,请您准备好相关的医疗设备和资料，做好就诊前的准备工作。\n" +
                "\n" +
                "请您注意以下几点：\n" +
                "\n" +
                "   1. 在就诊前，请认真查看该患者的病历资料和预约信息，了解患者的病情和预约目的。\n" +
                "\n" +
                "   2. 在就诊时，认真倾听患者的诉求和病情描述，进行细致的体检和检查，提供科学、专业的医疗服务。\n" +
                "\n" +
                "   3. 在就诊过程中，注意保护患者隐私，确保患者的医疗信息不被泄露。\n" +
                "\n" +
                "祝您工作顺利！";
        infoDoctor.setInfoBody(infoBody);
        return infoDoctor;
    }
}
