package com.se.hmsbackend.pojo;

public class InfoAdmin {
    private Integer infoId;
    private Integer adminId;
    private String infoBody;
    private Integer infoType;

    public InfoAdmin() {
    }

    public InfoAdmin(Integer infoId, Integer adminId, String infoBody, Integer infoType) {
        this.infoId = infoId;
        this.adminId = adminId;
        this.infoBody = infoBody;
        this.infoType = infoType;
    }

    @Override
    public String toString() {
        return "InfoAdmin{" +
                "infoId=" + infoId +
                ", adminId=" + adminId +
                ", infoBody='" + infoBody + '\'' +
                ", infoType=" + infoType +
                '}';
    }

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getInfoBody() {
        return infoBody;
    }

    public void setInfoBody(String infoBody) {
        this.infoBody = infoBody;
    }

    public Integer getInfoType() {
        return infoType;
    }

    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }
}
