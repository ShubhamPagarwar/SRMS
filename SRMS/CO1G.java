import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class CO1G
{
   public static void main(String arg[])
   {  
    CO1G g1=new CO1G();
   }
   public  CO1G()
   {
   	
       AddingMarks fn = new AddingMarks();
      fn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fn.setResizable (false);
      fn.show();
   }
}

 class AddingMarks extends JFrame 
{  
    private JTextField ENG,PHY,CHE,MAT,ENO;
   private JLabel re,gf,st;
   private ButtonGroup group;
   private JTextArea Address;
   private JRadioButton Male,Female;
   private Font font = new Font("Tahoma",Font.BOLD,17);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
   public static final int	HAND_CURSOR	= 12;
   
   
    public AddingMarks()
   {  
      setTitle("CO1G External Marks Entry");
      setSize(1300,800);
	  setResizable(false);

      Container contentPane = getContentPane();

     
    

        
        
         Statement stmt;
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
                           boolean freeflag = false;             
                            String url = "jdbc:Oracle:thin:@localhost:1521:XE";
                           String CreateString,CreateString1,sl;
 
                           String Bran,fname;
                            int enroll,ss;
                             con = DriverManager.getConnection(url,"system","admin");
				stmt = con.createStatement();			
                           
                                CreateString="Select ent,bs,ss from temp1";
				
				ResultSet rs=stmt.executeQuery(CreateString);
                                 while(rs.next())
                                 {
                                    enroll=rs.getInt("ent");
                                    Bran=rs.getString("bs");
                                    ss=rs.getInt("ss");
                                 
                                    sl="Select full from StudentEntry where enroll="+enroll;
                                    ResultSet rs1=stmt.executeQuery(sl);
                                     while(rs1.next())
                                     {
                                        fname=rs1.getString("full");
     
                            
           JPanel paneleno=new JPanel();
      JPanel panel1 = new JPanel();
      JPanel panelBranch=new JPanel();
      JPanel panelseat = new JPanel();
      JPanel label=new JPanel();
      JPanel panel2 = new JPanel();
      JPanel panel3 = new JPanel();
      JPanel panel4 = new JPanel();
      JPanel panel5 = new JPanel();
      JPanel panel6 = new JPanel();
      JPanel panel10 = new JPanel();
                       
      
						

            
      JLabel eno=new JLabel("Enrollnment No.=     ");
      eno.setFont(new Font("Tahoma",Font.BOLD,17));
      paneleno.add(eno);
      re=new JLabel(String.valueOf(enroll));
      re.setFont(new Font("Tahoma",Font.BOLD,17));
      paneleno.add(re);

      JLabel sn=new JLabel("Student Full Name =     ");
      sn.setFont(new Font("Tahoma",Font.BOLD,17));
      panel1.add(sn);
      JLabel fn=new JLabel(fname);
      fn.setFont(new Font("Tahoma",Font.BOLD,17));
      panel1.add(fn);
      
      JLabel bd=new JLabel("Branch And Sem=   ");
      bd.setFont(new Font("Tahoma",Font.BOLD,17));
      panelBranch.add(bd);
      gf=new JLabel(Bran);
      gf.setFont(new Font("Tahoma",Font.BOLD,17));
      panelBranch.add(gf); 
          	   	   

      JLabel nh=new JLabel("Seat No.=");
      nh.setFont(new Font("Tahoma",Font.BOLD,17));
      panelseat.add(nh);     
      st=new JLabel(String.valueOf(ss));
      st.setFont(new Font("Tahoma",Font.BOLD,17));
      panelseat.add(st);
    
      JLabel ls=new JLabel("Please Enter the Marks of Following Subject");
      ls.setFont(new Font("Tahoma",Font.BOLD,17));
      label.add(ls);	
    
      JLabel s1=new JLabel("English      ");
      s1.setFont(font);  
      panel3.add(s1);     
      ENG = new JTextField(3);
      panel3.add(ENG);
      ENG.setFont(font);
      JLabel r1=new JLabel("/100");
      r1.setFont(font);
      panel3.add(r1);  
      
     JLabel s2=new JLabel("Basic Physics     ");
      s2.setFont(font);  
      panel4.add(s2);     
      PHY = new JTextField(3);
      panel4.add(PHY);
      PHY.setFont(font);
      JLabel r2=new JLabel("/50");
      r2.setFont(font);
      panel4.add(r2);  
      
      JLabel s3=new JLabel("Basic Chemistry     ");
      s3.setFont(font);  
      panel5.add(s3);     
      CHE = new JTextField(3);
      panel5.add(CHE);
      CHE.setFont(font);
      JLabel r3=new JLabel("/50");
      r3.setFont(font);
      panel5.add(r3);
     
      JLabel s4=new JLabel("Basic Mathematics     ");
      s4.setFont(font);  
      panel6.add(s4);     
      MAT = new JTextField(3);
      panel6.add(MAT);
      MAT.setFont(font);
      JLabel r4=new JLabel("/100");
      r4.setFont(font);
      panel6.add(r4);  
  
     
      
            JButton SaveButton = new JButton("Save");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new SaveDtls3());
               
               
                          
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
     CloseButton.addActionListener(new  Closedt());
        
             contentPane.add(paneleno);   
      contentPane.add(panel1);
       contentPane.add(panelBranch);
      contentPane.add(panelseat);
      contentPane.add(label);
      contentPane.add(panel3);
      contentPane.add(panel4);     
      contentPane.add(panel5);
      contentPane.add(panel6);
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(15,5));

         String tru="truncate table Temp1";
              stmt.executeUpdate(tru);  

}
}
  }catch(Exception e){}
                 
 }

   
private class Closedt extends JFrame implements ActionListener 
 { 
     
 
    public void actionPerformed(ActionEvent event)
            {
               Statement stmt;
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
               String url = "jdbc:Oracle:thin:@localhost:1521:XE";
               
               con = DriverManager.getConnection(url,"system","admin");
                stmt = con.createStatement();			
              String tru="truncate table Temp1";
              stmt.executeUpdate(tru);
              AddingMarks.this.dispose();
              }catch(Exception e){System.err.println(e.getMessage());} 
              
             
            }
    }
 
//SAVE Marks OF STUDENTS
private class SaveDtls3 extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
                 
                    boolean freeflag = false;             
                  String url = "jdbc:Oracle:thin:@localhost:1521:XE";
                   String CreateString,CreateString1,tru,gl,s,s1;
			String bs1;
                        int en1,se1,eng1,phy1,che1,mat1;
			Statement stmt;
                  
		Connection con;
                 
		try
                {	 
                        
                        en1=Integer.parseInt(re.getText());
                        bs1="'"+gf.getText()+"'";
                        se1=Integer.parseInt(st.getText());
                        eng1=Integer.parseInt(ENG.getText());
                        phy1=Integer.parseInt(PHY.getText());
                        che1=Integer.parseInt(CHE.getText());
                        mat1=Integer.parseInt(MAT.getText()); 
                         con = DriverManager.getConnection(url,"system","admin");
				stmt = con.createStatement();	             
			
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
                           
                         	
//TO INSERT INTO Marks DB       
                                s="insert into temp2 values("+en1+")";
                                stmt.executeUpdate(s);
                                 CreateString="INSERT INTO ExCO1G VALUES("+en1+","+bs1+","+se1+","+eng1+","+phy1+","+che1+","+mat1+")";
			         stmt.executeUpdate(CreateString);
                                  tru="truncate table Temp1";
                                 stmt.executeUpdate(tru);    

                                
                              
                               
                        

                            
                            
                          }catch(Exception e){
                                                    JOptionPane.showMessageDialog(SaveDtls3.this,"         Record Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
                                                       System.err.println(e.getMessage());
                                                 }
                   
                              
                              
						
		
//TO CLEAR FIELDS
		if(freeflag == false)
		{
	   		ENG.setText("");
                        PHY.setText("");
                        CHE.setText("");
	   		MAT.setText("");
			
	      }
                 
                  }
                catch(Exception e)
                  {
                        JOptionPane.showMessageDialog(SaveDtls3.this,"       Please Fill the information !","Empty !!!",JOptionPane.WARNING_MESSAGE);
                  }	
  
                if(freeflag == false)
		{
	   		ENG.setText("");
                        PHY.setText("");
                        CHE.setText("");
	   		MAT.setText("");
	      }


         }
        

  }
		 
		  	
   }
            
