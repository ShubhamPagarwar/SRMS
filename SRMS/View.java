import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class View
{
   public static void main(String arg[])
   {  
    View ld=new View();
   }
   public View()
   {
   	
       OneView fra = new OneView();
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fra.setResizable (false);
      fra.show();
   }
}
  

 class OneView extends JFrame 
{  
 
     private JTextField EXT,MOT,ENO,SName,Phone,Mobile,Email,Birthdate,Nationality;
   private ButtonGroup group;
   private JTextArea Address;
   private JRadioButton Male,Female;
   private Font font = new Font("Tahoma",Font.BOLD,25);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
  public static final int	HAND_CURSOR	= 12;
  
   
    public OneView()
   {  
      setTitle("View One Record");
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
      
            String url = "jdbc:odbc:Shubham";
		Connection con;
			 
                        
                        String CreateString,CreateString1;
			Statement stmt;
      JButton SaveButton = new JButton("Ok");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new ViewDtls1());
                          
                          
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
      CloseButton.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               OneView.this.dispose();
            }
         });
       ImageIcon igm=new ImageIcon("wm.gif");
       JLabel ilm = new JLabel("", igm, JLabel.CENTER);
       getContentPane().add(ilm);

      contentPane.add(paneleno);   
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(5,15));
   }


 
		 
		  	
   

            
            
//Remove DETAILS OF STUDENTS
private class ViewDtls1 extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
                    try
                    {
                     String url = "jdbc:Oracle:thin:@localhost:1521:XE";
		     Connection con;
			 
                        
                        String CreateString,CreateString1;
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
                           
                             String sql;
                              con = DriverManager.getConnection(url,"system","admin");
				stmt = con.createStatement();			
//Remove All Record          
                              sql= "select count(*) from StudentEntry where enroll="+en;
                              
                                ResultSet rs = stmt.executeQuery(sql);
                               while(rs.next())
                              {
                               int n=rs.getInt("count(*)");
                                if(n!=0)
                                 {
                                      CreateString="insert into Temp values("+en+")";
				
				    stmt.executeUpdate(CreateString);
                                    ViewStudent lc=new ViewStudent();
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
            
