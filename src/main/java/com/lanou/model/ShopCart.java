package com.lanou.model;

public class ShopCart {
    private Integer shopcartId;

    private Integer shopcartSizeId;

    private Integer purchaseQuantity;

    private Integer status;

    private Integer isclick;

    private Integer isdel;

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
}