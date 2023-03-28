package com.se.hmsbackend.pojo;

public class Section {
    private Integer sectionId;
    private String sectionName;
    private String sectionIntroduction;

    public Section() {
    }

    public Section(Integer sectionId, String sectionName, String sectionIntroduction) {
        this.sectionId = sectionId;
        this.sectionName = sectionName;
        this.sectionIntroduction = sectionIntroduction;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + sectionId +
                ", sectionName='" + sectionName + '\'' +
                ", sectionIntroduction='" + sectionIntroduction + '\'' +
                '}';
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionIntroduction() {
        return sectionIntroduction;
    }

    public void setSectionIntroduction(String sectionIntroduction) {
        this.sectionIntroduction = sectionIntroduction;
    }
}
