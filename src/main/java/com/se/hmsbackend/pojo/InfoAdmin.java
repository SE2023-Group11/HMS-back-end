package com.se.hmsbackend.pojo;

public class InfoAdmin {
    private Integer infoId;
    private Integer adminId;
    private Integer detailId;
    private Integer infoType;
    private Integer infoStatus;

    public InfoAdmin() {
    }

    public InfoAdmin(Integer infoId, Integer adminId, Integer detailId, Integer infoType, Integer infoStatus) {
        this.infoId = infoId;
        this.adminId = adminId;
        this.detailId = detailId;
        this.infoType = infoType;
        this.infoStatus = infoStatus;
    }

    @Override
    public String toString() {
        return "InfoAdmin{" +
                "infoId=" + infoId +
                ", adminId=" + adminId +
                ", detailId=" + detailId +
                ", infoType=" + infoType +
                ", infoStatus=" + infoStatus +
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

    public Integer getInfoType() {
        return infoType;
    }

    public void setInfoType(Integer infoType) {
        this.infoType = infoType;
    }

    public Integer getDetailId() {
        return detailId;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public Integer getInfoStatus() {
        return infoStatus;
    }

    public void setInfoStatus(Integer infoStatus) {
        this.infoStatus = infoStatus;
    }
}
