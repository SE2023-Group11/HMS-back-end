package com.se.hmsbackend.common;

import com.se.hmsbackend.dao.DoctorDao;
import com.se.hmsbackend.dao.SectionDao;
import com.se.hmsbackend.pojo.Doctor;
import com.se.hmsbackend.pojo.Section;
import com.se.hmsbackend.utils.DataGenUtil;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class DoctorDataGen {
//    @Autowired
//    private DoctorDao doctorDao;
//    @Autowired
//    private SectionDao sectionDao;
//
//    private static String pad(int length,long num){
//        return String.format("%0".concat(String.valueOf(length)).concat("d"), num);
//    }
//    private void generateDoctor(int i,String name, String sectionName, String title, String introduction){
//        System.out.println(i);
//        if(sectionName == null || sectionName.equals("")){return;}
//        if(title == null || title.equals("")){return;}
//        Section section = sectionDao.getBySecname(sectionName);
//        if(section == null){return;}
//        System.out.println("("+name+") ("+sectionName+") ("+title+") ("+introduction);
//
//        Doctor doctor = new Doctor();
//        doctor.setDoctorId("D"+pad(11,doctorDao.getNum()));
//        doctor.setDoctorName(name);
//        doctor.setDoctorNumber(DataGenUtil.getRandomID());
//        doctor.setDoctorMail(DataGenUtil.getEmail(8,12));
//        doctor.setDoctorPhone(DataGenUtil.getPhone());
//        doctor.setDoctorPassword(DataGenUtil.getPassword());
//        doctor.setDoctorSection(section.getSectionId());
//        doctor.setDoctorTitle(title);
//        doctor.setDoctorStatus(Const.DOCTOR_STATUS_VERIFIED);
//        doctor.setDoctorIntroduction(introduction);
//
//        doctorDao.addDoctor(doctor);
//    }
//
//    @Test
//    public void doctorDataGen() {
//        for(int i=5549;i<=20000;i++) {
////        for(int i=1937;i<=1937;i++) {
//            String strurl = "https://www.pkuph.cn/Article/Index/teamList/id/"+i+".html";
//            System.out.println(i);
//            String name = "";
//            String section = "";
//            String title = "";
//            String introduction = "";
//
//            try {
//                Document document = Jsoup.connect(strurl).get();
//                Element ExpertsPart1 = document.getElementsByClass("ExpertsPart1")
//                        .get(0).getElementsByClass("content").get(0);
//                Element ExpertsPart2 = document.getElementsByClass("ExpertsPart2")
//                        .get(0).getElementsByClass("xkscon").get(0);
//
//                String text = ExpertsPart1.text();
//                name = ExpertsPart1.children().get(0).text();
//                section = StringUtils.substringBetween(text,"科室："," 性别");
//                title = StringUtils.substringBetween(text,"职称："," 专长");
//
//                introduction = ExpertsPart2.text();
//                generateDoctor(i,name,section,title,introduction);
//            } catch (Exception e) {
////                e.printStackTrace();
//            }
//        }
//    }
//
//    @Test
//    public void IDCardTest(){
////        for(int i=1;i<=100;i++) {
////            System.out.println(IDCardUtil.getRandomID());
////        }
//        String idCard = DataGenUtil.getRandomID();
//        System.out.println(idCard);
//        System.out.println(DataGenUtil.getSex(idCard));
//        System.out.println(DataGenUtil.getBirthday(idCard));
//        System.out.println(DataGenUtil.getEmail(8,12));
//        System.out.println(DataGenUtil.getPhone());
//    }
}
