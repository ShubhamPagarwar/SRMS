import java.awt.*;
import java.sql.*;

public class SRMS3
 {
   public static void main(String args[])
  {
    SRMS3 s3=new SRMS3();
  }
  SRMS3()
  {
    SRMS3ex en3=new SRMS3ex();
  }
 }
class SRMS3ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS3ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table ExCO1G(Exeno int,BRS varchar2(255),seatno int primary key,ExEnglish int,ExPhysics int,ExChemistry int,ExMath int)";
       stmt.executeQuery(s1);
          
   

    

    stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
   SRMS4 s4=new SRMS4(); 
}  
}