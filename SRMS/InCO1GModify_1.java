import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class InCO1GModify
{
   public static void main(String arg[])
   {  
    InCO1GModify i11=new InCO1GModify();
   }
   public  InCO1GModify()
   {
   	
       AddingMarks311 fn = new AddingMarks311();
      fn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fn.setResizable (false);
      fn.show();
   }
}

 class AddingMarks311 extends JFrame 
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
   
   
    public AddingMarks311()
   {  
      setTitle("CO1G Internal Marks Correction");
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
                           
                                CreateString="Select * from t";
				
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
    
      ENG=new JLabel("English TermWork :    ");
      ENG.setFont(font);  
      panel3.add(ENG);    
      t1=new JTextField(2);
      t1.setFont(font);
      panel3.add(t1);
      JLabel l1=new JLabel("/25");
      l1.setFont(font);
      panel3.add(l1);
   
      
      PHY=new JLabel("Basic Physics  Practical :  ");
      PHY.setFont(font);  
      panel4.add(PHY);     
      t2=new JTextField(2);
      t2.setFont(font);
      panel4.add(t2);
      JLabel l2=new JLabel("/25");
      l2.setFont(font);
      panel4.add(l2);
   
      CHE=new JLabel("Basic Chemistry Practical :    ");
      CHE.setFont(font);  
      panel5.add(CHE);     
       t3=new JTextField(2);
      t3.setFont(font);
      panel5.add(t3);
      JLabel l3=new JLabel("/25");
      l3.setFont(font);
      panel5.add(l3);
   
      CMF=new JLabel("Computer Fundamental TermWork     ");
      CMF.setFont(font);  
      panel6.add(CMF); 
       t4=new JTextField(2);
      t4.setFont(font);
      panel6.add(t4);
      JLabel l4=new JLabel("/25");
      l4.setFont(font);
      panel6.add(l4);

         JLabel ll=new JLabel("Computer Fundamental Practical:");
      ll.setFont(font);
      panel7.add(ll);
      t5=new JTextField(2);
      t5.setFont(font);
      panel7.add(t5);
      JLabel l5=new JLabel("/50");
      l5.setFont(font);
      panel7.add(l5);
       
  
     WPI=new JLabel("Workshop Practice TermWork  :   ");
      WPI.setFont(font);  
      panel8.add(WPI);
        t6=new JTextField(2);
      t6.setFont(font);
      panel8.add(t6);
      JLabel l6=new JLabel("/50");
      l6.setFont(font);
      panel8.add(l6);
      
      JLabel lt=new JLabel("Engineering Graphics Practical:");
      lt.setFont(font);
      panel9.add(lt);
        t7=new JTextField(2);
      t7.setFont(font);
      panel9.add(t7);
      JLabel l7=new JLabel("/50");
      l7.setFont(font);
      panel9.add(l7);
        
      JLabel lg=new JLabel("Engineering Graphics TermWork:");
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
      SaveButton.addActionListener(new SaveDtls3300());
               
               
                          
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
     CloseButton.addActionListener(new  Closedt511());
        
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
      contentPane.add(panel9);
      contentPane.add(panel11);
      contentPane.add(panel12);
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(15,5));
String t="truncate table T";
              stmt.executeUpdate(t);  


       
                  String url1 = "jdbc:Oracle:thin:@localhost:1521:XE";
        		Connection con1;
			 
                                             
                         String sql1,sql2,sql3,sql4;
			String b1;
                        int e1,m1,m2,m3,m4,m5,m6,m7,m8,m9;
			Statement stmt1;
			
			
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
                           
                             con1 = DriverManager.getConnection(url1,"system","admin");
				stmt1 = con1.createStatement();			
//Extract Student Record
                           
                                                     
                               sql1="select * from InCO1G where en="+Integer.parseInt(re.getText());
                               
 
                                ResultSet se2=stmt1.executeQuery(sql1);
                                while(se2.next())
                              {
                                e1=se2.getInt("en");
                                b1=se2.getString("bs"); 
                                m1=se2.getInt("etw"); 
                                m2=se2.getInt("ptw");
                                m3=se2.getInt("ctw");
                                m4=se2.getInt("cmfw"); 
                                m5=se2.getInt("wpitw");
                                m6=se2.getInt("cft");
                                m7=se2.getInt("egp"); 
                                m8=se2.getInt("egt");
				 m9=se2.getInt("sw");
                               
                                                                  
                                
                                 re.setText(String.valueOf(e1));
                                 gf.setText(b1);
      	   		        t1.setText(String.valueOf(m1));
			        t2.setText(String.valueOf(m2));	
			        t3.setText(String.valueOf(m3));
 				t4.setText(String.valueOf(m4));
			        t5.setText(String.valueOf(m5));	
			        t6.setText(String.valueOf(m6));
				t7.setText(String.valueOf(m7));
			        t8.setText(String.valueOf(m8));	
			         t9.setText(String.valueOf(m9));	
			        
			                       //s1.close();
                           }   // s2.close();
                            
                          }
                           catch(Exception eb){
                                                    //SName.setText("Data Not Found");
                                                     //  JOptionPane.showMessageDialog(AddingStudent2.this,"         Record of Enrollnment no Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
                                                    System.err.println(eb.getMessage());  
                                               }    


}
}

  }catch(Exception e){}


}

   
private class Closedt511 extends JFrame implements ActionListener 
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
              String tru="truncate table T";
              stmt.executeUpdate(tru);  

              AddingMarks311.this.dispose();
              }catch(Exception e){System.err.println(e.getMessage());} 
              
             
            }
    }
 
//SAVE Marks OF STUDENTS
private class SaveDtls3300 extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
              
                  try
                   {



                boolean freeflag = false;             
                  String url = "jdbc:Oracle:thin:@localhost:1521:XE";
                   String CreateString,CreateString1,tru,gl;
			String bs1;
                        int en1,m1,m2,m3,m4,m5,m6,m7,m8,m9;
			Statement stmt;
                        
                      en1=Integer.parseInt(re.getText());
                     
                      m1=Integer.parseInt(t1.getText());
                      m2=Integer.parseInt(t2.getText());
                      m3=Integer.parseInt(t3.getText());
                     m4=Integer.parseInt(t4.getText());
                      m5=Integer.parseInt(t5.getText());
                      m6=Integer.parseInt(t6.getText());
                     m7=Integer.parseInt(t7.getText());
                       m8=Integer.parseInt(t8.getText());
			  m9=Integer.parseInt(t9.getText());
                     
                      
                      
		Connection con;
		try
                {	 
                        
                      
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
                                                                
                                CreateString="Update InCO1G set etw="+m1+",ptw="+m2+",ctw="+m3+",cmfw="+m4+",wpitw="+m5+",cft="+m6+",egp="+m7+",egt="+m8+",sw="+m9+" where en="+en1;
				
				stmt.executeUpdate(CreateString);
                                  tru="truncate table t";
                                 stmt.executeUpdate(tru);    

                                
                              
                               
                        

                            
                            
                          }catch(Exception e){
                                                    JOptionPane.showMessageDialog(SaveDtls3300.this,"         Record of Enrollnment no Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
                            
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
                        t7.setText("");
                        t8.setText("");
                         t9.setText("");
                        }
                 
                  }
                catch(Exception e)
                  {
                        JOptionPane.showMessageDialog(SaveDtls3300.this,"       Please Fill the information !","Empty !!!",JOptionPane.WARNING_MESSAGE);
                  }	
  
                if(freeflag == false)
		{
      	   	        t1.setText("");
                        t2.setText("");
                        t3.setText("");
	   		
                        t4.setText("");
                        t5.setText("");
                        t6.setText("");
                        t7.setText("");
                        t8.setText("");
			 t9.setText("");
                                               
	      }

           }catch(Exception e){System.err.println(e.getMessage());}

         }

        

  }
		 
		  	
   }
            
