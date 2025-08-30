
package model;

import bean.Tasks;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface TasksI {
    public int addTask(Tasks bean) throws SQLException;
    public int updateTasks(Tasks bean) throws SQLException;
    public int generateKey() throws SQLException;
    public int deleteTasks(int task_id) throws SQLException;
    public Tasks getTaskById(int task_id) throws SQLException;
    public ArrayList<Tasks> getAllTasks() throws SQLException;
    public List<Tasks> getAllTasks(String search, String sort) throws SQLException;
    public int getTaskCount(String search) throws SQLException;
    public List<Tasks> getTasksByPage(String search, String sort, int currentPage, int recordsPerPage) throws SQLException;

   
}
