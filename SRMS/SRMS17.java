import java.awt.*;
import java.sql.*;

public class SRMS17
 {
   public static void main(String args[])
  {
    SRMS17 s17=new SRMS17();
  }
  SRMS17()
  {
    SRMS17ex en17=new SRMS17ex();
  }
 }
class SRMS17ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS17ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table InCo1g(en int primary key,bs varchar2(255),etw int,ptw int,ctw int,cmfw int,wpitw int,cft int,egp int,egt int,sw int )";
       stmt.executeQuery(s1);
          
   

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
  SRMS18 s18=new SRMS18();
}  
}