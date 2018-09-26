package com.axon.task.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Nikolay on 26.09.2018.
 */
@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long size;
    private BigDecimal price;
    private OrderType type;
    private Long operationId;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", size=" + size +
                ", price=" + price +
                ", type=" + type +
                ", operationId=" + operationId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != null ? !id.equals(book.id) : book.id != null) return false;
        if (size != null ? !size.equals(book.size) : book.size != null) return false;
        if (price != null ? !price.equals(book.price) : book.price != null) return false;
        if (type != book.type) return false;
        return operationId != null ? operationId.equals(book.operationId) : book.operationId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (operationId != null ? operationId.hashCode() : 0);
        return result;
    }

    public Long getOperationId() {

        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

}
