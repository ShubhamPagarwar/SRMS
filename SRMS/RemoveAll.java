import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class RemoveAll
{
   public static void main(String arg[])
   {  
    RemoveAll ra=new RemoveAll();
   }
   public RemoveAll()
   {
   	
       Removes fr = new Removes();
      fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fr.setResizable (false);
      fr.show();
   }
}

 class Removes extends JFrame 
{  
   
   
    public Removes()
   {  
      setTitle("Remove All Record");
      setSize(800,500);
	  setResizable(false);

       Container contentPane = getContentPane();

   


      JPanel panellabel=new JPanel();
      JPanel panel10 = new JPanel();
    


      JLabel fo=new JLabel("Are You Sure to Remove All The Student Record ?   ");
      fo.setFont(font);
      panellabel.add(fo);
                 JButton SaveButton = new JButton("Yes");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new RemoveDtls());
               
               
                          
      
      JButton CloseButton = new JButton("No");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
      CloseButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               Removes.this.dispose();
            }
         });
      ImageIcon ig=new ImageIcon("wm.gif");
      JLabel il = new JLabel("", ig, JLabel.CENTER);
       getContentPane().add(il);

      contentPane.add(panellabel);   
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(5,25));
   }
   private ButtonGroup group;
   private Font font = new Font("Tahoma",Font.BOLD,25);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
  public static final int	HAND_CURSOR	= 12;

 
     
 
//REMOVE DETAILS OF STUDENTS
private class RemoveDtls extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
                     String url = "jdbc:Oracle:thin:@localhost:1521:XE";
		Connection con;
			 
                        
                        String CreateString,CreateString1,t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20;
			Statement stmt;
			
			
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
//Remove All Record
                           
                                     t1="truncate table ExCO1G";
				
				stmt.executeUpdate(t1);
                                                t2="truncate table ExCO2G";
				
				stmt.executeUpdate(t2);
                                              t3="truncate table ExCO3G";
				
				stmt.executeUpdate(t3);

                                         t4="truncate table ExCO4G";
				
				stmt.executeUpdate(t4);
                              t5="truncate table ExCO5E";
				
				stmt.executeUpdate(t5);

                                 t6="truncate table ExCO6E";
				
				stmt.executeUpdate(t6);
                                     t7="truncate table StudentEntry";
				
				stmt.executeUpdate(t7);
                                     t8="truncate table temp2";
				
				stmt.executeUpdate(t8);
                                     t9="truncate table temp1";
				
				stmt.executeUpdate(t9);
                                     t10="truncate table temp";
				
				stmt.executeUpdate(t10);
                                     t11="truncate table tco2g";
				
				stmt.executeUpdate(t11);
                                     t12="truncate table tco3g";
				
				stmt.executeUpdate(t12);
                                     t13="truncate table tco4g";
				
				stmt.executeUpdate(t13);
                                     t14="truncate table tco5e";
				
				stmt.executeUpdate(t14);
                                     t15="truncate table tco6e";
				
				stmt.executeUpdate(t15);
                                

                                          t16="truncate table InCO1g";
				
				stmt.executeUpdate(t16);
       t17="truncate table InCO2g";
				
				stmt.executeUpdate(t17); 
        t18="truncate table InCO4g";
				
				stmt.executeUpdate(t18);
  t19="truncate table InCO3g";
				
				stmt.executeUpdate(t19);
  t20="truncate table InCO5e";
				
				stmt.executeUpdate(t20);


                                      JOptionPane.showMessageDialog(RemoveDtls.this,"         All Record has been Removed !"," Removed*!!",JOptionPane.WARNING_MESSAGE);                            
                            
                          }catch(Exception e){
                                                     System.err.println(e.getMessage());
                                                       
                                                 }    

						
		
         }

  }
		 
		  	
   }
            
