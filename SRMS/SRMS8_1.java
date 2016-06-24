import java.awt.*;
import java.sql.*;

public class SRMS8
 {
   public static void main(String args[])
  {
    SRMS8 s8=new SRMS8();
  }
  SRMS8()
  {
    SRMS8ex en8=new SRMS8ex();
  }
 }
class SRMS8ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS8ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table ExCO5E(Exno1 int ,BRS varchar2(255),seatno int primary key,Exops int,Exswe int,Excst int,Exjpr int,Examp int)";
       stmt.executeQuery(s1);
          
   

    

     stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
  SRMS9 s9=new SRMS9();
 }  
}