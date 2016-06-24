import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class InternalMarks
{
   public static void main(String arg[])
   {  
    InternalMarks im=new InternalMarks();
   }
   public InternalMarks()
   {
   	
       OneView12 fra = new OneView12();
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fra.setResizable (false);
      fra.show();
   }
}
  

 class OneView12 extends JFrame 
{  
 
     private JTextField ENO,BranSem,Seat;
   private ButtonGroup group;
   private Font font = new Font("Tahoma",Font.BOLD,25);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
  public static final int	HAND_CURSOR	= 12;
  
   
    public OneView12()
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
      SaveButton.addActionListener(new ViewDtls12());
                          
      JButton ModifyButton = new JButton("Modify");
      panel10.add(ModifyButton);
      ModifyButton.setFont(font);
      ModifyButton.setCursor(Pen1);
      Color color2 = new Color(0,0,255);
      ModifyButton.setForeground(color1);
      ModifyButton.addActionListener(new Modifyd122());
                     
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
      CloseButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               OneView12.this.dispose();
            }
         });
       ImageIcon igm=new ImageIcon("wm.gif");
       JLabel ilm = new JLabel("", igm, JLabel.CENTER);
       
       getContentPane().add(ilm);
      contentPane.add(paneleno);   
      contentPane.add(panelbs);
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(5,15));
   }


private class Modifyd122 extends JFrame implements ActionListener
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
                                                                 
                                             sql1= "select count(*) from InCO1G where en="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                           
                                                   CreateString="insert into T values("+en+",'"+brs+"')";
				
			                   	    stmt.executeUpdate(CreateString);
                                                     InCO1GModify i11=new InCO1GModify();
                                                 }
                                              else
                                                JOptionPane.showMessageDialog(Modifyd122.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            }                           
                                   }
                                    else if(brs.equalsIgnoreCase("co2g"))
                                  {
                                       sql1= "select count(*) from InCO2G where en="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                                                 CreateString="insert into T values("+en+",'"+brs+"')";
				
				                  stmt.executeUpdate(CreateString);
                                                       InCO2GModify i22=new InCO2GModify();
                                                }
                                              else
                                                JOptionPane.showMessageDialog(Modifyd122.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            }         
                                  }
                                    else if(brs.equalsIgnoreCase("co3g"))
                                  {
                                     sql1= "select count(*) from InCO3G where en="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                                                                        
                                                     CreateString="insert into T values("+en+",'"+brs+"')";				
				                        stmt.executeUpdate(CreateString);
                                                        InCO3GModify g33=new InCO3GModify();
                                                 }
                                              else
                                                JOptionPane.showMessageDialog(Modifyd122.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            }     
                                  }
                                  else if(brs.equalsIgnoreCase("co4g"))
                                  {
                                      
                                             sql1= "select count(*) from InCO4G where en="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                              
                                                  CreateString="insert into T values("+en+",'"+brs+"')";
				       
				                    stmt.executeUpdate(CreateString);
                                                     InCO4GModify g44=new InCO4GModify();
                                                  }
                                              else
                                                JOptionPane.showMessageDialog(Modifyd122.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            }                                     
                                  }
                                  else if(brs.equalsIgnoreCase("co5e"))
                                  {
                                           sql1= "select count(*) from InCO5E where en="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                                   
                                                    CreateString="insert into T values("+en+",'"+brs+"')";	
				                       stmt.executeUpdate(CreateString);
                                                        InCO5EModify g55=new InCO5EModify();
                                                }
                                              else
                                                JOptionPane.showMessageDialog(Modifyd122.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            } 
                                  }

  
                                else if(brs.equalsIgnoreCase("co6e"))
                                   {
                                           sql1= "select count(*) from InCO6E where en="+en;
                              
                                             ResultSet rs1 = stmt.executeQuery(sql1);
                                             while(rs1.next())
                                            {
                                              int n1=rs1.getInt("count(*)");
                                                if(n1!=0)
                                                {
                                                CreateString="insert into T values("+en+",'"+brs+"')";
				                      stmt.executeUpdate(CreateString);
                                                       InCO6EModify g66=new InCO6EModify();
                                                      }
                                              else
                                                JOptionPane.showMessageDialog(Modifyd122.this,"    First Enter The Deatils Than Modify it !"," First Entry*!!",JOptionPane.WARNING_MESSAGE);                            
                                            } 
                           

                                    }



                                      else{
                                          JOptionPane.showMessageDialog(Modifyd122.this,"         Branch and Sem Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                                           } 

                                           
                             }
                               else
                              {
                                   JOptionPane.showMessageDialog(Modifyd122.this,"         Sorry Record Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                              }
                             }
                           
                          }
                          catch(Exception e){}
                             
                          }catch(Exception e){
                                                  JOptionPane.showMessageDialog(Modifyd122.this,"         Please give the Enrollnment no. !"," Empty*!!",JOptionPane.WARNING_MESSAGE);                                                                           
                                                 }    

	                   					
		
         }

}           
//View Marks DETAILS OF STUDENTS
private class ViewDtls12 extends JFrame implements ActionListener 
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
                                    CreateString="insert into T values("+en+",'"+brs+"')";
				
				    stmt.executeUpdate(CreateString);
                                     InCO1G i1=new InCO1G();
                                   }
                                  else if(brs.equalsIgnoreCase("co2g"))
                                  {
                                     CreateString="insert into T values("+en+",'"+brs+"')";
				
				    stmt.executeUpdate(CreateString);
                                     InCO2G i2=new InCO2G();
                                  }
                                 else if(brs.equalsIgnoreCase("co3g"))
                                  {
                                  CreateString="insert into T values("+en+",'"+brs+"')";
				
				    stmt.executeUpdate(CreateString);
                                     InCO3G i3=new InCO3G();
                                    }
                                     else if(brs.equalsIgnoreCase("co4g"))
                                  {
                                     CreateString="insert into T values("+en+",'"+brs+"')";
				
				    stmt.executeUpdate(CreateString);
                                    InCO4G i4=new InCO4G();
                                   }
                                         
                                    else if(brs.equalsIgnoreCase("co5e"))
                                  {
                                      CreateString="insert into T values("+en+",'"+brs+"')";
				
				    stmt.executeUpdate(CreateString);
                                     InCO5E i5=new InCO5E();
                                   }
                                    else if(brs.equalsIgnoreCase("co6e"))
                                  {
                                     CreateString="insert into T values("+en+",'"+brs+"')";
				
				    stmt.executeUpdate(CreateString);
                                     InCO6E i6=new InCO6E();
                                   }
                                                                          
                                  else{
                                        JOptionPane.showMessageDialog(ViewDtls12.this,"         Branch and Sem Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                                       } 

                             }
                               else
                              {
                                   JOptionPane.showMessageDialog(ViewDtls12.this,"         Sorry Record Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                              }
                             }
                           
                          }
                          catch(Exception e){}
                             
                          }catch(Exception e){
                                                  JOptionPane.showMessageDialog(ViewDtls12.this,"         Please give the Enrollnment no. !"," Empty*!!",JOptionPane.WARNING_MESSAGE);                                                                           
                                                 }    

	                   					
		
         }

  }
		 
		  	
   }
            
