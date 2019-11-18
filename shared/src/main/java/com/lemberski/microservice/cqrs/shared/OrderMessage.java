package com.lemberski.microservice.cqrs.shared;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class OrderMessage implements Serializable {

    public static final String QUEUE = "cqrx";
    public static final String TOPIC = "orders";
    private static final long serialVersionUID = 1L;

    private Long orderId;
    private String userId;
    private Date orderDate;
    private Double totalPrice;
    private String status;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderMessage{" +
                "orderId=" + orderId +
                ", userId='" + userId + '\'' +
                ", orderDate=" + orderDate +
                ", totalPrice=" + totalPrice +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderMessage that = (OrderMessage) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(orderDate, that.orderDate) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userId, orderDate, totalPrice, status);
    }

}