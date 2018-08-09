package com.lanou.model;

import java.util.List;

public class ShopCart {
    private Integer shopcartId;

    private Integer shopcartSizeId;

    private Integer purchaseQuantity;

    private Integer status;

    private Integer isclick;

    private Integer isdel;

    private Integer shopcartUserId;

    private List<Goods> goodsList;

    @Override
    public String toString() {
        return "ShopCart{" +
                "shopcartId=" + shopcartId +
                ", shopcartSizeId=" + shopcartSizeId +
                ", purchaseQuantity=" + purchaseQuantity +
                ", status=" + status +
                ", isclick=" + isclick +
                ", isdel=" + isdel +
                ", shopcartUserId=" + shopcartUserId +
                ", goodsList=" + goodsList +
                '}';
    }

    public ShopCart() {
        super();
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getShopcartId() {
        return shopcartId;
    }

    public void setShopcartId(Integer shopcartId) {
        this.shopcartId = shopcartId;
    }

    public Integer getShopcartSizeId() {
        return shopcartSizeId;
    }

    public void setShopcartSizeId(Integer shopcartSizeId) {
        this.shopcartSizeId = shopcartSizeId;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsclick() {
        return isclick;
    }

    public void setIsclick(Integer isclick) {
        this.isclick = isclick;
    }

    public Integer getIsdel() {
        return isdel;
    }

    public void setIsdel(Integer isdel) {
        this.isdel = isdel;
    }

    public Integer getShopcartUserId() {
        return shopcartUserId;
    }

    public void setShopcartUserId(Integer shopcartUserId) {
        this.shopcartUserId = shopcartUserId;
    }
}