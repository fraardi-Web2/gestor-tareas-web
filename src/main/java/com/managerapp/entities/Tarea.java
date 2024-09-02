package com.managerapp.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String descripcion;

    @Temporal(TemporalType.DATE)
    private Date fecha_creacion;

    private String estado;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioAsignado;

    // Constructor por defecto
    public Tarea() {}

    // Constructor para la creación de una nueva tarea
    public Tarea(String titulo, String descripcion, Date fechaCreacion, String estado, Usuario usuarioAsignado) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha_creacion = fechaCreacion;
        this.estado = estado;
        this.usuarioAsignado = usuarioAsignado;
    }

    // Getters y setters para cada campo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fecha_creacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fecha_creacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuarioAsignado() {
        return usuarioAsignado;
    }

    public void setUsuarioAsignado(Usuario usuarioAsignado) {
        this.usuarioAsignado = usuarioAsignado;
    }
}
