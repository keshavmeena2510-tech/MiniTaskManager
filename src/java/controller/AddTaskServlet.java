
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

public class AddTaskServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
     
           String Task_name=request.getParameter("task_name");
           String Client_name=request.getParameter("client_name");
           String Status=request.getParameter("status");
           String deadlineStr = request.getParameter("deadline");
           
           // Null-safe trimming
            if (Task_name != null) Task_name = Task_name.trim();
            if (Client_name != null) Client_name = Client_name.trim();
            if (Status != null) Status = Status.trim();
          
           
           Tasks task=new Tasks();
           task.setTask_name(Task_name);
           task.setClient_name(Client_name);
           task.setStatus(Status);
           
           if(deadlineStr != null && !deadlineStr.isEmpty()) {
             task.setDeadline(Date.valueOf(deadlineStr)); // yyyy-MM-dd format hona chahiye
            } else {
                task.setDeadline(null);
            }

           
           
           TasksI obj=new TasksImpl();
           task.setTask_id(obj.generateKey());
           
           int result=obj.addTask(task);
           
           HttpSession session=request.getSession();
           
           if(result>0)
           {
                session.setAttribute("msg", "Task added successfully!");
           }
           else
           {
                 session.setAttribute("error", "Failed to add task. Try again!");
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
            Logger.getLogger(AddTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AddTaskServlet.class.getName()).log(Level.SEVERE, null, ex);
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
