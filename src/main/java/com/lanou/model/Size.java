package com.lanou.model;

public class Size {
    private Integer sizeId;

    private String sizeName;

    private Integer goodsSizeId;

    private String goodsNumber;

    private Integer sizeCount;

    private Integer sizeStatus;

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName == null ? null : sizeName.trim();
    }

    public Integer getGoodsSizeId() {
        return goodsSizeId;
    }

    public void setGoodsSizeId(Integer goodsSizeId) {
        this.goodsSizeId = goodsSizeId;
    }

    public String getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(String goodsNumber) {
        this.goodsNumber = goodsNumber == null ? null : goodsNumber.trim();
    }

    public Integer getSizeCount() {
        return sizeCount;
    }

    public void setSizeCount(Integer sizeCount) {
        this.sizeCount = sizeCount;
    }

    public Integer getSizeStatus() {
        return sizeStatus;
    }

    public void setSizeStatus(Integer sizeStatus) {
        this.sizeStatus = sizeStatus;
    }
}