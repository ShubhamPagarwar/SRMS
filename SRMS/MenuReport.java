import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class MenuReport
{
   public static void main(String arg[])
   {  
    MenuReport mj5=new MenuReport();
   }
   public MenuReport()
   {
   	
       One fra = new One();
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fra.setResizable (false);
      fra.show();
   }
}
  

 class One extends JFrame 
{  
 
     private JTextField ENO,BranSem,Seat;
   private ButtonGroup group;
   private Font font = new Font("Tahoma",Font.BOLD,25);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
  public static final int	HAND_CURSOR	= 12;
  
   
    public One()
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
      JButton SaveButton = new JButton("Show");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new Viewre());
                          
     
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
      CloseButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               One.this.dispose();
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



//View Marks DETAILS OF STUDENTS
private class Viewre extends JFrame implements ActionListener 
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
                                    
                                    String s2="Select count(*) from ExCO1g where exeno="+en;
                                           ResultSet rs1 = stmt.executeQuery(s2);
                                        while(rs1.next())
                                     {
                                         int n1=rs1.getInt("count(*)");
                                          if(n1!=0)
                                       {
                                           String s1="Select count(*) from InCO1g where en="+en;
                                           ResultSet rs2 = stmt.executeQuery(s1);
                                        while(rs2.next())
                                        {
                                         int n2=rs2.getInt("count(*)");
                                          if(n2!=0)
                                          {              
                                           CreateString="insert into T values("+en+",'"+brs+"')";
 				           stmt.executeUpdate(CreateString);
                                           CO1GReport r1=new CO1GReport();
					  }//end of internal if
                                           else
                                           {
                                             JOptionPane.showMessageDialog(Viewre.this,"         Record of Internal Marks not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                              break;                         
                                           }//end of interna else
                                        }//end of internal while
                                      }//end of external if
                                     else
                                      {
                                      JOptionPane.showMessageDialog(Viewre.this,"          Record of External Marks Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                       break;
                                      }//end of external else 	
                                     
                                   }//end of external while
         				  
                                                 
                          
                              }//end of branch if   
                                                     
                                 else if(brs.equalsIgnoreCase("co2g"))
                                   { 
                                    
                                    String s2="Select count(*) from ExCO2g where exeno1="+en;
                                           ResultSet rs1 = stmt.executeQuery(s2);
                                        while(rs1.next())
                                     {
                                         int n1=rs1.getInt("count(*)");
                                          if(n1!=0)
                                       {
                                           String s1="Select count(*) from InCO2g where en="+en;
                                           ResultSet rs2 = stmt.executeQuery(s1);
                                        while(rs2.next())
                                        {
                                         int n2=rs2.getInt("count(*)");
                                          if(n2!=0)
                                          {              
                                           CreateString="insert into T values("+en+",'"+brs+"')";
 				           stmt.executeUpdate(CreateString);
                                           CO2GReport r2=new CO2GReport();
					  }//end of internal if
                                           else
                                           {
                                             JOptionPane.showMessageDialog(Viewre.this,"         Record of Internal Marks not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                              break;                         
                                           }//end of interna else
                                        }//end of internal while
                                      }//end of external if
                                     else
                                      {
                                      JOptionPane.showMessageDialog(Viewre.this,"          Record of External Marks Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                       break;
                                      }//end of external else 	
                                     
                                   }//end of external while
         				  
                                }  
                                        else if(brs.equalsIgnoreCase("co3g"))
                                   { 
                                    
                                    String s2="Select count(*) from ExCO3g where exeno1="+en;
                                           ResultSet rs1 = stmt.executeQuery(s2);
                                        while(rs1.next())
                                     {
                                         int n1=rs1.getInt("count(*)");
                                          if(n1!=0)
                                       {
                                           String s1="Select count(*) from InCO3g where en="+en;
                                           ResultSet rs2 = stmt.executeQuery(s1);
                                        while(rs2.next())
                                        {
                                         int n2=rs2.getInt("count(*)");
                                          if(n2!=0)
                                          {              
                                           CreateString="insert into T values("+en+",'"+brs+"')";
 				           stmt.executeUpdate(CreateString);
                                           CO3GReport r3=new CO3GReport();
					  }//end of internal if
                                           else
                                           {
                                             JOptionPane.showMessageDialog(Viewre.this,"         Record of Internal Marks not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                              break;                         
                                           }//end of interna else
                                        }//end of internal while
                                      }//end of external if
                                     else
                                      {
                                      JOptionPane.showMessageDialog(Viewre.this,"          Record of External Marks Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                       break;
                                      }//end of external else 	
                                     
                                   }//end of external while
         				  
                                } 
                                      else if(brs.equalsIgnoreCase("co4g"))
                                   { 
                                    
                                    String s2="Select count(*) from ExCO4g where exeno1="+en;
                                           ResultSet rs1 = stmt.executeQuery(s2);
                                        while(rs1.next())
                                     {
                                         int n1=rs1.getInt("count(*)");
                                          if(n1!=0)
                                       {
                                           String s1="Select count(*) from InCO4g where en="+en;
                                           ResultSet rs2 = stmt.executeQuery(s1);
                                        while(rs2.next())
                                        {
                                         int n2=rs2.getInt("count(*)");
                                          if(n2!=0)
                                          {              
                                           CreateString="insert into T values("+en+",'"+brs+"')";
 				           stmt.executeUpdate(CreateString);
                                           CO4GReport r4=new CO4GReport();
					  }//end of internal if
                                           else
                                           {
                                             JOptionPane.showMessageDialog(Viewre.this,"         Record of Internal Marks not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                              break;                         
                                           }//end of interna else
                                        }//end of internal while
                                      }//end of external if
                                     else
                                      {
                                      JOptionPane.showMessageDialog(Viewre.this,"          Record of External Marks Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                       break;
                                      }//end of external else 	
                                     
                                   }//end of external while
         				  
                                }  
                                    
  
                                 else{
                                        JOptionPane.showMessageDialog(Viewre.this,"         Branch and Sem Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                                       }
                              
                            }//end of main if
                          
                               else
                              {
                                   JOptionPane.showMessageDialog(Viewre.this,"         Sorry Record Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                  
                              }
                       }//end of main while
        

              } catch(Exception e){}
                          
                             
              }catch(Exception e){        JOptionPane.showMessageDialog(Viewre.this,"         Please give the Enrollnment no. !"," Empty*!!",JOptionPane.WARNING_MESSAGE);     }                                                                      
                                                     

	                   					
		
         }

  }
		 
		  	
   }
            
