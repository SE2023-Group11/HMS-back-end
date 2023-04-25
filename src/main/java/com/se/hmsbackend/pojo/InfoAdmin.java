package com.se.hmsbackend.pojo;

public class InfoAdmin {
    private Integer infoId;
    private Integer detailId;
    private Integer infoType;
    private Integer infoStatus;

    public InfoAdmin() {
    }

    public InfoAdmin(Integer infoId, Integer detailId, Integer infoType, Integer infoStatus) {
        this.infoId = infoId;
        this.detailId = detailId;
        this.infoType = infoType;
        this.infoStatus = infoStatus;
    }

    @Override
    public String toString() {
        return "InfoAdmin{" +
                "infoId=" + infoId +
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
