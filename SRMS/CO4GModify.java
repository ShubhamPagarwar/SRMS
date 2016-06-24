import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class CO4GModify
{
   public static void main(String arg[])
   {  
    CO4GModify g24=new CO4GModify();
   }
   public  CO4GModify()
   {
   	
       AddingMarks302 fn = new AddingMarks302();
      fn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fn.setResizable (false);
      fn.show();
   }
}

 class AddingMarks302 extends JFrame 
{  
    private JTextField st,COMM,APP,PROGC,ELE,EMAT;
   private JLabel re,gf;
   private ButtonGroup group;
   private JTextArea Address;
   private JRadioButton Male,Female;
   private Font font = new Font("Tahoma",Font.BOLD,17);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
   public static final int	HAND_CURSOR	= 12;
   
   
    public AddingMarks302()
   {  
      setTitle("CO4G External Marks Correction");
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
      JPanel panel7 = new JPanel();
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
      st=new JTextField(8);
      st.setFont(new Font("Tahoma",Font.BOLD,17));
      
       panelseat.add(st);
      
         
      JLabel ls=new JLabel("Please Enter the Marks of Following Subject");
      ls.setFont(new Font("Tahoma",Font.BOLD,17));
      label.add(ls);	
    
     
      JLabel s1=new JLabel("Basic Microprocessor      ");
      s1.setFont(font);  
      panel3.add(s1);     
      COMM = new JTextField(3);
      panel3.add(COMM);
      COMM.setFont(font);
      JLabel r1=new JLabel("/100");
      r1.setFont(font);
      panel3.add(r1);  
      
     JLabel s2=new JLabel("Object Oriented Programming    ");
      s2.setFont(font);  
      panel4.add(s2);     
      APP = new JTextField(3);
      panel4.add(APP);
      APP.setFont(font);
      JLabel r2=new JLabel("/100");
      r2.setFont(font);
      panel4.add(r2);  
      
      JLabel s3=new JLabel("Computer Network     ");
      s3.setFont(font);  
      panel5.add(s3);     
      PROGC = new JTextField(3);
      panel5.add(PROGC);
      PROGC.setFont(font);
      JLabel r3=new JLabel("/100");
      r3.setFont(font);
      panel5.add(r3);
     
      JLabel s4=new JLabel("Computer Architecture and Maintanance     ");
      s4.setFont(font);  
      panel6.add(s4);     
      ELE = new JTextField(3);
      panel6.add(ELE);
      ELE.setFont(font);
      JLabel r4=new JLabel("/100");
      r4.setFont(font);
      panel6.add(r4); 

      JLabel s5=new JLabel("Enviranmental Studies     ");
      s5.setFont(font);  
      panel7.add(s5);     
      EMAT = new JTextField(3);
      panel7.add(EMAT);
      EMAT.setFont(font);
      JLabel r5=new JLabel("/100");
      r5.setFont(font);
      panel7.add(r5); 
  
     
      
            JButton SaveButton = new JButton("Save");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new SaveDtls3319());
               
               
                          
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
      CloseButton.addActionListener(new  Closedt3129());
        
             contentPane.add(paneleno);   
      contentPane.add(panel1);
       contentPane.add(panelBranch);
      contentPane.add(panelseat);
      contentPane.add(label);
      contentPane.add(panel3);
      contentPane.add(panel4);     
      contentPane.add(panel5);
      contentPane.add(panel6);
      contentPane.add(panel7);      
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(15,5));

         


       
                  String url1 = "jdbc:Oracle:thin:@localhost:1521:XE";
        		Connection con1;
			 
                                             
                         String sql1,sql2,sql3,sql4;
			String b1;
                        int e1,st1,comm2,app2,progc2,ele2,emat2;
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
                           
                                                     
                               sql1="select exeno1,brs,seatno,exmpo,exoop,excne,excam,exens from ExCO4G where exeno1="+Integer.parseInt(re.getText());
                               
 
                                ResultSet se2=stmt1.executeQuery(sql1);
                                while(se2.next())
                              {
                                e1=se2.getInt("exeno1");
                                b1=se2.getString("brs");
                                st1=se2.getInt("seatno"); 
                                comm2=se2.getInt("exmpo"); 
                                app2=se2.getInt("exoop");
                                progc2=se2.getInt("excne");
                                ele2=se2.getInt("excam");
                                emat2=se2.getInt("exens");
                                                                  
                                
                                 re.setText(String.valueOf(e1));
                                gf.setText(b1);
                                st.setText(String.valueOf(st1));
	   		        COMM.setText(String.valueOf(comm2));
			        APP.setText(String.valueOf(app2));	
			        PROGC.setText(String.valueOf(progc2));
              		        EMAT.setText(String.valueOf(emat2));
                                ELE.setText(String.valueOf(ele2));
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
String tru="truncate table Temp1";
              stmt.executeUpdate(tru);  

  }catch(Exception e){}


}

   
private class Closedt3129 extends JFrame implements ActionListener 
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
              AddingMarks302.this.dispose();
              }catch(Exception e){System.err.println(e.getMessage());} 
              
             
            }
    }
 
//SAVE Marks OF STUDENTS
private class SaveDtls3319 extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
              
                  try
                   {



                boolean freeflag = false;             
                  String url = "jdbc:Oracle:thin:@localhost:1521:XE";
                   String CreateString,CreateString1,tru,gl;
			String bs1;
                        int en1,se1,comm1,app1,progc1,ele1,emat1;
			Statement stmt;
                        
                      en1=Integer.parseInt(re.getText());
                      se1=Integer.parseInt(st.getText());
                      comm1=Integer.parseInt(COMM.getText());
                      app1=Integer.parseInt(APP.getText());
                      progc1=Integer.parseInt(PROGC.getText());
                     ele1=Integer.parseInt(ELE.getText());
                     emat1=Integer.parseInt(EMAT.getText());
                      
                      
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
                                                                
                                CreateString="Update ExCO4G set seatno="+se1+",exmpo="+comm1+",exoop="+app1+",excne="+progc1+",excam="+ele1+",exens="+emat1+"where exeno1="+en1;
				
				stmt.executeUpdate(CreateString);
                                  tru="truncate table Temp1";
                                 stmt.executeUpdate(tru);    

                                
                              
                               
                        

                            
                            
                          }catch(Exception e){System.err.println(e.getMessage());
                                                //     JOptionPane.showMessageDialog(SaveDtls3319.this,"         Record of Enrollnment no Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
                                                             
                                                 }    

						
		
//TO CLEAR FIELDS
		if(freeflag == false)
		{
	   		st.setText("");
                        COMM.setText("");
                        APP.setText("");
                        PROGC.setText("");
	   		ELE.setText("");
                        EMAT.setText("");			
	      }
                 
                  }
                catch(Exception e)
                  {
                        JOptionPane.showMessageDialog(SaveDtls3319.this,"       Please Fill the information !","Empty !!!",JOptionPane.WARNING_MESSAGE);
                  }	
  
                if(freeflag == false)
		{
      	   	      st.setText("");
                        COMM.setText("");
                        APP.setText("");
                        PROGC.setText("");
	   		ELE.setText("");
                        EMAT.setText("");
	      }

           }catch(Exception e){System.err.println(e.getMessage());}

         }

        

  }
		 
		  	
   }
            
