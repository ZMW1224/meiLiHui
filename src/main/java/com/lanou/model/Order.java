package com.lanou.model;

import java.util.List;

public class Order {
    private Integer orderId;

    private Integer orderReceiveradressStatus;

    private String payment;

    private Integer orderShopcart;

    private Integer invoiceType;

    private String personCompany;

    private List<ShopCart> cartList;

    private ReceiverAdress receiverAdress;

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

    public Integer getOrderReceiveradressStatus() {
        return orderReceiveradressStatus;
    }

    public void setOrderReceiveradressStatus(Integer orderReceiveradressStatus) {
        this.orderReceiveradressStatus = orderReceiveradressStatus;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment == null ? null : payment.trim();
    }

    public Integer getOrderShopcart() {
        return orderShopcart;
    }

    public void setOrderShopcart(Integer orderShopcart) {
        this.orderShopcart = orderShopcart;
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

    public ReceiverAdress getReceiverAdress() {
        return receiverAdress;
    }

    public void setReceiverAdress(ReceiverAdress receiverAdress) {
        this.receiverAdress = receiverAdress;
    }

    public Order() {
        super();
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderReceiveradressStatus=" + orderReceiveradressStatus +
                ", payment='" + payment + '\'' +
                ", orderShopcart=" + orderShopcart +
                ", invoiceType=" + invoiceType +
                ", personCompany='" + personCompany + '\'' +
                ", cartList=" + cartList +
                ", receiverAdress=" + receiverAdress +
                '}';
    }
}