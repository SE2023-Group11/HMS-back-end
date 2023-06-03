package com.se.hmsbackend.common;

import com.se.hmsbackend.dao.SectionDao;
import com.se.hmsbackend.pojo.Section;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class SectionDataGen {
//    @Autowired
//    private SectionDao sectionDao;
//    private String firname = null;
//    private String secname = null;
//    private String inturl = null;
//    private String introduction = null;
//    private int maxx = 0;
//
//    private String getIntroduction(String strurl){
//        try {
//            Document document = Jsoup.connect(strurl).get();
//            Element xkscon = document.getElementsByClass("xkscon").get(0);
//            return xkscon.text();
//        } catch (Exception e) {
////            e.printStackTrace();
//        }
//        return "";
//    }
//    @Test
//    public void sectionDataGen() {
//        String strurl = "https://www.pkuph.cn/department_list.html";
//        try{
//            Document document = Jsoup.connect(strurl).get();
//            List<Element> list = document.getElementsByClass("Department");
//            Element department = list.get(0);
//            Elements elements = department.children();
//
//            elements.forEach(element -> {
//                if("h1".equals(element.tagName())){
//                    firname = element.text();
//                }
//                if("div".equals(element.tagName())&&!"研究所、研究中心".equals(firname)){
//                    Elements div = element.getElementsByTag("ul").get(0).children();
//                    div.forEach(sec -> {
//                        secname = sec.text();
//                        inturl = "https://www.pkuph.cn/" + sec.select("a[href]").attr("href");
//                        introduction = getIntroduction(inturl);
////                        System.out.println(introduction);
//                        if(introduction.length() > maxx)maxx =introduction.length();
//
//                        Section newSection = new Section(0,firname,secname,introduction);
////                        System.out.println(newSection);
////                        sectionDao.addSection(newSection);
//                    });
//                }
//            });
//            System.out.println(maxx);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
