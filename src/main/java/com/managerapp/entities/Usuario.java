package com.managerapp.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String email;

    @OneToMany(mappedBy = "usuarioAsignado", cascade = CascadeType.ALL)
    private List<Tarea> tareas;

    // Constructor por defecto
    public Usuario() {}

    // Constructor con nombre y correo
    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.email = correo;
    }

    // Getters y setters para cada campo

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return email;
    }

    public void setCorreo(String correo) {
        this.email = correo;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }
}
