package com.fourman.anamdobby.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String homeAddress;
    private String requirements;
    private int price;
    private String cleaningTarget;
    private String roomPassword;

    public OrderDetail() {
    }

    public OrderDetail(String homeAddress, String requirements, int price, String cleaningTarget, String roomPassword) {
        this.homeAddress = homeAddress;
        this.requirements = requirements;
        this.price = price;
        this.cleaningTarget = cleaningTarget;
        this.roomPassword = roomPassword;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDetail that = (OrderDetail) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "id=" + id +
                ", homeAddress='" + homeAddress + '\'' +
                ", requirements='" + requirements + '\'' +
                ", price=" + price +
                ", cleaningTarget='" + cleaningTarget + '\'' +
                ", roomPassword='" + roomPassword + '\'' +
                '}';
    }
}
