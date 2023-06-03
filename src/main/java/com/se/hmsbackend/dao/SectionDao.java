package com.se.hmsbackend.dao;

import com.se.hmsbackend.pojo.Section;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SectionDao {
    @Select("SELECT * FROM section WHERE section_id = #{sectionId}")
    public Section getById(Integer sectionId);
    @Select("SELECT * FROM section")
    public List<Section> getAllSections();
    @Select("SELECT * FROM section WHERE section_secname = #{sectionName}")
    public Section getBySecname(String sectionName);
    @Insert("INSERT INTO section (section_firname, section_secname, section_introduction)" +
            "VALUES (#{sectionFirname}, #{sectionSecname}, #{sectionIntroduction})")
    @Options(useGeneratedKeys = true,keyProperty = "sectionId")
    public void addSection(Section section);

    @Update("UPDATE section SET section_firname = #{sectionFirname}, section_secname = #{sectionSecname}, " +
            "section_introduction = #{sectionIntroduction} WHERE section_id = #{sectionId}")
    public void updateSection(Section section);

    @Delete("DELETE FROM section WHERE section_id = #{sectionId}")
    public void deleteSection(Section section);
}
