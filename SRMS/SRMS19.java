import java.awt.*;
import java.sql.*;

public class SRMS19
 {
   public static void main(String args[])
  {
    SRMS19 s19=new SRMS19();
  }
  SRMS19()
  {
    SRMS19ex en19=new SRMS19ex();
  }
 }
class SRMS19ex
{ 
   static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";  
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
   static final String USER = "system";
   static final String PASS = "admin";
   
   public  SRMS19ex()
 
{
   Connection conn = null;
   Statement stmt = null;
   try{
      
      Class.forName("oracle.jdbc.OracleDriver");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      stmt = conn.createStatement();
      String s1,s2,s3,s4,s5,s6,s7,s8,s9;
   s1 = "Create table InCo4g(en int primary key,bs varchar2(255),enst int,camp int,camt int,cnep int,cnet int,mpop int,mpot int,oopp int,oopt int,cgrp int,cgrt int,pps int,sw int )";
       stmt.executeQuery(s1);
          
   

    

stmt.close();
      conn.close();
         }catch(Exception se){				System.err.println(se.getMessage());}
  SRMS20 s20=new SRMS20();
}  
}