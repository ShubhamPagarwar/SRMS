import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class InCO5E
{
   public static void main(String arg[])
   {  
    InCO5E i5=new InCO5E();
   }
   public  InCO5E()
   {
   	
       AddM5 fn = new AddM5();
      fn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fn.setResizable (false);
      fn.show();
   }
}

 class AddM5 extends JFrame 
{  
    private JLabel ENG,PHY,CHE,CMF,WPI;
   private JLabel re,gf,st;
   private JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
   private ButtonGroup group;
   private JTextArea Address;
   private JRadioButton Male,Female;
   private Font font = new Font("Tahoma",Font.BOLD,17);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
   public static final int	HAND_CURSOR	= 12;
   
   
    public AddM5()
   {  
      setTitle("CO5E Internal Marks Entry");
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
                           
                                CreateString="Select ent,bs from t";
				
				ResultSet rs=stmt.executeQuery(CreateString);
                                 while(rs.next())
                                 {
                                    enroll=rs.getInt("ent");
                                    Bran=rs.getString("bs");
                                   
                                 
                                    sl="Select full from StudentEntry where enroll="+enroll;
                                    ResultSet rs1=stmt.executeQuery(sl);
                                     while(rs1.next())
                                     {
                                        fname=rs1.getString("full");
     
                            
           JPanel paneleno=new JPanel();
      JPanel panel1 = new JPanel();
      JPanel panelBranch=new JPanel();
      JPanel label=new JPanel();
      JPanel panel2 = new JPanel();
      JPanel panel3 = new JPanel();
      JPanel panel4 = new JPanel();
      JPanel panel5 = new JPanel();
      JPanel panel6 = new JPanel();
       JPanel panel7 = new JPanel();
      JPanel panel8 = new JPanel();
      JPanel panel9 = new JPanel();
      JPanel panel10 = new JPanel();
       JPanel panel11 = new JPanel();
       JPanel panel12 = new JPanel();                       
      
						

            
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
          	   	   

      
      JLabel ls=new JLabel("Please Choose And Enter the Marks of Following Subject");
      ls.setFont(new Font("Tahoma",Font.BOLD,17));
      label.add(ls);	
    
      ENG=new JLabel("Java Programming Practical:    ");
      ENG.setFont(font);  
      panel3.add(ENG);    
      t1=new JTextField(2);
      t1.setFont(font);
      panel3.add(t1);
      JLabel l1=new JLabel("/50");
      l1.setFont(font);
      panel3.add(l1);
   
      
      PHY=new JLabel("Java Programming Termwork :  ");
      PHY.setFont(font);  
      panel4.add(PHY);     
      t2=new JTextField(2);
      t2.setFont(font);
      panel4.add(t2);
      JLabel l2=new JLabel("/25");
      l2.setFont(font);
      panel4.add(l2);
   
      CHE=new JLabel("Operating System Termwork :    ");
      CHE.setFont(font);  
      panel5.add(CHE);     
       t3=new JTextField(2);
      t3.setFont(font);
      panel5.add(t3);
      JLabel l3=new JLabel("/25");
      l3.setFont(font);
      panel5.add(l3);
   
      CMF=new JLabel("Advance Microprocessor Termwork:     ");
      CMF.setFont(font);  
      panel6.add(CMF); 
       t4=new JTextField(2);
      t4.setFont(font);
      panel6.add(t4);
      JLabel l4=new JLabel("/25");
      l4.setFont(font);
      panel6.add(l4);

         JLabel ll=new JLabel("Network mng. And Administration Oral:");
      ll.setFont(font);
      panel7.add(ll);
      t5=new JTextField(2);
      t5.setFont(font);
      panel7.add(t5);
      JLabel l5=new JLabel("/25");
      l5.setFont(font);
      panel7.add(l5);
       
  
     WPI=new JLabel("Network mng. And Administration  Termwork  :   ");
      WPI.setFont(font);  
      panel8.add(WPI);
        t6=new JTextField(2);
      t6.setFont(font);
      panel8.add(t6);
      JLabel l6=new JLabel("/25");
      l6.setFont(font);
      panel8.add(l6);
      
        
      JLabel lg=new JLabel("Professional Practices-v:");
      lg.setFont(font);
      panel11.add(lg);
      t8=new JTextField(2);
      t8.setFont(font);
      panel11.add(t8);
      JLabel l8=new JLabel("/50");
      l8.setFont(font);
      panel11.add(l8);
   
        JLabel lg1=new JLabel("Sessional:");
      lg1.setFont(font);
      panel12.add(lg1);
      t9=new JTextField(2);
      t9.setFont(font);
      panel12.add(t9);
      JLabel l9=new JLabel("/50");
      l9.setFont(font);
      panel12.add(l9);

      
            JButton SaveButton = new JButton("Save");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new Saven());
               
               
                          
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
     CloseButton.addActionListener(new  Closen());
        
             contentPane.add(paneleno);   
      contentPane.add(panel1);
       contentPane.add(panelBranch);
      
      contentPane.add(label);
      contentPane.add(panel3);
      contentPane.add(panel4);     
      contentPane.add(panel5);
      contentPane.add(panel6);
      contentPane.add(panel7);
      contentPane.add(panel8);
      contentPane.add(panel11);
      contentPane.add(panel12);
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(15,5));
          
          String t="truncate table T";
              stmt.executeUpdate(t); 


}
}
  }catch(Exception e){}
                 
 }


   
private class Closen extends JFrame implements ActionListener 
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
               
          String t="truncate table T";
              stmt.executeUpdate(t);  
              
              AddM5.this.dispose();
              }catch(Exception e){System.err.println(e.getMessage());} 
              
             
            }
    }
 
//SAVE Marks OF STUDENTS
private class Saven extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
                 
                   boolean freeflag = false;             
                  String url = "jdbc:Oracle:thin:@localhost:1521:XE";
                   String CreateString,CreateString1,tru,gl;
			String bs1;
                        int en1,m1,m2,m3,m4,m5,m6,m8,m9;
			Statement stmt;
		Connection con;
		try
                {	 
                        
                        en1=Integer.parseInt(re.getText());
                        bs1="'"+gf.getText()+"'";
                        m1=Integer.parseInt(t1.getText());
                        m2=Integer.parseInt(t2.getText());
                        m3=Integer.parseInt(t3.getText());
                        m4=Integer.parseInt(t4.getText());
                        m5=Integer.parseInt(t5.getText());
                        m6=Integer.parseInt(t6.getText());
                        m8=Integer.parseInt(t8.getText()); 
                        m9=Integer.parseInt(t9.getText());
                        
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
//TO INSERT INTO Marks DB
                                 CreateString="INSERT INTO InCO5E VALUES("+en1+","+bs1+","+m1+","+m2+","+m3+","+m4+","+m5+","+m6+","+m8+","+m9+")";
			         stmt.executeUpdate(CreateString);
                                  tru="truncate table Temp1";
                                 stmt.executeUpdate(tru);    

                                
                              
                               
                        

                            
                            
                          }catch(Exception e){
                                                    JOptionPane.showMessageDialog(Saven.this,"         Record of Enrollnment no Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
                            
                                                 }    

						
		
//TO CLEAR FIELDS
		if(freeflag == false)
		{
	   		t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t8.setText("");
 t9.setText("");
                       
                        
                }
                 
                  }
                catch(Exception e)
                  {
                        JOptionPane.showMessageDialog(Saven.this,"       Please Fill the information !","Empty !!!",JOptionPane.WARNING_MESSAGE);
                  }	
  
                if(freeflag == false)
		{
	   			t1.setText("");
                        t2.setText("");
                        t3.setText("");
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t8.setText("");
				 t9.setText("");
                                                               }

         }
        
      
  }
		 
		  	
   }
            
