package com.fourman.anamdobby.model;

import com.fourman.anamdobby.OrderStatus;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne(cascade = CascadeType.ALL)
    private User author;

    /*
        User.class has Order.class
        to avoid
        @OneToMany List<User> candidates;
    */

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dobby_id")
    private User dobby;

    @OneToOne(cascade = CascadeType.ALL)
    private OrderDetail orderDetail;

    @Enumerated(EnumType.ORDINAL)
    private OrderStatus status;

    private double rate;
    private String review;

    public Order() {
    }

    public Order(User user, OrderDetail orderDetail) {
        this.author = user;
        this.orderDetail = orderDetail;
        this.status = OrderStatus.NOT_STARTED;
    }

    public boolean isNotStarted() {
        return status.equals(OrderStatus.NOT_STARTED);
    }

    public boolean isNotFinished() {
        return !status.equals(OrderStatus.DONE);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public User getDobby() {
        return dobby;
    }

    public void setDobby(User dobby) {
        this.dobby = dobby;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public OrderDetail getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(OrderDetail orderDetail) {
        this.orderDetail = orderDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", author=" + author +
                ", dobby=" + dobby +
                ", orderDetail=" + orderDetail +
                ", status=" + status +
                ", rate=" + rate +
                ", review='" + review + '\'' +
                '}';
    }
}
