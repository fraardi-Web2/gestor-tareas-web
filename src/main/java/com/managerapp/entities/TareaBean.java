package com.managerapp.entities;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class TareaBean {

    @PersistenceContext
    private EntityManager em;

    public void crearTarea(Tarea tarea) {
        em.persist(tarea);
    }

    public Tarea encontrarTareaPorId(Long id) {
        return em.find(Tarea.class, id);
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return em.createQuery("SELECT t FROM Tarea t", Tarea.class).getResultList();
    }

    public void actualizarTarea(Tarea tarea) {
        em.merge(tarea);
    }

    public void eliminarTarea(Long id) {
        Tarea tarea = encontrarTareaPorId(id);
        if (tarea != null) {
            em.remove(tarea);
        }
    }
}
