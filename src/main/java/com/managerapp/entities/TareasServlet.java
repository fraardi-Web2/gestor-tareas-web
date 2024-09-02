package com.managerapp.entities;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/TareasServlet")
public class TareasServlet extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        emf = Persistence.createEntityManagerFactory("TaskManagementPU");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String titulo = request.getParameter("titulo");
        String descripcion = request.getParameter("descripcion");
        String estado = "Pendiente"; // Estado por defecto
        Date fechaCreacion = new Date();

        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            em.getTransaction().begin();

            // Obtener un usuario por defecto
            TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.id = :id", Usuario.class);
            query.setParameter("id", 2); // Cambia este valor al ID del usuario por defecto que deseas usar
            Usuario usuarioAsignado = query.getSingleResult();

            Tarea tarea = new Tarea(titulo, descripcion, fechaCreacion, estado, usuarioAsignado);

            em.persist(tarea);
            em.getTransaction().commit();

            response.sendRedirect("tareas.jsp"); // Redirigir a la página de tareas después de crear la tarea
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new ServletException("Error al crear la tarea", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = null;

        try {
            em = emf.createEntityManager();
            TypedQuery<Tarea> query = em.createQuery("SELECT t FROM Tarea t", Tarea.class);
            List<Tarea> tareas = query.getResultList();

            request.setAttribute("tareas", tareas);
            request.getRequestDispatcher("tareas.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error al obtener las tareas", e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void destroy() {
        if (emf != null) {
            emf.close();
        }
    }
}
