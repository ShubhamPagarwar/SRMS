import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class RemoveOne
{
   public static void main(String arg[])
   {  
    RemoveOne ll=new RemoveOne();
   }
   public RemoveOne()
   {
   	
       OneRemove fra = new OneRemove();
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fra.setResizable (false);
      fra.show();
   }
}

 class OneRemove extends JFrame 
{  
   
   
    public OneRemove()
   {  
      setTitle("Remove One Record");
      setSize(800,500);
	  setResizable(false);

      Container contentPane = getContentPane();

   


      JPanel paneleno=new JPanel();
      JPanel panel10=new JPanel();  
    
      JLabel lb=new JLabel("Enrollnment No.     ");
      ENO = new JTextField(12);
      lb.setFont(font);
      ENO.setFont(font);
      paneleno.add(lb);
      paneleno.add(ENO);
      ENO.setToolTipText("E.g. 1112420040");
      

     	  
      JButton SaveButton = new JButton("Delete");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new RemoveDtls1());
               
               
                          
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
      CloseButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               OneRemove.this.dispose();
            }
         });
       ImageIcon igm=new ImageIcon("wm.gif");
       JLabel ilm = new JLabel("", igm, JLabel.CENTER);
       getContentPane().add(ilm);

      contentPane.add(paneleno);   
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(5,15));
   }

   private JTextField ENO
;   private ButtonGroup group;
   private Font font = new Font("Tahoma",Font.BOLD,25);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
  public static final int	HAND_CURSOR	= 12;

 
		 
		  	
   
            
//Remove DETAILS OF STUDENTS
private class RemoveDtls1 extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
                 try
                {
                      String url = "jdbc:Oracle:thin:@localhost:1521:XE";
		Connection con;
			 
                        
                        String CreateString,CreateString1,sql,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17;
			Statement stmt;
                         int en;	
                        en=Integer.parseInt(ENO.getText());		
			
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
                           
                             con = DriverManager.getConnection(url,"system","admin");
				stmt = con.createStatement();			
//Remove One Record
                                  sql="Select count(*) from StudentEntry where enroll="+en;
                                  ResultSet rs= stmt.executeQuery(sql);
                                  while(rs.next())
                                 {
                                     if(rs.getInt("count(*)")==0)
                                               JOptionPane.showMessageDialog(RemoveDtls1.this,"         Sorry Record Not Found !"," No found*!!",JOptionPane.WARNING_MESSAGE);                            
                                      else
                                   {
                                           CreateString="delete  from StudentEntry where enroll="+en;
				
				          stmt.executeUpdate(CreateString);
                                              t1="delete  from ExCO1G where exeno="+en;
				
				          stmt.executeUpdate(t1);
                                             t2="delete  from ExCO2G where exeno1="+en;
				
				          stmt.executeUpdate(t2);
                                            t3="delete  from ExCO3G where exeno1="+en;
				
				          stmt.executeUpdate(t3);

                                           t4="delete  from ExCO4G where exeno1="+en;
				
				          stmt.executeUpdate(t4);
                                        t5="delete  from ExCO5E where exno1="+en;
 				
				          stmt.executeUpdate(t5);

                                           t6="delete  from ExCO6E where exno1="+en;
				          stmt.executeUpdate(t6);
                                          
                                                 t6="delete  from ExCO6E where exno1="+en;
				          stmt.executeUpdate(t6);
                                            t7="delete  from temp2 where e="+en;
				          stmt.executeUpdate(t7);
                                          t8="delete  from tco2g where e="+en;
       				          stmt.executeUpdate(t8);
                                          t9="delete  from tco3g where e="+en;
       				          stmt.executeUpdate(t9);
                                          t10="delete  from tco4g where e="+en;
       				          stmt.executeUpdate(t10);
                                          t11="delete  from tco5e where e="+en;
       				          stmt.executeUpdate(t11);
                                          t12="delete  from tco6e where e="+en;
       				          stmt.executeUpdate(t12);
                                          
                                           t13="delete  from InCO1G where en="+en;
       				          stmt.executeUpdate(t13);     
                                           t14="delete  from InCO2G where en="+en;
       				          stmt.executeUpdate(t14);     
                                            t15="delete  from InCO4G where en="+en;
       				          stmt.executeUpdate(t15);     
                                            t16="delete  from InCO3G where en="+en;
       				          stmt.executeUpdate(t16);     
                                            t17="delete  from InCO5e where en="+en;
       				          stmt.executeUpdate(t17);     
                                           
                                           
                                       
                                       JOptionPane.showMessageDialog(RemoveDtls1.this,"   This Record has been Removed !"," Removed*!!",JOptionPane.WARNING_MESSAGE);                            
                                   }
                             }                           
                          }catch(Exception e){
                                                      
                                                       
                                                 }    
                     }catch(Exception e){
                                                      
                                       JOptionPane.showMessageDialog(RemoveDtls1.this,"   Please Enter Enrollnment no. !"," Empty*!!",JOptionPane.WARNING_MESSAGE);                                               
                                                 } 
                       
						
		
         }

  }
		 
		  	
   }
            
