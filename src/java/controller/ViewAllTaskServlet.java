package controller;

import bean.Tasks;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.TasksI;
import model.TasksImpl;

public class ViewAllTaskServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewAllTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        // NULL SAFE search & sort parameters
        String search = request.getParameter("search");
        String sort = request.getParameter("sort");
        String pageParam = request.getParameter("page");

        if (search == null) search = "";
        else search = search.trim();

        if (sort == null) sort = "";
        else sort = sort.trim();

        int currentPage = 1;
        int recordsPerPage = 10; // tasks per page

        if (pageParam != null) {
            try {
                currentPage = Integer.parseInt(pageParam);
            } catch (Exception e) {
                currentPage = 1;
            }
        }

        TasksI obj = new TasksImpl();

        // ✅ Total tasks for pagination
        int totalTasks = obj.getTaskCount(search);
        int totalPages = (int) Math.ceil(totalTasks * 1.0 / recordsPerPage);

        // ✅ Get tasks for current page with search and sort
        List<Tasks> task = obj.getTasksByPage(search, sort, currentPage, recordsPerPage);

        // ✅ Stats
        int total = totalTasks; // all filtered tasks
        long pending = task.stream().filter(t -> "pending".equalsIgnoreCase(t.getStatus())).count();
        long completed = task.stream().filter(t -> "completed".equalsIgnoreCase(t.getStatus())).count();

        // Send data to JSP
        request.setAttribute("task", task);
        request.setAttribute("search", search);
        request.setAttribute("sort", sort);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("total", total);
        request.setAttribute("pending", pending);
        request.setAttribute("completed", completed);

        RequestDispatcher rd = request.getRequestDispatcher("./ViewAllTask.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "View All Tasks Servlet with Pagination";
    }
}
