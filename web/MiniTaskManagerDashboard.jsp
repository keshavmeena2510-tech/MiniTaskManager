<%-- 
    Document   : MiniTaskManagerDashboard
    Created on : 21 Aug, 2025, 9:34:02 AM
    Author     : Lenovo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
    body{
        font-family: Arial,sans-serif;
        background-color: #f0f0f0;
        margin: 0;
        padding: 0;
        background-image: url('images/task5.jpg');
        background-repeat: no-repeat;
        background-size: cover;
    }

    /* Navbar */
    .navbar{
        background-color: #333;
        overflow: hidden;
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
    }
    .navbar a{
        color: white;
        text-align: center;
        padding: 14px 20px;
        text-decoration: none;
    }
    .navbar a:hover{
        background-color: #ddd;
        color: black;
    }

    /* Content */
    .content{
        text-align: center;
        padding: 80px 20px;
    }
    .content h1{
        font-size: 36px;
    }
    .content p{
        font-size: 18px;
    }

    /* Button */
    .btn{
        text-align: center;
        margin-top: 20px;
    }
    .btn button{
        border: none;
        border-radius: 5px;
        padding: 12px 20px;
        background: white;
        cursor: pointer;
        transition: 0.3s;
    }
    .btn a{
        text-decoration: none;
        font-size: 20px;
        color: black;
    }
    .btn a:hover{
        background-color: green;
        border-radius: 8px;
        color: white;
        padding: 10px 15px;
    }

    /* 📱 Responsive Design */
    @media (max-width: 768px) {
        .content {
            padding: 40px 10px;
        }
        .content h1{
            font-size: 24px;
        }
        .content p{
            font-size: 16px;
        }
        .navbar{
            flex-direction: column;
        }
        .navbar a{
            padding: 12px;
            border-bottom: 1px solid #444;
        }
        .btn a{
            font-size: 18px;
        }
    }
</style>

    </head>
    <body>
        <div class="navbar">
            <a href="./ViewAllTaskServlet">View All Tasks</a>
            <a href="./addTask.jsp">Add Tasks</a>
           
        </div>
        <div class="content">
            <h1>Welcome to Mini Task Manager</h1>
            <p>Use the navigation bar above to manage tasks.</p>
        </div> 
        <div class="btn">
            <button><a href="./addTask.jsp">Get Started</a></button>
        </div>
    </body>
</html>
