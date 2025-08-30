<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Error</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #ffebee;
            text-align: center;
            padding-top: 80px;
        }
        .box {
            background: #fff;
            display: inline-block;
            padding: 30px 50px;
            border-radius: 10px;
            box-shadow: 0px 0px 10px #aaa;
        }
        h2 {
            color: #c62828;
        }
        a {
            text-decoration: none;
            background: #c62828;
            color: #fff;
            padding: 10px 20px;
            border-radius: 6px;
            display: inline-block;
            margin-top: 20px;
        }
        a:hover {
            background: #b71c1c;
        }
    </style>
</head>
<body>
    <div class="box">
        <h2>❌ Failed to Add Task</h2>
        <a href="./addTask.jsp">Try Again</a>
    </div>
</body>
</html>
