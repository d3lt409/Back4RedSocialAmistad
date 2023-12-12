package com.makaia.back4.JpaMySql.dtos;

import java.util.Date;
import java.util.Objects;

public class CrearDTO {
    private Date desde;

    private boolean isAceptado;

    private Long solicitanteId;

    private Long solicitadoId;


    public CrearDTO() {
    }


    public CrearDTO(Date desde, boolean isAceptado, Long solicitanteId, Long solicitadoId) {
        this.desde = desde;
        this.isAceptado = isAceptado;
        this.solicitanteId = solicitanteId;
        this.solicitadoId = solicitadoId;
    }

    public Date getDesde() {
        return this.desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public boolean isIsAceptado() {
        return this.isAceptado;
    }

    public boolean getIsAceptado() {
        return this.isAceptado;
    }

    public void setIsAceptado(boolean isAceptado) {
        this.isAceptado = isAceptado;
    }

    public Long getSolicitanteId() {
        return this.solicitanteId;
    }

    public void setSolicitanteId(Long solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public Long getSolicitadoId() {
        return this.solicitadoId;
    }

    public void setSolicitadoId(Long solicitadoId) {
        this.solicitadoId = solicitadoId;
    }

    public CrearDTO desde(Date desde) {
        setDesde(desde);
        return this;
    }

    public CrearDTO isAceptado(boolean isAceptado) {
        setIsAceptado(isAceptado);
        return this;
    }

    public CrearDTO solicitanteId(Long solicitanteId) {
        setSolicitanteId(solicitanteId);
        return this;
    }

    public CrearDTO solicitadoId(Long solicitadoId) {
        setSolicitadoId(solicitadoId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof CrearDTO)) {
            return false;
        }
        CrearDTO crearDTO = (CrearDTO) o;
        return Objects.equals(desde, crearDTO.desde) && isAceptado == crearDTO.isAceptado && Objects.equals(solicitanteId, crearDTO.solicitanteId) && Objects.equals(solicitadoId, crearDTO.solicitadoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(desde, isAceptado, solicitanteId, solicitadoId);
    }

    @Override
    public String toString() {
        return "{" +
            " desde='" + getDesde() + "'" +
            ", isAceptado='" + isIsAceptado() + "'" +
            ", solicitanteId='" + getSolicitanteId() + "'" +
            ", solicitadoId='" + getSolicitadoId() + "'" +
            "}";
    }
   
    



    
}
