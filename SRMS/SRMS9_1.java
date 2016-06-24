import java.awt.*;
import java.sql.*;

public class SRMS9
 {
   public static void main(String args[])
  {
    SRMS9 s9=new SRMS9();
  }
  SRMS9()
  {
    SRMS9ex en9=new SRMS9ex();
  }
 }
class SRMS9ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS9ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table ExCO6E(Exno1 int,BRS varchar2(255),seatno int  primary key ,Exman int,Exstg int,Exajp int,Exspg int,Exipr int)";
       stmt.executeQuery(s1);
          
   

    

     stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
   SRMS10 s10=new SRMS10(); 
}  
}