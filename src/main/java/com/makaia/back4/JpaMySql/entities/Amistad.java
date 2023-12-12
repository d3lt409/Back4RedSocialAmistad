package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(name = "UniqueSolicitante", columnNames = {"solicitante_id", "solicitado_id"}),
    @UniqueConstraint(name = "UniqueSolicitado", columnNames = {"solicitado_id", "solicitante_id"})})
public class Amistad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private boolean isAceptado;

    @Column(nullable = true)
    private Date desde;

    @ManyToOne(optional = false)
    // @Column(name = "solicitante_id", nullable = false)
    @JoinColumn(name="solicitante_id", nullable=false)
    Usuario solicitante;

    @ManyToOne(optional = false)
    @JoinColumn(name="solicitado_id", nullable=false)
    // @Column(name = "solicitado_id", nullable = false)
    Usuario solicitado;


    public Amistad() {
    }

    public Amistad(boolean isAceptado, Date desde, Usuario solicitante, Usuario solicitado) {
        this.isAceptado = isAceptado;
        this.desde = desde;
        this.solicitante = solicitante;
        this.solicitado = solicitado;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDesde() {
        return this.desde;
    }

    public void setDesde(Date desde) {
        this.desde = desde;
    }

    public Usuario getSolicitante() {
        return this.solicitante;
    }

    public void setSolicitante(Usuario solicitante) {
        this.solicitante = solicitante;
    }

    public Usuario getSolicitado() {
        return this.solicitado;
    }

    public void setSolicitado(Usuario solicitado) {
        this.solicitado = solicitado;
    }

    public Amistad id(Long id) {
        setId(id);
        return this;
    }

    public Amistad isAceptado(boolean isAceptado) {
        setIsAceptado(isAceptado);
        return this;
    }

    public Amistad desde(Date desde) {
        setDesde(desde);
        return this;
    }

    public Amistad solicitante(Usuario solicitante) {
        setSolicitante(solicitante);
        return this;
    }

    public Amistad solicitado(Usuario solicitado) {
        setSolicitado(solicitado);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Amistad)) {
            return false;
        }
        Amistad amistad = (Amistad) o;
        return Objects.equals(id, amistad.id) && isAceptado == amistad.isAceptado && Objects.equals(desde, amistad.desde) && Objects.equals(solicitante, amistad.solicitante) && Objects.equals(solicitado, amistad.solicitado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isAceptado, desde, solicitante, solicitado);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", isAceptado='" + isIsAceptado() + "'" +
            ", desde='" + getDesde() + "'" +
            ", solicitante='" + getSolicitante() + "'" +
            ", solicitado='" + getSolicitado() + "'" +
            "}";
    }
    
}
