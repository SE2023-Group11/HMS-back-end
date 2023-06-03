package com.se.hmsbackend.pojo;

public class Section {
    private Integer sectionId;
    private String sectionFirname;
    private String sectionSecname;
    private String sectionIntroduction;

    public Section() {
    }

    public Section(Integer sectionId, String sectionFirname, String sectionSecname, String sectionIntroduction) {
        this.sectionId = sectionId;
        this.sectionFirname = sectionFirname;
        this.sectionSecname = sectionSecname;
        this.sectionIntroduction = sectionIntroduction;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + sectionId +
                ", sectionFirname='" + sectionFirname + '\'' +
                ", sectionSecname='" + sectionSecname + '\'' +
                ", sectionIntroduction='" + sectionIntroduction + '\'' +
                '}';
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionFirname() {
        return sectionFirname;
    }

    public void setSectionFirname(String sectionFirname) {
        this.sectionFirname = sectionFirname;
    }

    public String getSectionSecname() {
        return sectionSecname;
    }

    public void setSectionSecname(String sectionSecname) {
        this.sectionSecname = sectionSecname;
    }

    public String getSectionIntroduction() {
        return sectionIntroduction;
    }

    public void setSectionIntroduction(String sectionIntroduction) {
        this.sectionIntroduction = sectionIntroduction;
    }
}
