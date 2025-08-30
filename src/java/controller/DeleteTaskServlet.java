
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.TasksI;
import model.TasksImpl;

public class DeleteTaskServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
       int taskid=Integer.parseInt(request.getParameter("taskId"));
        TasksI obj=new TasksImpl();
        int row=obj.deleteTasks(taskid);
        boolean deleted=(row>0);
        
        HttpSession session=request.getSession();
        if(deleted)
        {
         session.setAttribute("msg", "Task ID " + taskid + " deleted successfully!");
        }
        else
        {
           session.setAttribute("error", "Failed to delete Task ID " + taskid + ". Try again!");
        }
        
        response.sendRedirect("./ViewAllTaskServlet");
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DeleteTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
