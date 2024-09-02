<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Detalle de Tarea</title>
    <link rel="stylesheet" href="styles.css"> <!-- Enlaza con el archivo CSS -->
</head>
<body>
    <header>
        <h1>Detalle de la Tarea</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="listarTareas.jsp">Ver todas las tareas</a></li>
            </ul>
        </nav>
    </header>
    <main class="container">
        <h2>Tarea ID: ${tarea.id}</h2>
        <p><strong>Título:</strong> ${tarea.titulo}</p>
        <p><strong>Descripción:</strong> ${tarea.descripcion}</p>
        <p><strong>Estado:</strong> ${tarea.estado}</p>
        <p><strong>Fecha de Creación:</strong> ${tarea.fechaCreacion}</p>
        <br>
        <a href="editarTarea.jsp?id=${tarea.id}" class="btn">Editar</a>
        <a href="TareasServlet?action=delete&id=${tarea.id}" class="btn btn-danger">Eliminar</a>
        <br><br>
        <a href="listarTareas.jsp" class="btn">Volver a la lista de tareas</a>
    </main>
</body>
</html>
