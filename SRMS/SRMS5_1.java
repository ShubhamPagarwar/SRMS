import java.awt.*;
import java.sql.*;

public class SRMS5
 {
   public static void main(String args[])
  {
    SRMS5 s5=new SRMS5();
  }
  SRMS5()
  {
    SRMS5ex en5=new SRMS5ex();
  }
 }
class SRMS5ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS5ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table ExCO2G(Exeno1 int ,BRS1 varchar2(255),seatno1 int primary key,Excomm int,Exapsci int,Exproginc int,Exelectronics int,Exengmat int)";
       stmt.executeQuery(s1);
          
   

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
  SRMS6 s6=new SRMS6(); 
}  
}