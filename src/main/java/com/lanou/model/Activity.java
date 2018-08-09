package com.lanou.model;

import java.util.Date;
import java.util.List;

public class Activity {
    private Integer activeId;

    private String activeName;

    private String activeDiscount;

    private String activePostage;

    private String activeCoverurl;

    private String activeBrandstory;

    private String activePrimarytitle;

    private Date updateTime;

    private Integer activeEndtime;

    private Integer activeStatus;

    private Date creatTime;

    private String activeBrand;

    private List<Goods> goodsList;

    private List goodsThirdtitle;
    private List goodsBrand;

    public Activity() {
        super();
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
                ", updateTime=" + updateTime +
                ", activeEndtime=" + activeEndtime +
                ", activeStatus=" + activeStatus +
                ", creatTime=" + creatTime +
                ", activeBrand='" + activeBrand + '\'' +
                ", goodsList=" + goodsList +
                ", goodsThirdtitle=" + goodsThirdtitle +
                ", goodsBrand=" + goodsBrand +
                '}';
    }

    public List getGoodsThirdtitle() {
        return goodsThirdtitle;
    }

    public void setGoodsThirdtitle(List goodsThirdtitle) {
        this.goodsThirdtitle = goodsThirdtitle;
    }

    public List getGoodsBrand() {
        return goodsBrand;
    }

    public void setGoodsBrand(List goodsBrand) {
        this.goodsBrand = goodsBrand;
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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getActiveEndtime() {
        return activeEndtime;
    }

    public void setActiveEndtime(Integer activeEndtime) {
        this.activeEndtime = activeEndtime;
    }

    public Integer getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(Integer activeStatus) {
        this.activeStatus = activeStatus;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getActiveBrand() {
        return activeBrand;
    }

    public void setActiveBrand(String activeBrand) {
        this.activeBrand = activeBrand == null ? null : activeBrand.trim();
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }


}