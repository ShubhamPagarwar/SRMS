import java.sql.*;

public class Conn
{
  public static void main(String args[])throws Exception
 { 
   try
{
   Class.forName("oracle.jdbc.OracleDriver");
   System.out.println("Driver are properly loadded");
   String url="jdbc:Oracle:thin:@localhost:1521:XE";
   Connection con1=DriverManager.getConnection(url,"system","admin");
   System.out.println("Connection Establish");
   con1.close();
  }
  catch(SQLException e){
    System.out.println("SQl error has Occured");
    }
  catch(Exception e){
    System.out.println("Error Connection not Establihed");
    }
 }
  
}
