import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class AddStudent
{
   public static void main(String arg[])
   {  
    AddStudent ac=new AddStudent();
   }
   public AddStudent()
   {
   	
       AddingStudent frame = new AddingStudent();
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setResizable (false);
      frame.show();
   }
}

 class AddingStudent extends JFrame 
{  
   
   
    public AddingStudent()
   {  
      setTitle("Student Record");
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
     
      
            JButton SaveButton = new JButton("Save");
      panel10.add(SaveButton);
      SaveButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      SaveButton.setCursor(Pen1);
      Color color1 = new Color(0,0,255);
      SaveButton.setForeground(color1);
      SaveButton.addActionListener(new SaveDtls());
               
               
                          
      
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
               AddingStudent.this.dispose();
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
   }

   private JTextField EXT,MOT,ENO,SName,Phone,Mobile,Email,Birthdate,Nationality;
   private ButtonGroup group;
   private JTextArea Address;
   private JRadioButton Male,Female;
   private Font font = new Font("Tahoma",Font.BOLD,13);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
  public static final int	HAND_CURSOR	= 12;

 
     
 
//SAVE DETAILS OF STUDENTS
private class SaveDtls extends JFrame implements ActionListener 
 {
		public void actionPerformed(ActionEvent event)
		{
                 
                    boolean freeflag = false;             
                  String url = "jdbc:Oracle:thin:@localhost:1521:XE";
                   String CreateString,CreateString1;
			String Phone1,MOTName,SName1,Address1,Birthdate1,Nationality1,Passport1,Sex1,Mobile1,Email1;
                        int enroll;
			Statement stmt;
		Connection con;
		try
                {	 
                        
                        
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
                           
                                CreateString="INSERT INTO StudentEntry VALUES("+enroll+","+SName1+","+MOTName+","+Birthdate1+","+Nationality1+","+Phone1+","+Mobile1+","+Email1+","+Sex1+","+Address1+")";
				
				stmt.executeUpdate(CreateString);

                            
                            
                          }catch(Exception e){
                                                
                                                        JOptionPane.showMessageDialog(SaveDtls.this,"         Record of Enrollnment no Already Exist !","Duplicate !!!",JOptionPane.WARNING_MESSAGE);
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
                catch(Exception e)
                  {
                        JOptionPane.showMessageDialog(SaveDtls.this,"       Please Fill the information !","Empty !!!",JOptionPane.WARNING_MESSAGE);
                  }	
  
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
            
