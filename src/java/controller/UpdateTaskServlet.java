
package controller;

import bean.Tasks;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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

public class UpdateTaskServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        
        int task_id=Integer.parseInt(request.getParameter("task_id"));
        String task_name=request.getParameter("task_name");
        String client_name=request.getParameter("client_name");
        String status=request.getParameter("status");
       
        
        Tasks t=new Tasks();
        t.setTask_id(task_id);
        t.setTask_name(task_name);
        t.setClient_name(client_name);
        t.setStatus(status);
       
        
        TasksI obj=new TasksImpl();
        int row=obj.updateTasks(t);
        boolean updated=(row>0);
        
        HttpSession session=request.getSession();
        
        if(updated)
        {
            session.setAttribute("msg", "Task updated successfully!");
        }
        else
        {
             session.setAttribute("error", "Failed to update task. Try again!");
        }
        
        response.sendRedirect("./ViewAllTaskServlet");
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
