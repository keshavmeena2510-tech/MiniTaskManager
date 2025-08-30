<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Success</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #e8f5e9;
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
            color: #28a745;
        }
        a {
            text-decoration: none;
            background: #28a745;
            color: #fff;
            padding: 10px 20px;
            border-radius: 6px;
            display: inline-block;
            margin-top: 20px;
        }
        a:hover {
            background: #218838;
        }
    </style>
</head>
<body>
    <div class="box">
        <h2>✅ Task Added Successfully!</h2>
        <a href="./ViewAllTaskServlet">View All Tasks</a>
    </div>
</body>
</html>
