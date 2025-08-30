
package model;

import bean.Tasks;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import static java.time.Clock.offset;
import java.util.ArrayList;
import java.util.List;

public class TasksImpl implements TasksI{
    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private int result;
    private Tasks t;
    private ArrayList<Tasks> al;

    @Override
    public int addTask(Tasks bean) throws SQLException {
        
        
        
        con=MyConnection.getCon();
        pstmt=con.prepareStatement(SqlConstants.addTask);
        pstmt.setString(1,bean.getTask_name());
        pstmt.setString(2, bean.getClient_name());
        pstmt.setString(3, bean.getStatus());
        pstmt.setDate(4, bean.getDeadline());
        result=pstmt.executeUpdate();
        con.close();
        return result;
     }

    @Override
    public int updateTasks(Tasks bean) throws SQLException {
        con=MyConnection.getCon();
        pstmt=con.prepareStatement(SqlConstants.updateTask);
        pstmt.setString(1,bean.getTask_name());
        pstmt.setString(2, bean.getClient_name());
        pstmt.setString(3, bean.getStatus());
        pstmt.setDate(4, bean.getDeadline());
        pstmt.setInt(5, bean.getTask_id());
        result=pstmt.executeUpdate();
        con.close();
        return result;
     }

    @Override
    public int generateKey() throws SQLException {
        int key=0;
        con=MyConnection.getCon();
        pstmt=con.prepareStatement(SqlConstants.primaryKeyTask);
        rs=pstmt.executeQuery();
        while(rs.next())
        {
            key=rs.getInt("newid");
        }
        con.close();
        return key;
     }

    @Override
    public int deleteTasks(int task_id) throws SQLException {
        con=MyConnection.getCon();
        pstmt=con.prepareStatement(SqlConstants.deleteTask);
        pstmt.setInt(1, task_id);
        result=pstmt.executeUpdate();
        con.close();
        return result;
    }

    @Override
    public Tasks getTaskById(int task_id) throws SQLException {
        con=MyConnection.getCon();
        pstmt=con.prepareStatement(SqlConstants.getTaskById);
        pstmt.setInt(1, task_id);
        rs=pstmt.executeQuery();
        Tasks t=null;
        if(rs.next())
        {
            t=new Tasks();
            t.setTask_id(rs.getInt("task_id"));
            t.setTask_name(rs.getString("task_name"));
            t.setClient_name(rs.getString("client_name"));
            t.setStatus(rs.getString("status"));
            t.setDeadline(rs.getDate("deadline"));
        }
        return t;
     }

    @Override
    public ArrayList<Tasks> getAllTasks() throws SQLException {
         con=MyConnection.getCon();
        pstmt=con.prepareStatement(SqlConstants.getAllTask);
        rs=pstmt.executeQuery();
        al=new ArrayList<>();
        while(rs.next())
        {
            
            t=new Tasks();
            t.setTask_id(rs.getInt("task_id"));
            t.setTask_name(rs.getString("task_name"));
            t.setClient_name(rs.getString("client_name"));
            t.setStatus(rs.getString("status"));
            t.setDeadline(rs.getDate("deadline"));
            al.add(t);
        }
        return al;
    }

   @Override
public List<Tasks> getAllTasks(String search, String sort) throws SQLException {
    // Initialize list
    al = new ArrayList<>();

    // Safe null handling
    if(search == null) search = "";
    search = "%" + search.trim() + "%";

    if(sort == null || sort.isEmpty()) {
        sort = "task_id"; // default sort
    }

    // SQL query with placeholders
    String sql = "SELECT task_id, task_name, client_name, status, deadline " +
                 "FROM tasks " +
                 "WHERE task_name LIKE ? OR client_name LIKE ? OR status LIKE ? " +
                 "ORDER BY " + sort;

    con = MyConnection.getCon();
    pstmt = con.prepareStatement(sql);
    pstmt.setString(1, search);
    pstmt.setString(2, search);
    pstmt.setString(3, search);

    rs = pstmt.executeQuery();

    while(rs.next()) {
        t = new Tasks();
        t.setTask_id(rs.getInt("task_id"));
        t.setTask_name(rs.getString("task_name"));
        t.setClient_name(rs.getString("client_name"));
        t.setStatus(rs.getString("status"));
        t.setDeadline(rs.getDate("deadline"));
        al.add(t);
    }

    con.close();
    return al;
}

    @Override
    public int getTaskCount(String search) throws SQLException {
         int count = 0;
    if(search == null) search = "";
    String s = "%" + search.trim() + "%";

    con = MyConnection.getCon();
    pstmt = con.prepareStatement(SqlConstants.GET_TASK_COUNT);
    pstmt.setString(1, s);
    pstmt.setString(2, s);
    pstmt.setString(3, s);

    rs = pstmt.executeQuery();
    if(rs.next()) {
        count = rs.getInt("total");
    }
    con.close();
    return count;
    }

    @Override
    public List<Tasks> getTasksByPage(String search, String sort, int currentPage, int recordsPerPage) throws SQLException{
         List<Tasks> taskList = new ArrayList<>();
    if(search == null) search = "";
    search = "%" + search.trim() + "%";

    if(sort == null || sort.isEmpty()) sort = "task_id"; // default sort

    int offset = (currentPage - 1) * recordsPerPage;
int limit = recordsPerPage;
    // Oracle pagination query using ROWNUM
    String sql = "SELECT * FROM (" +
                 " SELECT a.*, ROWNUM rnum FROM (" +
                 SqlConstants.GET_TASKS_BASE + sort +
                 ") a WHERE ROWNUM <= ?" +
                 ") WHERE rnum > ?";

    con = MyConnection.getCon();
    pstmt = con.prepareStatement(sql);
    pstmt.setString(1, search);
    pstmt.setString(2, search);
    pstmt.setString(3, search);
    pstmt.setInt(4, offset + limit);
    pstmt.setInt(5, offset);

    rs = pstmt.executeQuery();
    while(rs.next()) {
        Tasks t = new Tasks();
        t.setTask_id(rs.getInt("task_id"));
        t.setTask_name(rs.getString("task_name"));
        t.setClient_name(rs.getString("client_name"));
        t.setStatus(rs.getString("status"));
        t.setDeadline(rs.getDate("deadline"));
        taskList.add(t);
    }

    con.close();
    return taskList;
    }

    

   
}
