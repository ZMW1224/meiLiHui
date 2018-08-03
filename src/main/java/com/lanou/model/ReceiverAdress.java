package com.lanou.model;

public class ReceiverAdress {
    private Integer receiverId;

    private String receiverName;

    private String receiverPhone;

    private String province;

    private String city;

    private String county;

    private String detailedAddress;

    private String postalCode;

    private Integer userReceiverId;

    private Integer status;

    public ReceiverAdress() {
        super();
    }

    @Override
    public String toString() {
        return "ReceiverAdress{" +
                "receiverId=" + receiverId +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", county='" + county + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", userReceiverId=" + userReceiverId +
                ", status=" + status +
                '}';
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county == null ? null : county.trim();
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress == null ? null : detailedAddress.trim();
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode == null ? null : postalCode.trim();
    }

    public Integer getUserReceiverId() {
        return userReceiverId;
    }

    public void setUserReceiverId(Integer userReceiverId) {
        this.userReceiverId = userReceiverId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}