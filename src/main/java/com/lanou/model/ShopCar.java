package com.lanou.model;

import java.util.List;

public class ShopCar {
    private Integer shopcarId;

    private Integer shopcarSizeId;

    private Integer status;

    private List<Goods> goodsList;

    public ShopCar() {
        super();
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public Integer getShopcarId() {
        return shopcarId;
    }

    public void setShopcarId(Integer shopcarId) {
        this.shopcarId = shopcarId;
    }

    public Integer getShopcarSizeId() {
        return shopcarSizeId;
    }

    public void setShopcarSizeId(Integer shopcarSizeId) {
        this.shopcarSizeId = shopcarSizeId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ShopCar{" +
                "shopcarId=" + shopcarId +
                ", shopcarSizeId=" + shopcarSizeId +
                ", status=" + status +
                ", goodsList=" + goodsList +
                '}';
    }
}