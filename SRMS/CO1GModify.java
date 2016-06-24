import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class CO1GModify
{
   public static void main(String arg[])
   {  
    CO1GModify g1=new CO1GModify();
   }
   public  CO1GModify()
   {
   	
       AddingMarks3 fn = new AddingMarks3();
      fn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fn.setResizable (false);
      fn.show();
   }
}

 class AddingMarks3 extends JFrame 
{  
    private JTextField st,ENG,PHY,CHE,MAT;
   private JLabel re,gf;
   private ButtonGroup group;
   private JTextArea Address;
   private JRadioButton Male,Female;
   private Font font = new Font("Tahoma",Font.BOLD,17);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
   public static final int	HAND_CURSOR	= 12;
   
   
    public AddingMarks3()
   {  
      setTitle("CO1G External Marks Correction");
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
      st=new JTextField(8);
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
      SaveButton.addActionListener(new SaveDtls33());
               
               
                          
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(color1);
     CloseButton.addActionListener(new  Closedt3());
        
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

         


       
                  String url1 = "jdbc:Oracle:thin:@localhost:1521:XE";
        		Connection con1;
			 
                                             
                         String sql1,sql2,sql3,sql4;
			String b1;
                        int e1,st1,eng2,phy2,chy2,mat2;
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
                           
                                                     
                               sql1="select exeno,brs,seatno,exenglish,exphysics,exchemistry,exmath from ExCO1G where exeno="+Integer.parseInt(re.getText());
                               
 
                                ResultSet se2=stmt1.executeQuery(sql1);
                                while(se2.next())
                              {
                                e1=se2.getInt("exeno");
                                b1=se2.getString("brs");
                                st1=se2.getInt("seatno"); 
                                eng2=se2.getInt("exenglish"); 
                                phy2=se2.getInt("exphysics");
                                chy2=se2.getInt("exchemistry");
                                mat2=se2.getInt("exmath");
                                                                  
                                
                                 re.setText(String.valueOf(e1));
                                gf.setText(b1);
                                st.setText(String.valueOf(st1));
	   		        ENG.setText(String.valueOf(eng2));
			        PHY.setText(String.valueOf(phy2));	
			        CHE.setText(String.valueOf(chy2));
			        MAT.setText(String.valueOf(mat2));
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

   
private class Closedt3 extends JFrame implements ActionListener 
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
              AddingMarks3.this.dispose();
              }catch(Exception e){System.err.println(e.getMessage());} 
              
             
            }
    }
 
//SAVE Marks OF STUDENTS
private class SaveDtls33 extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
              
                  try
                   {



                boolean freeflag = false;             
                  String url = "jdbc:Oracle:thin:@localhost:1521:XE";
                   String CreateString,CreateString1,tru,gl;
			String bs1;
                        int en1,se1,eng1,phy1,che1,mat1;
			Statement stmt;
                        
                      en1=Integer.parseInt(re.getText());
                      se1=Integer.parseInt(st.getText());
                      eng1=Integer.parseInt(ENG.getText());
                      phy1=Integer.parseInt(PHY.getText());
                      che1=Integer.parseInt(CHE.getText());
                      mat1=Integer.parseInt(MAT.getText());
                      
                      
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
                                                                
                                CreateString="Update ExCO1G set seatno="+se1+",exenglish="+eng1+",exphysics="+phy1+",exchemistry="+che1+",exmath="+mat1+"where exeno="+en1;
				
				stmt.executeUpdate(CreateString);
                                  tru="truncate table Temp1";
                                 stmt.executeUpdate(tru);    

                                
                              
                               
                        

                            
                            
                          }catch(Exception e){
                                                    JOptionPane.showMessageDialog(SaveDtls33.this,"         Record of Enrollnment no Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
                            
                                                 }    

						
		
//TO CLEAR FIELDS
		if(freeflag == false)
		{
	   		st.setText("");
                        ENG.setText("");
                        PHY.setText("");
                        CHE.setText("");
	   		MAT.setText("");
			
	      }
                 
                  }
                catch(Exception e)
                  {
                        JOptionPane.showMessageDialog(SaveDtls33.this,"       Please Fill the information !","Empty !!!",JOptionPane.WARNING_MESSAGE);
                  }	
  
                if(freeflag == false)
		{
      	   	        st.setText("");
                 	ENG.setText("");
                        PHY.setText("");
                        CHE.setText("");
	   		MAT.setText("");
	      }

           }catch(Exception e){System.err.println(e.getMessage());}

         }

        

  }
		 
		  	
   }
            
