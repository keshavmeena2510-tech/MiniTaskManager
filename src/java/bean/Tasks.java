
package bean;

import java.sql.Date;

public class Tasks {
    private int task_id;
    private String task_name,client_name,status;
    private Date deadline;
    
    public Tasks()
    {
        
    }

    public Tasks(int task_id, String task_name, String client_name, String status, Date deadline) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.client_name = client_name;
        this.status = status;
        this.deadline = deadline;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Tasks{" + "task_id=" + task_id + ", task_name=" + task_name + ", client_name=" + client_name + ", status=" + status + ", deadline=" + deadline + '}';
    }
    
}
