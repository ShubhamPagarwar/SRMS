import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class ExternalMarks
{
   public static void main(String arg[])
   {  
    ExternalMarks lm=new ExternalMarks();
   }
   public ExternalMarks()
   {
   	
       OneView1 fra = new OneView1();
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fra.setResizable (false);
      fra.show();
   }
}
  

 class OneView1 extends JFrame 
{  
 
     private JTextField ENO,BranSem,Seat;
   private ButtonGroup group;
   private Font font = new Font("Tahoma",Font.BOLD,25);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
  public static final int	HAND_CURSOR	= 12;
  
   
    public OneView1()
   {  
      setTitle("Give Details");
      setSize(800,500);
	  setResizable(false);

      Container contentPane = getContentPane();

   


      JPanel paneleno=new JPanel();
      JPanel panelbs=new JPanel();
      JPanel panelst=new JPanel();
      JPanel panel10=new JPanel();  
    
      JLabel lb=new JLabel("Enrollnment No.     ");
      ENO = new JTextField(12);
      lb.setFont(font);
      ENO.setFont(font);
      paneleno.add(lb);
      paneleno.add(ENO);
      ENO.setToolTipText("E.g. 1112420040");
      
      JLabel lbs=new JLabel("Branch & Sem     ");
      BranSem = new JTextField(6);
      lbs.setFont(font);
      BranSem.setFont(font);
      panelbs.add(lbs);
      panelbs.add(BranSem);
      BranSem.setToolTipText("E.g. CO6E");
     
       
      JLabel lst=new JLabel("Seat No.    ");
      Seat = new JTextField(8);
      lst.setFont(font);
      Seat.setFont(font);
      panelst.add(lst);
      panelst.add(Seat);
      Seat.setToolTipText("E.g. 610064");
     


       String url = "jdbc:Oracle:thin:@localhost:1521:XE";
		Connection con;
			 
                        
                        String CreateString,CreateString1;
     			Statement stmt;
      JButton SaveButton = new JButton("Enter Details");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new ViewDtls1());
                          
      JButton ModifyButton = new JButton("Modify");
      panel10.add(ModifyButton);
      ModifyButton.setFont(font);
      ModifyButton.setCursor(Pen1);
      Color color2 = new Color(0,0,255);
      ModifyButton.setForeground(color1);
      ModifyButton.addActionListener(new Modify1());
                     
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
      CloseButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               OneView1.this.dispose();
            }
         });
       ImageIcon igm=new ImageIcon("wm.gif");
       JLabel ilm = new JLabel("", igm, JLabel.CENTER);
       getContentPane().add(ilm);

      contentPane.add(paneleno);   
      contentPane.add(panelbs);
      contentPane.add(panelst);
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(5,15));
   }


private class Modify1 extends JFrame implements ActionListener
{
  public void actionPerformed(ActionEvent event)
		{
                    try
                    {
                     String url = "jdbc:Oracle:thin:@localhost:1521:XE";
		     Connection con;
			 
                        
                        
			try 
			{
				Class.forName("oracle.jdbc.OracleDriver");
			} 
			catch(java.lang.ClassNotFoundException e) 
			{
				System.err.print("ClassNotFoundException: "); 
				System.err.println(e.getMessage());
			}
					
			try 
			{
                           
                            String CreateString,CreateString1;
			Statement stmt;
                         int en,seat;
                         String brs;	
                        en=Integer.parseInt(ENO.getText());
                        seat=Integer.parseInt(Seat.getText());		
                        brs=BranSem.getText();
			
                             String sql,sql1;
                              con = DriverManager.getConnection(url,"system","admin");
				stmt = con.createStatement();			
         
                               sql= "select count(*) from StudentEntry where enroll="+en;
                              
                                ResultSet rs = stmt.executeQuery(sql);
                               while(rs.next())
                              {
                               int n=rs.getInt("count(*)");
                                if(n!=0)
                                 {
                           
                                  if(brs.equalsIgnoreCase("co1g"))
                                   {
                                                                 
                                             sql1= "select count(*) from ExCO1G where exeno="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                           
                                                   CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				
			                   	    stmt.executeUpdate(CreateString);
                                                     CO1GModify g12=new CO1GModify();
                                                 }
                                              else
                                                JOptionPane.showMessageDialog(Modify1.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            }                           
                                   }
                                    else if(brs.equalsIgnoreCase("co2g"))
                                  {
                                       sql1= "select count(*) from ExCO2G where exeno1="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                                                 CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				
				                  stmt.executeUpdate(CreateString);
                                                       CO2GModify g22=new CO2GModify();
                                                }
                                              else
                                                JOptionPane.showMessageDialog(Modify1.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            }         
                                  }
                                     else if(brs.equalsIgnoreCase("co3g"))
                                  {
                                     sql1= "select count(*) from ExCO3G where exeno1="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                                                                        
                                                       CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";				
				                        stmt.executeUpdate(CreateString);
                                                        CO3GModify g23=new CO3GModify();
                                                 }
                                              else
                                                JOptionPane.showMessageDialog(Modify1.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            }     
                                  }
                                  else if(brs.equalsIgnoreCase("co4g"))
                                  {
                                      
                                             sql1= "select count(*) from ExCO4G where exeno1="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                              
                                                  CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				       
				                    stmt.executeUpdate(CreateString);
                                                     CO4GModify g24=new CO4GModify();
                                                  }
                                              else
                                                JOptionPane.showMessageDialog(Modify1.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            }                                     
                                  }
                                  else if(brs.equalsIgnoreCase("co5e"))
                                  {
                                           sql1= "select count(*) from ExCO5E where exno1="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                                   
                                                    CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";		
				                       stmt.executeUpdate(CreateString);
                                                        CO5EModify g25=new CO5EModify();
                                                }
                                              else
                                                JOptionPane.showMessageDialog(Modify1.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            } 
                                  }

  
                                else if(brs.equalsIgnoreCase("co6e"))
                                   {
                                           sql1= "select count(*) from ExCO6E where exno1="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                                                 CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				                      stmt.executeUpdate(CreateString);
                                                       CO6EModify g26=new CO6EModify();
                                                      }
                                              else
                                                JOptionPane.showMessageDialog(Modify1.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            } 
                           

                                  }



                                      else{
                                          JOptionPane.showMessageDialog(Modify1.this,"         Branch and Sem Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                                           } 


                             }
                               else
                              {
                                   JOptionPane.showMessageDialog(Modify1.this,"         Sorry Record Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                              }
                             }
                           
                          }
                          catch(Exception e){}
                             
                          }catch(Exception e){
                                                  JOptionPane.showMessageDialog(Modify1.this,"         Please give the Enrollnment no. !"," Empty*!!",JOptionPane.WARNING_MESSAGE);                                                                           
                                                 }    

	                   					
		
         }

}           
//View Marks DETAILS OF STUDENTS
private class ViewDtls1 extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
                    try
                    {
                     String url = "jdbc:Oracle:thin:@localhost:1521:XE";
		     Connection con;
			 
                        
                        
			try 
			{
				Class.forName("oracle.jdbc.OracleDriver");
			} 
			catch(java.lang.ClassNotFoundException e) 
			{
				System.err.print("ClassNotFoundException: "); 
				System.err.println(e.getMessage());
			}
					
			try 
			{
                           
                            String CreateString,CreateString1;
			Statement stmt;
                         int en,seat;
                         String brs;	
                        en=Integer.parseInt(ENO.getText());
                        seat=Integer.parseInt(Seat.getText());		
                        brs=BranSem.getText();
			
                             String sql;
                              con = DriverManager.getConnection(url,"system","admin");
				stmt = con.createStatement();			
         
                              sql= "select count(*) from StudentEntry where enroll="+en;
                              
                                ResultSet rs = stmt.executeQuery(sql);
                               while(rs.next())
                              {
                               int n=rs.getInt("count(*)");
                                if(n!=0)
                                 {
                           
                                  if(brs.equalsIgnoreCase("co1g"))
                                   {  
                                    CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				
				    stmt.executeUpdate(CreateString);
                                     CO1G g1=new CO1G();
                                   }
                                  else if(brs.equalsIgnoreCase("co2g"))
                                  {
                                      CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				
				    stmt.executeUpdate(CreateString);
                                     CO2G g2=new CO2G();
                                  }
                                 else if(brs.equalsIgnoreCase("co3g"))
                                  {
                                      CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				
				    stmt.executeUpdate(CreateString);
                                     CO3G g3=new CO3G();
                                    }
                                     else if(brs.equalsIgnoreCase("co4g"))
                                  {
                                      CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				
				    stmt.executeUpdate(CreateString);
                                     CO4G g4=new CO4G();
                                   }
                                         
                                    else if(brs.equalsIgnoreCase("co5e"))
                                  {
                                      CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				
				    stmt.executeUpdate(CreateString);
                                     CO5E g5=new CO5E();
                                   }
                                    else if(brs.equalsIgnoreCase("co6e"))
                                  {
                                      CreateString="insert into Temp1 values("+en+",'"+brs+"',"+seat+")";
				
				    stmt.executeUpdate(CreateString);
                                     CO6E g6=new CO6E();
                                   }
                                                                          
                                  else{
                                        JOptionPane.showMessageDialog(ViewDtls1.this,"         Branch and Sem Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                                       } 

                             }
                               else
                              {
                                   JOptionPane.showMessageDialog(ViewDtls1.this,"         Sorry Record Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                              }
                             }
                           
                          }
                          catch(Exception e){}
                             
                          }catch(Exception e){
                                                  JOptionPane.showMessageDialog(ViewDtls1.this,"         Please give the Enrollnment no. !"," Empty*!!",JOptionPane.WARNING_MESSAGE);                                                                           
                                                 }    

	                   					
		
         }

  }
		 
		  	
   }
            
