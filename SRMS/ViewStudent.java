import java.awt.*;
import java.awt.event.*;
 import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class ViewStudent
{
   public static void main(String arg[])
   {  
    ViewStudent lc=new ViewStudent();
   }
   public ViewStudent()
   {
   	
       AddingStudent2 fram = new AddingStudent2();
      fram.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fram.setResizable (false);
      fram.show();
   }
}

 class AddingStudent2 extends JFrame 
{  
   
 private JTextField EXT,MOT,ENO,SName,Phone,Mobile,Email,Birthdate,Nationality;
   private ButtonGroup group;
   private JTextArea Address;
   private JRadioButton Male,Female;
   private Font font = new Font("Tahoma",Font.BOLD,13);   
   public String url = "oracle.jdbc.OracleDriver";
   public  Connection con;
   public String CreateString;
  public static final int	HAND_CURSOR	= 12;
   
    public AddingStudent2()
   {  
      setTitle("Modify Student Record");
      setSize(1300,800);
	  setResizable(false);

      Container contentPane = getContentPane();

   


      JPanel paneleno=new JPanel();
      JPanel panel1 = new JPanel();
      JPanel panelMot=new JPanel();
      JPanel panel6 = new JPanel();
      JPanel panel2 = new JPanel();
      JPanel panel3 = new JPanel();
      JPanel panel4 = new JPanel();
      JPanel panel5 = new JPanel();
      JPanel panel7 = new JPanel();
      JPanel panel10 = new JPanel();
      
      paneleno.add(new JLabel("Enrollnment No.     "));
      ENO = new JTextField(40);
      paneleno.add(ENO);
      ENO.setToolTipText("E.g. 1112420040");


      panel1.add(new JLabel("Student Full Name     "));
      SName = new JTextField(40);
      panel1.add(SName);
      SName.setFont(font); 
      SName.setToolTipText("E.g.  Mrs. Shubham D. Pagarwar");
      
      panelMot.add(new JLabel("Mother Name     "));
       MOT = new JTextField(16);
      panelMot.add(MOT);
      MOT.setFont(font); 
          	   	   

      panel2.add(new JLabel("Student Address"));     
      
      Address = new JTextArea(3,40);
      panel2.add(Address);
      Address.setFont(font);
      boolean wrap = !Address.getLineWrap();
      Address.setLineWrap(wrap);
	  panel2.add(new JScrollPane(Address));
	  Address.setToolTipText("E.g.  At. Katangtola po.katangi th.+di.Gondia-441601.");   
	
	  
      panel3.add(new JLabel("Phone No.              "));     
      Phone = new JTextField(16);
      panel3.add(Phone);
      Phone.setFont(font);
      Phone.setToolTipText("E.g.  250176");
      
	    
      panel4.add(new JLabel("Mobile No.              "));     
      Mobile = new JTextField(16);
      panel4.add(Mobile);
      Mobile.setFont(font);
      Mobile.setToolTipText("E.g.  7798730162");
	  
      panel5.add(new JLabel("EMail-ID.                  "));     
      Email = new JTextField(16);
       panel5.add(Email);
      Email.setFont(font);
      Email.setToolTipText("E.g.  shubhampagarwar10@gmail.com");
      
	  
      panel6.add(new JLabel("Date of Birth(DD/MM/YY)           "));
      Birthdate = new JTextField(16);
      panel6.add(Birthdate);
      Birthdate.setFont(font);    
      Birthdate.setToolTipText("E.g.  11/03/96");

      panel6.add(new JLabel("     Nationality     "));
      Nationality = new JTextField(15);
      panel6.add(Nationality);
      Nationality.setFont(font);    
      Nationality.setToolTipText("E.g.  Indian");
      
	  panel7.add(new JLabel("Gender                    "));
     Male = new JRadioButton("Male");
    Female = new JRadioButton("Female", true);
      group = new ButtonGroup();
      group.add(Male);
      group.add(Female);
      panel7.add(Male);
      panel7.add(Female);
     
      
      JButton SaveButton1 = new JButton("Save");
      panel10.add(SaveButton1);
      SaveButton1.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton1.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton1.setForeground(color1);
      SaveButton1.addActionListener(new SaveDtls2());
               
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
               AddingStudent2.this.dispose();
            }
         });
      contentPane.add(paneleno);   
      contentPane.add(panel1);
      contentPane.add(panelMot);
      contentPane.add(panel6);
      contentPane.add(panel2);
      contentPane.add(panel3);
      contentPane.add(panel4);   
      contentPane.add(panel5);      
      contentPane.add(panel7);
      contentPane.add(panel10);
      contentPane.setLayout (new GridLayout(15,5));


 
   
                  String url = "jdbc:Oracle:thin:@localhost:1521:XE";
        		Connection con;
			 
                                             
                         String CreateString5,CreateString2,CreateString,CreateString1;
			String Phone1,MOTName,SName1,Address1,Birthdate1,Nationality1,Sex1,Mobile1,Email1;
                        int enroll,en1=00;
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
//Extract Student Record
                           
                               CreateString2="select ENO from Temp";
				
				ResultSet s1=stmt.executeQuery(CreateString2);
                                while(s1.next())
                               {
                                en1=s1.getInt("ENO");
                               }
                                
                                CreateString5="truncate table Temp";
                                stmt.executeUpdate(CreateString5);
                                                
                               CreateString="select enroll, Full, Mot, dob, Nat, pho, mob, Email, Gen, Address from StudentEntry where enroll="+en1;
                               

                                ResultSet s2=stmt.executeQuery(CreateString);
                                while(s2.next())
                              {
                                enroll=s2.getInt("enroll");
                                SName1=s2.getString("Full");
                                MOTName=s2.getString("Mot");
                                Birthdate1=s2.getString("dob");
                                Nationality1=s2.getString("Nat");
                                Phone1=s2.getString("pho");
                                Mobile1=s2.getString("mob");                                  
                                Email1=s2.getString("Email");
                                Sex1=s2.getString("Gen");
                                Address1=s2.getString("Address");
                                
                                
                                 ENO.setText(String.valueOf(enroll));
                                SName.setText(SName1);
                                MOT.setText(MOTName);
	   		        Address.setText(Address1);
			        Birthdate.setText(Birthdate1);	
			        Nationality.setText(Nationality1);
			        Phone.setText(Phone1);
			        Mobile.setText(Mobile1);
			        Email.setText(Email1);	
		
                                if(Sex1.equals("Male"))
                                  Male.setSelected(true);
                                else
                                  Female.setSelected(true);
                               
                               }                                 			         
                               //s1.close();
                              // s2.close();
                            
                          }
                           catch(Exception eb){
                                                    //SName.setText("Data Not Found");
                                                     //  JOptionPane.showMessageDialog(AddingStudent2.this,"         Record of Enrollnment no Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
                                                    //System.err.println(eb.getMessage());  
                                               }    


   


 
     
}
 
//SAVE DETAILS OF STUDENTS
private class SaveDtls2 extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
                 
                  
                      String url = "jdbc:Oracle:thin:@localhost:1521:XE";
        		Connection con;
			 
                                             
                         String CreateString,CreateString1;
			String Phone1,MOTName,SName1,Address1,Birthdate1,Nationality1,Sex1,Mobile1,Email1;
                        int enroll;
			Statement stmt;
			boolean freeflag = false;
                        enroll=Integer.parseInt(ENO.getText());
                        SName1="'"+SName.getText()+"'";
                        MOTName="'"+MOT.getText()+"'";
                        Birthdate1="'"+Birthdate.getText()+"'";
                        Nationality1="'"+Nationality.getText()+"'";
			Address1="'"+Address.getText()+"'";
                        Phone1="'"+Phone.getText()+"'";
                        Mobile1="'"+Mobile.getText()+"'";
                        Email1="'"+Email.getText()+"'";
			
                     

			
			if(Male.isSelected() ==true)
			{
				Sex1="\'Male\'";
			}
			else
			{
				Sex1="\'Female\'";
			}
			
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
//TO INSERT INTO STUDENT DB
                           
                                CreateString="Update StudentEntry set enroll="+enroll+",full="+SName1+",mot="+MOTName+",dob="+Birthdate1+",nat="+Nationality1+",pho="+Phone1+",mob="+Mobile1+",email="+Email1+",gen="+Sex1+",address="+Address1+"where enroll="+enroll;
				
				stmt.executeUpdate(CreateString);

                            
                            
                          }catch(Exception e){
                                                System.err.println(e.getMessage());
                                                        //JOptionPane.showMessageDialog(SaveDtls2.this,"         Record of Enrollnment no Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
                                                 }    

						
		
//TO CLEAR FIELDS
		if(freeflag == false)
		{
	   		ENO.setText("");
                        SName.setText("");
                        MOT.setText("");
	   		Address.setText("");
			Birthdate.setText("");	
			Nationality.setText("");
			Phone.setText("");
			Mobile.setText("");
			Email.setText("");	
			Female.setSelected(true);
			Male.setSelected(false);
	      }
	 
         }

  }
		 
		  	
   }
            
