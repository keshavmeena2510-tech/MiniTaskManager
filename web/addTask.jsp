<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Add Task</title>
    <style>
        body{
            font-family: Arial,sans-serif;
            background: #f4f6f9;
            margin: 0;
            padding: 0;
            background-image:url('images/task1.jpg');
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
        .container{
            width: 400px;
            margin: 20px auto;
            background: #fff;
            padding: 25px;
            border-radius: 8px;
            box-shadow: 0px 2px 10px rgba(0,0,0,0.1);
            opacity: 0.9;
        }

        h2 { text-align: center; color: #333; }

        label{
            display: block;
            margin: 10px 0 5px;
            font-weight: bolder;
        }
        input[type="text"], input[type="date"], select{
            width:100%;
            padding: 8px;
            margin-bottom: 15px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        .btn-submit{
            width: 100%;
            padding: 10px;
            border: none;
            background: #28a745;
            color: white;
            font-size: 16px;
            border-radius: 6px;
            cursor: pointer;
        }
        .btn-submit:hover { background: #218838; }

        .success { color: green; text-align:center; margin: 10px 0; }
        .error { color: red; text-align:center; margin: 10px 0; }

        /* Mobile Responsive */
        @media only screen and (max-width: 768px) {
            .container { width: 90%; padding: 15px; }
            .navbar { flex-direction: column; width: 95%; }
            .navbar a { margin: 5px 0; }
            input[type="text"], select { width: 100%; }
        }
    </style>
    <script>
        function validateTaskForm() {
            var taskName = document.getElementById("task_name").value.trim();
            var clientName = document.getElementById("client_name").value.trim();
            var status = document.getElementById("status").value;

            if(taskName === "" || clientName === "" || status === "") {
                alert("Please fill all the required fields!");
                return false; // form submit nahi hoga
            }
            return true;
        }
    </script>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <a href="./ViewAllTaskServlet">View All</a>
        <a href="./AddTaskServlet">Add Task</a>
        <a href="./EditTaskServlet">Edit Task</a>
    </div>

    <div class="container">
        <h2>Add Task</h2>

        <!-- Flash Message -->
        <%@include file="message.jsp" %>  

        <form action="./AddTaskServlet" method="post" onsubmit="return validateTaskForm()">
            <label for="task_name">Task Name:</label>
            <input type="text" name="task_name" id="task_name" required>

            <label for="client_name">Client Name:</label>
            <input type="text" name="client_name" id="client_name" required>

            <label for="status">Status:</label>
            <select name="status" id="status" required>
                <option value="">--Select Status--</option>
                <option value="Pending">Pending</option>
                <option value="In Progress">In Progress</option>
                <option value="Completed">Completed</option>
            </select>
            
            
            <label for="deadline">Deadline:</label>
            <input type="date" name="deadline" id="deadline"><br><br>
            <input type="submit" class="btn-submit" value="Add Task">
        </form>
    </div>
</body>
</html>
