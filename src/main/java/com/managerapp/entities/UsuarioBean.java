package com.managerapp.entities;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UsuarioBean {

    @PersistenceContext
    private EntityManager em;

    public void crearUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    public Usuario encontrarUsuarioPorId(Long id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return em.createQuery("SELECT u FROM Usuario u", Usuario.class).getResultList();
    }

    public void actualizarUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    public void eliminarUsuario(Long id) {
        Usuario usuario = encontrarUsuarioPorId(id);
        if (usuario != null) {
            em.remove(usuario);
        }
    }
}
