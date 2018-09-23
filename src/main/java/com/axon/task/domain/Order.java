package com.axon.task.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by Nikolay on 20.09.2018.
 */
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private OrderType type;
    private Long orderId;
    private BigDecimal price;
    private Long size;
    private Long orderAction;
    private int msgId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public Long getOrderAction() {
        return orderAction;
    }

    public void setOrderAction(Long orderAction) {
        this.orderAction = orderAction;
    }

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", type=" + type +
                ", orderId=" + orderId +
                ", price=" + price +
                ", size=" + size +
                ", orderAction=" + orderAction +
                ", msgId=" + msgId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (msgId != order.msgId) return false;
        if (id != null ? !id.equals(order.id) : order.id != null) return false;
        if (date != null ? !date.equals(order.date) : order.date != null) return false;
        if (type != order.type) return false;
        if (orderId != null ? !orderId.equals(order.orderId) : order.orderId != null) return false;
        if (price != null ? !price.equals(order.price) : order.price != null) return false;
        if (size != null ? !size.equals(order.size) : order.size != null) return false;
        return orderAction != null ? orderAction.equals(order.orderAction) : order.orderAction == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (orderAction != null ? orderAction.hashCode() : 0);
        result = 31 * result + msgId;
        return result;
    }
}
