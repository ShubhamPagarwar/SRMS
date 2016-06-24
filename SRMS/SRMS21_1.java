import java.awt.*;
import java.sql.*;

public class SRMS21
 {
   public static void main(String args[])
  {
    SRMS21 s21=new SRMS21();
  }
  SRMS21()
  {
    SRMS21ex en21=new SRMS21ex();
  }
 }
class SRMS21ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS21ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table InCo5e(en int primary key,bs varchar2(255),jpr int,jtw int,ost int,amt int,nmio int,nmit int,pps int,sw int )";
       stmt.executeQuery(s1);
          
   

    

         }catch(Exception se){System.out.println(se);}
  SRMS22 s22=new SRMS22();
}  
}