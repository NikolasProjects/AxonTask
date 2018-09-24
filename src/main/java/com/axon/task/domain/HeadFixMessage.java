package com.axon.task.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by Nikolay on 24.09.2018.
 */
@Entity
@Table(name = "head_fix_message")
public class HeadFixMessage {
    private String typeProtocol8;
    private Long sizeMsg9;
    private String typeMsg35;
    @Id
    private Long idMsg34;
    private String idSender49;
    private LocalDateTime timeMsg52;
    private String idAddressee56;

    public String getTypeProtocol8() {
        return typeProtocol8;
    }

    public void setTypeProtocol8(String typeProtocol8) {
        this.typeProtocol8 = typeProtocol8;
    }

    public Long getSizeMsg9() {
        return sizeMsg9;
    }

    public void setSizeMsg9(Long sizeMsg9) {
        this.sizeMsg9 = sizeMsg9;
    }

    public String getTypeMsg35() {
        return typeMsg35;
    }

    public void setTypeMsg35(String typeMsg35) {
        this.typeMsg35 = typeMsg35;
    }

    public Long getIdMsg34() {
        return idMsg34;
    }

    public void setIdMsg34(Long idMsg34) {
        this.idMsg34 = idMsg34;
    }

    public String getIdSender49() {
        return idSender49;
    }

    public void setIdSender49(String idSender49) {
        this.idSender49 = idSender49;
    }

    public LocalDateTime getTimeMsg52() {
        return timeMsg52;
    }

    public void setTimeMsg52(LocalDateTime timeMsg52) {
        this.timeMsg52 = timeMsg52;
    }

    public String getIdAddressee56() {
        return idAddressee56;
    }

    public void setIdAddressee56(String idAddressee56) {
        this.idAddressee56 = idAddressee56;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeadFixMessage that = (HeadFixMessage) o;

        if (typeProtocol8 != null ? !typeProtocol8.equals(that.typeProtocol8) : that.typeProtocol8 != null)
            return false;
        if (sizeMsg9 != null ? !sizeMsg9.equals(that.sizeMsg9) : that.sizeMsg9 != null) return false;
        if (typeMsg35 != null ? !typeMsg35.equals(that.typeMsg35) : that.typeMsg35 != null) return false;
        if (idMsg34 != null ? !idMsg34.equals(that.idMsg34) : that.idMsg34 != null) return false;
        if (idSender49 != null ? !idSender49.equals(that.idSender49) : that.idSender49 != null) return false;
        if (timeMsg52 != null ? !timeMsg52.equals(that.timeMsg52) : that.timeMsg52 != null) return false;
        return idAddressee56 != null ? idAddressee56.equals(that.idAddressee56) : that.idAddressee56 == null;

    }

    @Override
    public int hashCode() {
        int result = typeProtocol8 != null ? typeProtocol8.hashCode() : 0;
        result = 31 * result + (sizeMsg9 != null ? sizeMsg9.hashCode() : 0);
        result = 31 * result + (typeMsg35 != null ? typeMsg35.hashCode() : 0);
        result = 31 * result + (idMsg34 != null ? idMsg34.hashCode() : 0);
        result = 31 * result + (idSender49 != null ? idSender49.hashCode() : 0);
        result = 31 * result + (timeMsg52 != null ? timeMsg52.hashCode() : 0);
        result = 31 * result + (idAddressee56 != null ? idAddressee56.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HeadFixMessage{" +
                "typeProtocol8='" + typeProtocol8 + '\'' +
                ", sizeMsg9=" + sizeMsg9 +
                ", typeMsg35='" + typeMsg35 + '\'' +
                ", idMsg34=" + idMsg34 +
                ", idSender49='" + idSender49 + '\'' +
                ", timeMsg52=" + timeMsg52 +
                ", idAddressee56='" + idAddressee56 + '\'' +
                '}';
    }
}
