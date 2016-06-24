import java.awt.*;
import java.sql.*;

public class SRMS6
 {
   public static void main(String args[])
  {
    SRMS6 s6=new SRMS6();
  }
  SRMS6()
  {
    SRMS6ex en6=new SRMS6ex();
  }
 }
class SRMS6ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS6ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table ExCO3G(Exeno1 int ,BRS varchar2(255),seatno int primary key,Exdst int,Exdte int,Exrdbms int,Exapmath int,Exelectrical int)";
       stmt.executeQuery(s1);
          
   

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
  SRMS7 s7=new SRMS7();
 }  
}