package com.axon.task.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

/**
 * Created by Nikolay on 24.09.2018.
 */
@Entity
@Table(name = "body_fix_message")
public class BodyFixMessage {
    private Integer typeOperation279;
    private Integer typeOrder269;
    @Id
    private Long idOperation278;
    private BigDecimal price270;
    private Long sizePrice271;

    public Integer getTypeOperation279() {
        return typeOperation279;
    }

    public void setTypeOperation279(Integer typeOperation279) {
        this.typeOperation279 = typeOperation279;
    }

    public Integer getTypeOrder269() {
        return typeOrder269;
    }

    public void setTypeOrder269(Integer typeOrder269) {
        this.typeOrder269 = typeOrder269;
    }

    public Long getIdOperation278() {
        return idOperation278;
    }

    public void setIdOperation278(Long idOperation278) {
        this.idOperation278 = idOperation278;
    }

    public BigDecimal getPrice270() {
        return price270;
    }

    public void setPrice270(BigDecimal price270) {
        this.price270 = price270;
    }

    public Long getSizePrice271() {
        return sizePrice271;
    }

    public void setSizePrice271(Long sizePrice271) {
        this.sizePrice271 = sizePrice271;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BodyFixMessage that = (BodyFixMessage) o;

        if (typeOperation279 != null ? !typeOperation279.equals(that.typeOperation279) : that.typeOperation279 != null)
            return false;
        if (typeOrder269 != null ? !typeOrder269.equals(that.typeOrder269) : that.typeOrder269 != null) return false;
        if (idOperation278 != null ? !idOperation278.equals(that.idOperation278) : that.idOperation278 != null)
            return false;
        if (price270 != null ? !price270.equals(that.price270) : that.price270 != null) return false;
        return sizePrice271 != null ? sizePrice271.equals(that.sizePrice271) : that.sizePrice271 == null;

    }

    @Override
    public int hashCode() {
        int result = typeOperation279 != null ? typeOperation279.hashCode() : 0;
        result = 31 * result + (typeOrder269 != null ? typeOrder269.hashCode() : 0);
        result = 31 * result + (idOperation278 != null ? idOperation278.hashCode() : 0);
        result = 31 * result + (price270 != null ? price270.hashCode() : 0);
        result = 31 * result + (sizePrice271 != null ? sizePrice271.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BodyFixMessage{" +
                "typeOperation279=" + typeOperation279 +
                ", typeOrder269=" + typeOrder269 +
                ", idOperation278=" + idOperation278 +
                ", price270=" + price270 +
                ", sizePrice271=" + sizePrice271 +
                '}';
    }
}
