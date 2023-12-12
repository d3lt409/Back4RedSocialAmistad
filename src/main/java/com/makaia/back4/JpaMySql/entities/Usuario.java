package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(length = 50)
    private String nombre;

    @Column(length = 50)
    private String apellido;

    @Column(length = 150)
    private String direccion;

    @Column
    private Integer edad;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido, String direccion, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    @OneToMany(mappedBy = "usuario")
    List<Publicacion> publicaciones;

    @OneToMany(mappedBy = "emisor")
    List<Mensaje> mensajesEnviados;

    @OneToMany(mappedBy = "receptor")
    List<Mensaje> mensajesRecibidos;

    @OneToMany(mappedBy = "usuario")
    List<Comentario> comentarios;

}
