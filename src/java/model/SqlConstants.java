
package model;

public class SqlConstants {
    public static final String addTask="insert into tasks(task_name,client_name,status,deadline)values(?,?,?,?)";
    public static final String deleteTask="delete from tasks where task_id=?";
    public static final String updateTask="update tasks set task_name=?,client_name=?,status=?,deadline=? where task_id=?";
    public static final String primaryKeyTask="select(task_id+1) as newid from tasks where rownum=1 order by task_id";
    public static final String getTaskById="select task_id,task_name,client_name,status,deadline from tasks where task_id=?";
    public static final String getAllTask="select task_id,task_name,client_name,status,deadline from tasks order by task_id asc";
    public static final String getAllTaskWithSortSearch =
    "select task_id,task_name,client_name,status,deadline from tasks " +
    "where task_name like ? or client_name like ? or status like ? order by ";
   public static final String GET_TASK_COUNT =
    "SELECT COUNT(*) AS total FROM tasks " +
    "WHERE task_name LIKE ? OR client_name LIKE ? OR status LIKE ?";
   public static final String GET_TASKS_BASE =
    "SELECT task_id, task_name, client_name, status, deadline " +
    "FROM tasks " +
    "WHERE task_name LIKE ? OR client_name LIKE ? OR status LIKE ? " +
    "ORDER BY "; // sort column will be appended dynamically
}
