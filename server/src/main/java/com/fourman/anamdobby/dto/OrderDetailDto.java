package com.fourman.anamdobby.dto;

import com.fourman.anamdobby.model.OrderDetail;

public class OrderDetailDto {
    private String homeAddress;
    private String requirements;
    private int price;
    private String cleaningTarget;
    private String roomPassword;

    public OrderDetailDto() {
    }

    public OrderDetailDto(String homeAddress, String requirements, int price, String cleaningTarget, String roomPassword) {
        this.homeAddress = homeAddress;
        this.requirements = requirements;
        this.price = price;
        this.cleaningTarget = cleaningTarget;
        this.roomPassword = roomPassword;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCleaningTarget() {
        return cleaningTarget;
    }

    public void setCleaningTarget(String cleaningTarget) {
        this.cleaningTarget = cleaningTarget;
    }

    public String getRoomPassword() {
        return roomPassword;
    }

    public void setRoomPassword(String roomPassword) {
        this.roomPassword = roomPassword;
    }

    public OrderDetail toEntity() {
        return new OrderDetail(homeAddress, requirements, price, cleaningTarget, roomPassword);
    }
}
