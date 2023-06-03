package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.SectionDao;
import com.se.hmsbackend.pojo.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SectionService {
    @Autowired
    private SectionDao sectionDao;

    public Section getById(Integer id) {
        return sectionDao.getById(id);
    }
    public Section getRoomInfo(String roomName){
        return sectionDao.getBySecname(roomName);
    }
    public Section updateRoomInfo(String roomName, String roomInfo){
        Section section = sectionDao.getBySecname(roomName);
        if(section == null)return section;
        section.setSectionIntroduction(roomInfo);
        sectionDao.updateSection(section);
        return section;
    }
    public List<Section> getAllSections(){
        return sectionDao.getAllSections();
    }
}
