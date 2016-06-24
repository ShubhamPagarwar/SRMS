import java.awt.*;
import java.sql.*;

public class SRMS2
 {
   public static void main(String args[])
  {
    SRMS2 s2=new SRMS2();
  }
  SRMS2()
  {
    SRMS2ex en2=new SRMS2ex();
  }
 }
class SRMS2ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS2ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table Temp(eno int)";
       stmt.executeQuery(s1);
  

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
            
   SRMS3 s3=new SRMS3();
 }  

}