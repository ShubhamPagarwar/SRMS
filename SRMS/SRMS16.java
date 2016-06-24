import java.awt.*;
import java.sql.*;

public class SRMS16
 {
   public static void main(String args[])
  {
    SRMS16 s16=new SRMS16();
  }
  SRMS16()
  {
    SRMS16ex en16=new SRMS16ex();
  }
 }
class SRMS16ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS16ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table t(ent int ,bs varchar2(255))";
       stmt.executeQuery(s1);
          
   

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
  SRMS17 s17=new SRMS17();
}  
}