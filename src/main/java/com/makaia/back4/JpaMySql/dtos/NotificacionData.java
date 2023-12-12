package com.makaia.back4.JpaMySql.dtos;
import java.util.Objects;

public class NotificacionData {
    private Long emisorId;
    private Long notificadoId;

    public NotificacionData(Long emisorId, Long notificadoId) {
        this.emisorId = emisorId;
        this.notificadoId = notificadoId;
    }


    public NotificacionData() {
    }

    public Long getEmisorId() {
        return this.emisorId;
    }

    public void setEmisorId(Long emisorId) {
        this.emisorId = emisorId;
    }

    public Long getNotificadoId() {
        return this.notificadoId;
    }

    public void setNotificadoId(Long notificadoId) {
        this.notificadoId = notificadoId;
    }

    public NotificacionData emisorId(Long emisorId) {
        setEmisorId(emisorId);
        return this;
    }

    public NotificacionData notificadoId(Long notificadoId) {
        setNotificadoId(notificadoId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof NotificacionData)) {
            return false;
        }
        NotificacionData notificacionData = (NotificacionData) o;
        return Objects.equals(emisorId, notificacionData.emisorId) && Objects.equals(notificadoId, notificacionData.notificadoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emisorId, notificadoId);
    }

    @Override
    public String toString() {
        return "{" +
            " emisorId='" + getEmisorId() + "'" +
            ", notificadoId='" + getNotificadoId() + "'" +
            "}";
    }
    
}
