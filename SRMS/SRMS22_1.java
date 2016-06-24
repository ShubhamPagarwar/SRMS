import java.awt.*;
import java.sql.*;

public class SRMS22
 {
   public static void main(String args[])
  {
    SRMS22 s22=new SRMS22();
  }
  SRMS22()
  {
    SRMS22ex en22=new SRMS22ex();
  }
 }
class SRMS22ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS22ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table InCo6e(en int primary key,bs varchar2(255),sweo int,ajpp int,ajpt int,edpt int,spgo int,spgt int,pps int,sw int )";
       stmt.executeQuery(s1);
          
   

    

         }catch(Exception se){System.out.println(se);}
   PasswordForm pw = new PasswordForm();
}  
}