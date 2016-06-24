import java.awt.*;
import java.sql.*;

public class SRMS18
 {
   public static void main(String args[])
  {
    SRMS18 s18=new SRMS18();
  }
  SRMS18()
  {
    SRMS18ex en18=new SRMS18ex();
  }
 }
class SRMS18ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS18ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table InCo2g(en int primary key,bs varchar2(255),cmo int,cmt int,apr int,progc int,progctw int,elect int,dlso int,wpd int,sw int )";
       stmt.executeQuery(s1);
          
   

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
 StartProject sp = new StartProject();
}  
}