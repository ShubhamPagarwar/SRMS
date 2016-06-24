import java.awt.*;
import java.sql.*;

public class SRMS13
 {
   public static void main(String args[])
  {
    SRMS13 s13=new SRMS13();
  }
  SRMS13()
  {
    SRMS13ex en13=new SRMS13ex();
  }
 }
class SRMS13ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS13ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table tco4g(e int primary key)";
       stmt.executeQuery(s1);
          
   

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
  SRMS14 s14=new SRMS14(); 
}  
}