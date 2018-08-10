package com.lanou.model;

import java.util.List;

public class Order {
    private Integer orderId;

    private Integer orderReceiveradressId;

    private Integer orderShopcartStatus;

    private Integer invoiceType;

    private String personCompany;

    private Integer orderUserId;

    private String orderNumber;

    private List<ReceiverAdress> adressList;

    private List<ShopCart> cartList;

    private List<Goods> goodsList;

    private List<Size> sizes;

    public Order() {
        super();
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public List<Size> getSizes() {
        return sizes;
    }

    public void setSizes(List<Size> sizes) {
        this.sizes = sizes;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderReceiveradressId=" + orderReceiveradressId +
                ", orderShopcartStatus=" + orderShopcartStatus +
                ", invoiceType=" + invoiceType +
                ", personCompany='" + personCompany + '\'' +
                ", orderUserId=" + orderUserId +
                ", orderNumber=" + orderNumber +
                ", adressList=" + adressList +
                ", cartList=" + cartList +
                ", goodsList=" + goodsList +
                ", sizes=" + sizes +
                '}';
    }

    public List<ReceiverAdress> getAdressList() {
        return adressList;
    }

    public void setAdressList(List<ReceiverAdress> adressList) {
        this.adressList = adressList;
    }

    public List<ShopCart> getCartList() {
        return cartList;
    }

    public void setCartList(List<ShopCart> cartList) {
        this.cartList = cartList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderReceiveradressId() {
        return orderReceiveradressId;
    }

    public void setOrderReceiveradressId(Integer orderReceiveradressId) {
        this.orderReceiveradressId = orderReceiveradressId;
    }

    public Integer getOrderShopcartStatus() {
        return orderShopcartStatus;
    }

    public void setOrderShopcartStatus(Integer orderShopcartStatus) {
        this.orderShopcartStatus = orderShopcartStatus;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getPersonCompany() {
        return personCompany;
    }

    public void setPersonCompany(String personCompany) {
        this.personCompany = personCompany == null ? null : personCompany.trim();
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}