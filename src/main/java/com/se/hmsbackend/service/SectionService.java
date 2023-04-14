package com.se.hmsbackend.service;

import com.se.hmsbackend.dao.SectionDao;
import com.se.hmsbackend.pojo.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SectionService {
    @Autowired
    private SectionDao sectionDao;

    public Section getRoomInfo(String roomName){
        return sectionDao.getBySecname(roomName);
    }
    public boolean updateRoomInfo(String roomName, String roomInfo){
        Section section = sectionDao.getBySecname(roomName);
        if(section == null)return false;
        section.setSectionIntroduction(roomInfo);
        sectionDao.updateSection(section);
        return true;
    }
}
