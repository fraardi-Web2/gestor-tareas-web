<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Tareas</title>
    <link rel="stylesheet" href="styles.css"> <!-- Enlaza con el archivo CSS -->
</head>
<body>
    <header>
        <h1>Lista de Tareas</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="crearTarea.jsp">Crear nueva tarea</a></li>
            </ul>
        </nav>
    </header>
    <main class="container">
        <table class="task-table">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tarea" items="${tareas}">
                    <tr>
                        <td>${tarea.id}</td>
                        <td>${tarea.titulo}</td>
                        <td>${tarea.descripcion}</td>
                        <td>
                            <a href="editarTarea.jsp?id=${tarea.id}" class="btn">Editar</a> |
                            <a href="TareasServlet?action=delete&id=${tarea.id}" class="btn btn-danger">Eliminar</a> |
                            <a href="detalleTarea.jsp?id=${tarea.id}" class="btn">Ver Detalle</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <br>
        <a href="crearTarea.jsp" class="btn">Crear nueva tarea</a>
        <br><br>
        <a href="index.jsp" class="btn">Volver al inicio</a>
    </main>
</body>
</html>
