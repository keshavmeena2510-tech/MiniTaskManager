<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="bean.Tasks"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>All Tasks</title>
    <style>
        body{
            background-image: url('images/task2.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            margin: 0;
            padding: 0;
            font-family: Arial,sans-serif;
        }
        h2 { text-align: center; }

        /* Navbar */
        .navbar {
            display: flex;
            justify-content: center;
            flex-wrap: wrap;
            background-color: #333;
            margin-bottom: 15px;
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

        /* Table */
        table {
            width: 90%;
            border-collapse: collapse;
            margin: 20px auto;
            opacity: 0.95;
        }
        table, th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th{ background-color: #f2f2f2; }
        tr:hover{ background-color: #f9f9f9; }

        /* Buttons */
        a.btn {
            padding: 4px 8px;
            text-decoration: none;
            border-radius: 4px;
            margin: 2px;
            border: none;
        }
        a.delete {background-color: #f44336; color: white; }
        a.edit { background-color: #4CAF50; color: white;  }

        /* Filter/Search */
        .filter-box { width: 90%; margin: 10px auto; text-align: center; }

        /* Pagination */
        .pagination a, .pagination b {
            padding: 5px 10px;
            margin: 0 2px;
            text-decoration: none;
            border: 1px solid #ccc;
            border-radius: 3px;
            color: #333;
        }
        .pagination b { background-color: #4CAF50; color: white; }

        /* Mobile Responsive */
        @media only screen and (max-width: 768px) {
            table, th, td {
                font-size: 12px;
            }
            table {
                display: block;
                overflow-x: auto;
                width: 95%;
            }
            .filter-box, .navbar {
                width: 95%;
                flex-direction: column;
                text-align: center;
            }
            .navbar a {
                margin: 5px 0;
            }
            input[type="text"], select {
                width: 100%;
                margin-bottom: 10px;
            }
            a.btn {
                padding: 3px 6px;
                font-size: 12px;
            }
        }
    </style>
    <script>
        function confirmDelete(taskId){
            return confirm("Are you sure you want to delete Task ID " + taskId + "?");
        }
    </script>
</head>
<body>
    <h2>All Tasks</h2>

    <!-- Navbar -->
    <div class="navbar">
        <a href="./ViewAllTaskServlet">View All</a>
        <a href="./addTask.jsp">Add Task</a>
        <a href="./EditTask.jsp">Edit Task</a>
    </div>

    <!-- Stats -->
    <p style="text-align:center;">
        Total Tasks: <%= request.getAttribute("total") %>
        &nbsp;&nbsp; Pending: <%= request.getAttribute("pending") %>
        &nbsp;&nbsp; Completed: <%= request.getAttribute("completed") %>
    </p>

    <!-- Filter/Search -->
    <div class="filter-box">
        <form action="./ViewAllTaskServlet" method="get" style="display:inline-block; margin-right:20px;">
            <input type="text" name="search" placeholder="Search task..." 
                   value="<%= (request.getAttribute("search")!=null)?request.getAttribute("search"):"" %>">
            <input type="submit" value="Search">
        </form>

        <form action="./ViewAllTaskServlet" method="get" style="display:inline-block;">
            <select name="sort">
                <option value="">-- Sort By --</option>
                <option value="task_name" <%= "task_name".equals(request.getAttribute("sort"))?"selected":"" %>>Task Name</option>
                <option value="client_name" <%= "client_name".equals(request.getAttribute("sort"))?"selected":"" %>>Client Name</option>
                <option value="status" <%= "status".equals(request.getAttribute("sort"))?"selected":"" %>>Status</option>
            </select>
            <input type="submit" value="Sort">
        </form>
    </div>

    <!-- Table -->
    <table>
        <tr>
            <th>Task_Id</th>
            <th>Task_Name</th>
            <th>Client_Name</th>
            <th>Status</th>
            <th>Action</th>
        </tr>
        <%
            List<Tasks> taskList = (List<Tasks>) request.getAttribute("task");
            if(taskList != null && !taskList.isEmpty()){
                for(Tasks t : taskList){
        %>
        <tr>
            <td><%= t.getTask_id() %></td>
            <td><%= t.getTask_name() %></td>
            <td><%= t.getClient_name() %></td>
            <td><%= t.getStatus() %></td>
            <td>
                <a class="btn edit" href="./EditTaskServlet?taskId=<%= t.getTask_id() %>">Edit</a>
                <a class="btn delete" href="./DeleteTaskServlet?taskId=<%= t.getTask_id() %>" onclick="return confirmDelete(<%= t.getTask_id() %>)">Delete</a>
            </td>
        </tr>
        <%      }
            } else { %>
        <tr>
            <td colspan="5">No tasks found</td>
        </tr>
        <% } %>
    </table>

    <!-- Pagination -->
    <%
        int currentPage = (Integer) request.getAttribute("currentPage");
        int totalPages = (Integer) request.getAttribute("totalPages");
    %>
    <div class="pagination" style="text-align:center; margin:20px;">
        <% if(currentPage > 1) { %>
            <a href="./ViewAllTaskServlet?page=<%=currentPage-1%>&search=<%=request.getAttribute("search")%>&sort=<%=request.getAttribute("sort")%>">Prev</a>
        <% } %>

        <% for(int i=1; i<=totalPages; i++) { %>
            <% if(i == currentPage) { %>
                <b><%=i%></b>
            <% } else { %>
                <a href="./ViewAllTaskServlet?page=<%=i%>&search=<%=request.getAttribute("search")%>&sort=<%=request.getAttribute("sort")%>"><%=i%></a>
            <% } %>
        <% } %>

        <% if(currentPage < totalPages) { %>
            <a href="./ViewAllTaskServlet?page=<%=currentPage+1%>&search=<%=request.getAttribute("search")%>&sort=<%=request.getAttribute("sort")%>">Next</a>
        <% } %>
    </div>

</body>
</html>
