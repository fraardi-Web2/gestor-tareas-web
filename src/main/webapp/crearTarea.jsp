<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Crear Tarea</title>
    <link rel="stylesheet" href="styles.css"> <!-- Enlaza con el archivo CSS -->
</head>
<body>
    <header>
        <h1>Crear Nueva Tarea</h1>
        <nav>
            <ul>
                <li><a href="index.jsp">Inicio</a></li>
                <li><a href="listarTareas.jsp">Ver todas las tareas</a></li>
            </ul>
        </nav>
    </header>
    <main class="container">
        <form action="TareasServlet" method="post" class="form">
            <label for="titulo">Título:</label>
            <input type="text" id="titulo" name="titulo" required>
            <br>
            <label for="descripcion">Descripción:</label>
            <textarea id="descripcion" name="descripcion" rows="4" required></textarea>
            <br>
            <input type="submit" value="Crear Tarea" class="btn">
        </form>
        <br>
        <a href="listarTareas.jsp" class="btn">Volver a la lista de tareas</a>
    </main>
</body>
</html>
