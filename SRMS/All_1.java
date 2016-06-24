import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class All
{
   public static void main(String arg[])
   {  
    All a=new All();
   }
   public All()
   {
   	
       AllDetails fra = new AllDetails();
      fra.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fra.setResizable (false);
      fra.show();
   }
}

 class AllDetails extends JFrame 
{  
   private Font font = new Font("Tahoma",Font.BOLD,25);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
    public static final int	HAND_CURSOR	= 12;
   
   
    public AllDetails()
   {  
      setTitle("Showing Student Enrollnment no.");
      setSize(1300,1300);
	  setResizable(false);

      Container contentPane = getContentPane();

      int i=0; 
      JPanel paneleno=new JPanel();
      JPanel panelres=new JPanel();
      JPanel panel10=new JPanel();
          
      JLabel lb=new JLabel("Available Student Enrolllnment No. are as follow:        ");
      lb.setFont(font);
      lb.setForeground(Color.red);
      paneleno.add(lb);
      
       JComboBox lb1=new JComboBox();      
        lb1.setFont(font);
       JScrollPane jsp=new JScrollPane(lb1);
      panelres.add(jsp);

                   try
                {
                      String url = "jdbc:Oracle:thin:@localhost:1521:XE";
		Connection con;
			 
                        
                        
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
//Retrieve Record
                                 String sql="Select Enroll from StudentEntry ";
                                  ResultSet rs= stmt.executeQuery(sql);
                                  while(rs.next())
                                 {

       i++;
      
       lb1.addItem(i+". "+rs.getInt("Enroll"));
     
     
   }
   }catch(Exception e){}
   }catch(Exception e){}

   
 
		 
		  
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      CloseButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      CloseButton.setForeground(color1);
      CloseButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               AllDetails.this.dispose();
            }
         });
       
      contentPane.add(paneleno);
       contentPane.add(panelres);   
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(5,15));	  	
   
        		
         

  }
		 
		  	

}            
