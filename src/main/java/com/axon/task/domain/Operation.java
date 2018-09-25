package com.axon.task.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Nikolay on 24.09.2018.
 */
@Entity
@Table(name = "operation")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long operationId278;
    private OperationType operationType279;
    private OrderType orderType269;
    private BigDecimal price270;
    private Long priceSize271;
    @ManyToOne
    @JoinColumn(name = "message_id", nullable = false)
    private Message message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOperationId278() {
        return operationId278;
    }

    public void setOperationId278(Long operationId278) {
        this.operationId278 = operationId278;
    }

    public OperationType getOperationType279() {
        return operationType279;
    }

    public void setOperationType279(OperationType operationType279) {
        this.operationType279 = operationType279;
    }

    public OrderType getOrderType269() {
        return orderType269;
    }

    public void setOrderType269(OrderType orderType269) {
        this.orderType269 = orderType269;
    }

    public BigDecimal getPrice270() {
        return price270;
    }

    public void setPrice270(BigDecimal price270) {
        this.price270 = price270;
    }

    public Long getPriceSize271() {
        return priceSize271;
    }

    public void setPriceSize271(Long priceSize271) {
        this.priceSize271 = priceSize271;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Operation operation = (Operation) o;

        if (id != null ? !id.equals(operation.id) : operation.id != null) return false;
        if (operationId278 != null ? !operationId278.equals(operation.operationId278) : operation.operationId278 != null)
            return false;
        if (operationType279 != operation.operationType279) return false;
        if (orderType269 != operation.orderType269) return false;
        if (price270 != null ? !price270.equals(operation.price270) : operation.price270 != null) return false;
        if (priceSize271 != null ? !priceSize271.equals(operation.priceSize271) : operation.priceSize271 != null)
            return false;
        return message != null ? message.equals(operation.message) : operation.message == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (operationId278 != null ? operationId278.hashCode() : 0);
        result = 31 * result + (operationType279 != null ? operationType279.hashCode() : 0);
        result = 31 * result + (orderType269 != null ? orderType269.hashCode() : 0);
        result = 31 * result + (price270 != null ? price270.hashCode() : 0);
        result = 31 * result + (priceSize271 != null ? priceSize271.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operationId278=" + operationId278 +
                ", operationType279=" + operationType279 +
                ", orderType269=" + orderType269 +
                ", price270=" + price270 +
                ", priceSize271=" + priceSize271 +
                ", message=" + message +
                '}';
    }
}
