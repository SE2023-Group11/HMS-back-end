package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Section;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SectionDaoTest {
    @Autowired
    private SectionDao sectionDao;

    @Test
    public void getByIdTest(){
        Section section = sectionDao.getById(1);
        System.out.println(section);
    }

    @Test
    public void addSectionTest(){
        Section section = new Section();
        section.setSectionId(0);
        section.setSectionFirname("外科");
        section.setSectionSecname("诊室1");
        section.setSectionIntroduction("");
        sectionDao.addSection(section);
        System.out.println(section);
    }

    @Test
    public void updateSectionTest(){
        Section section = sectionDao.getById(2);
        section.setSectionSecname("222");
        sectionDao.updateSection(section);
    }

    @Test
    public void deleteSectionTest(){
        Section section = sectionDao.getById(3);
        sectionDao.deleteSection(section);
    }
}
