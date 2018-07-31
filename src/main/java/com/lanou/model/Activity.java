package com.lanou.model;

import java.util.Date;

public class Activity {
    private Integer activeId;

    private String activeName;

    private String activeDiscount;

    private String activePostage;

    private String activeCoverurl;

    private String activeBrandstory;

    private String activePrimarytitle;

    private Integer activeEndtime;

    private Date creatTime;

    private Date updateTime;

    private String activeThirdtitle;

    private String activeBrand;

    private Integer activeStatus;

    public Activity() {
        super();
    }

    public Integer getActiveId() {
        return activeId;
    }

    public void setActiveId(Integer activeId) {
        this.activeId = activeId;
    }

    public String getActiveName() {
        return activeName;
    }

    public void setActiveName(String activeName) {
        this.activeName = activeName == null ? null : activeName.trim();
    }

    public String getActiveDiscount() {
        return activeDiscount;
    }

    public void setActiveDiscount(String activeDiscount) {
        this.activeDiscount = activeDiscount == null ? null : activeDiscount.trim();
    }

    public String getActivePostage() {
        return activePostage;
    }

    public void setActivePostage(String activePostage) {
        this.activePostage = activePostage == null ? null : activePostage.trim();
    }

    public String getActiveCoverurl() {
        return activeCoverurl;
    }

    public void setActiveCoverurl(String activeCoverurl) {
        this.activeCoverurl = activeCoverurl == null ? null : activeCoverurl.trim();
    }

    public String getActiveBrandstory() {
        return activeBrandstory;
    }

    public void setActiveBrandstory(String activeBrandstory) {
        this.activeBrandstory = activeBrandstory == null ? null : activeBrandstory.trim();
    }

    public String getActivePrimarytitle() {
        return activePrimarytitle;
    }

    public void setActivePrimarytitle(String activePrimarytitle) {
        this.activePrimarytitle = activePrimarytitle == null ? null : activePrimarytitle.trim();
    }

    public Integer getActiveEndtime() {
        return activeEndtime;
    }

    public void setActiveEndtime(Integer activeEndtime) {
        this.activeEndtime = activeEndtime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getActiveThirdtitle() {
        return activeThirdtitle;
    }

    public void setActiveThirdtitle(String activeThirdtitle) {
        this.activeThirdtitle = activeThirdtitle == null ? null : activeThirdtitle.trim();
    }

    public String getActiveBrand() {
        return activeBrand;
    }

    public void setActiveBrand(String activeBrand) {
        this.activeBrand = activeBrand == null ? null : activeBrand.trim();
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activeId=" + activeId +
                ", activeName='" + activeName + '\'' +
                ", activeDiscount='" + activeDiscount + '\'' +
                ", activePostage='" + activePostage + '\'' +
                ", activeCoverurl='" + activeCoverurl + '\'' +
                ", activeBrandstory='" + activeBrandstory + '\'' +
                ", activePrimarytitle='" + activePrimarytitle + '\'' +
                ", activeEndtime=" + activeEndtime +
                ", creatTime=" + creatTime +
                ", updateTime=" + updateTime +
                ", activeThirdtitle='" + activeThirdtitle + '\'' +
                ", activeBrand='" + activeBrand + '\'' +
                ", activeStatus=" + activeStatus +
                '}';
    }
}