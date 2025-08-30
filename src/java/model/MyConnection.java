
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {
  public static Connection getCon(){
      Connection con=null;
      String path="oracle.jdbc.driver.OracleDriver";
      try{
         Class.forName(path);
         String url="jdbc:oracle:thin:@localhost:1521:xe";
         String user="system";
         String pass="system";
         con=DriverManager.getConnection(url,user,pass);
      }
     catch(SQLException sqle)
     {
         System.out.println("some error occur in DB connection=>"+sqle);
     }
      catch(ClassNotFoundException cnfe)
      {
          System.out.println("please check driver name and library=>"+cnfe); 
      }
      return con;
  }
    public static void main(String[] args) {
        System.out.println(getCon());
    }
}
