import java.awt.*;
import java.sql.*;

public class SRMS14
 {
   public static void main(String args[])
  {
    SRMS14 s14=new SRMS14();
  }
  SRMS14()
  {
    SRMS14ex en14=new SRMS14ex();
  }
 }
class SRMS14ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS14ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table tco5e(e int primary key)";
       stmt.executeQuery(s1);
          
   

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
  SRMS15 s15=new SRMS15(); 
}  
}