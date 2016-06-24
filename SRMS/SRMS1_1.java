import java.awt.*;
import java.sql.*;

public class SRMS1
 {
   
   public static void main(String[] args) 
{
   SRMS1ex en1=new SRMS1ex();
}
}
class SRMS1ex
{
  static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   Connection conn = null;
   public SRMS1ex()
{
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table StudentEntry(enroll int primary key, full varchar2(255),mot varchar2(255), dob varchar2(255),nat varchar2(255),pho varchar2(255), mob varchar2(255), email varchar2(255),gen varchar2(255),address varchar2(255))";
       stmt.executeQuery(s1);
          
      
   
    

      stmt.close();
      conn.close();
         
         }catch(Exception se){				System.err.println(se.getMessage());}
   
   SRMS2 s2= new SRMS2(); 
}  
}