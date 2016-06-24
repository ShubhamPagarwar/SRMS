import java.awt.*;
import java.sql.*;

public class SRMS20
 {
   public static void main(String args[])
  {
    SRMS20 s20=new SRMS20();
  }
  SRMS20()
  {
    SRMS20ex en20=new SRMS20ex();
  }
 }
class SRMS20ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS20ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table InCo3g(en int primary key,bs varchar2(255),dstt int,dstp int,elet int,rdbo int,rdbt int,dtet int,vbp int,pps int,sw int )";
       stmt.executeQuery(s1);
          
   

    

         }catch(Exception se){System.out.println(se);}
  SRMS21 s21=new SRMS21();
}  
}