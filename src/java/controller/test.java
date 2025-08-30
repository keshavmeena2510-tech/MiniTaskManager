
package controller;

import bean.Tasks;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import model.TasksI;
import model.TasksImpl;
import org.kohsuke.rngom.digested.Main;

public class test {
    public static void main(String[] args) throws SQLException {
        Scanner scan=new Scanner(System.in);
       /* Tasks ts=new Tasks();
        System.out.println("enter task_name");
        ts.setTask_name(scan.nextLine().trim());
        System.out.println("enter client name");
        ts.setClient_name(scan.nextLine().trim());
        System.out.println("enter status");
        ts.setStatus(scan.nextLine().trim());
        System.out.println("enter deadline");
        ts.setDeadline(Date.valueOf(scan.nextLine().trim()));
        
        TasksI obj=new TasksImpl();
        ts.setTask_id(obj.generateKey());
        
        int result=obj.addTask(ts);
        if(result>0)
        {
            System.out.println("task inserted");
        }
        else
        {
            System.out.println("not inserted");
        }*/
       
       /*TasksI obj=new TasksImpl();
        ArrayList<Tasks> al=obj.getAllTasks();
        if(al!=null)
        {
            Iterator<Tasks> itr=al.iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        
        }
        else
        {
            System.out.println("no data available");
        }
        */
       
       /* System.out.println("enter task_id for search");
        int id=Integer.parseInt(scan.nextLine());
        TasksI obj=new TasksImpl();
        Tasks bean=obj.getTaskById(id);
        if(bean!=null)
        {
            System.out.println(bean);
        }
        else
        {
            System.out.println("no record found");
        }*/
       
        System.out.println("enter task id for delete");
        int id=Integer.parseInt(scan.nextLine());
        TasksI obj=new TasksImpl();
        int result=obj.deleteTasks(id);
        if(result>0)
        {
            System.out.println("got deleted");
        }
        else
        {
            System.out.println("not deleted");
        }
       
       /*Tasks ts=new Tasks();
       TasksI obj=new TasksImpl();
        System.out.println("enter task id where you want to update");
        int id=Integer.parseInt(scan.nextLine().trim());
        ts=obj.getTaskById(id);
         System.out.println(" task_name:"+ts.getTask_name()); 
         System.out.println("client_name:"+ts.getClient_name());
         System.out.println("status:"+ts.getStatus());
         System.out.println("deadline:"+ts.getDeadline());
         
         System.out.println("------------------------");
        ts.setTask_id(id);
         System.out.println("enter updated task_name");
         ts.setTask_name(scan.nextLine().trim());
        
         int result=obj.updateTasks(ts);
         if(result>0)
         {
             System.out.println("got updated");
             ts=obj.getTaskById(id);
             System.out.println(ts);
         }*/
    }
}
