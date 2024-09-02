<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Tareas</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Lista de Tareas</h1>
        <table class="task-table">
            <thead>
                <tr>
                    <th>Título</th>
                    <th>Descripción</th>
                    <th>Estado</th>
                    <th>Fecha de Creación</th>
                    <th>Usuario Asignado</th>
                </tr>
            </thead>
            <tbody>
                <% List<Tarea> tareas = (List<Tarea>) request.getAttribute("tareas");
                   if (tareas != null) {
                       for (Tarea tarea : tareas) { %>
                <tr>
                    <td><%= tarea.getTitulo() %></td>
                    <td><%= tarea.getDescripcion() %></td>
                    <td><%= tarea.getEstado() %></td>
                    <td><%= tarea.getFechaCreacion() %></td>
                    <td><%= tarea.getUsuario().getNombre() %></td>
                </tr>
                <% } 
                   } %>
            </tbody>
        </table>
        <a href="crearTarea.jsp" class="btn">Crear Nueva Tarea</a>
    </div>
</body>
</html>
