import java.awt.*;
import java.sql.*;

public class SRMS7
 {
   public static void main(String args[])
  {
    SRMS7 s7=new SRMS7();
  }
  SRMS7()
  {
    SRMS7ex en7=new SRMS7ex();
  }
 }
class SRMS7ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS7ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table ExCO4G(Exeno1 int ,BRS varchar2(255),seatno int primary key ,Exmpo int,Exoop int,Excne int,Excam int,Exens int)";
       stmt.executeQuery(s1);
          
   

    

     stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
 SRMS8 s8=new SRMS8(); 
}  
}