<%@page import="bean.Tasks"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit Task</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
            background-image: url('images/task2.jpg');
            background-repeat: no-repeat;
            background-size: cover;
        }

        /* Navbar */
        .navbar {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            background-color: #333;
            margin-bottom: 20px;
        }
        .navbar a {
            color: white;
            padding: 10px 15px;
            text-decoration: none;
            margin: 3px;
            border-radius: 4px;
            background-color: #4CAF50;
        }
        .navbar a:hover { background-color: #45a049; }

        /* Container */
        .container {
            width: 450px;
            margin: 20px auto;
            background: #fff;
            padding: 25px 30px;
            border-radius: 8px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
            opacity: 0.9;
        }

        h2 { text-align: center; margin-bottom: 25px; color: #333; }

        form { display: flex; flex-direction: column; }
        label {
            display: block;
            margin: 10px 0 5px;
            font-weight: bold;
            color: #444;
        }
        input[type="text"], select {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            width: 100%;
            padding: 12px;
            background: #007bff;
            border: none;
            border-radius: 6px;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            transition: 0.3s;
        }
        input[type="submit"]:hover { background: #0056b3; }

        .error { color: red; text-align: center; margin-bottom: 10px; }
        .success { color: green; text-align: center; margin-bottom: 10px; }

        /* Mobile Responsive */
        @media only screen and (max-width: 768px) {
            .container { width: 90%; padding: 15px; }
            .navbar { flex-direction: column; width: 95%; }
            .navbar a { margin: 5px 0; }
            input[type="text"], select { width: 100%; }
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <a href="./ViewAllTaskServlet">View All</a>
        <a href="./AddTaskServlet">Add Task</a>
        <a href="./EditTaskServlet">Edit Task</a>
    </div>

    <div class="container">
        <h2>Edit Task</h2>

        <%@include file="message.jsp" %>

        <%
            Tasks task = (Tasks) request.getAttribute("task");
            if (task == null) {
        %>
            <p class="error">No task found!</p>
        <%
            } else {
        %>
            <form action="./UpdateTaskServlet" method="post">
                <input type="hidden" name="task_id" value="<%= task.getTask_id() %>">

                <label>Task Name:</label>
                <input type="text" name="task_name" value="<%=task.getTask_name() %>" required>

                <label>Client Name:</label>
                <input type="text" name="client_name" value="<%=task.getClient_name() %>" required>

                <label>Status:</label>
                <select name="status" required>
                    <option value="Pending" <%= "Pending".equalsIgnoreCase(task.getStatus()) ? "selected" : "" %>>Pending</option>
                    <option value="In Progress" <%= "In Progress".equalsIgnoreCase(task.getStatus()) ? "selected" : "" %>>In Progress</option>
                    <option value="Completed" <%= "Completed".equalsIgnoreCase(task.getStatus()) ? "selected" : "" %>>Completed</option>
                </select>

                <input type="submit" value="Update Task"/>
            </form>
        <% } %>

    </div>
</body>
</html>
