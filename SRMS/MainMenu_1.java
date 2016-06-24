import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;

public class MainMenu
{
   public static void main(String arg[])
   {  
    MainMenu ac=new MainMenu();
   }
   public MainMenu()
   {
   	  MainMenuForm frame = new MainMenuForm();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable (false);
      frame.show();
       }
}

class MainMenuForm extends JFrame 
{  
   public MainMenuForm()
   {
      setTitle("*** Student Record Management System ***");
      setSize(WIDTH,HEIGHT);
	  ImageIcon ii = new ImageIcon("logo.gif");
	  JLabel jl = new JLabel("", ii, JLabel.CENTER);
          
	  getContentPane().add(jl);
          
            
JMenuBar mbar = new JMenuBar();
      setJMenuBar(mbar);
       getContentPane().setBackground(new Color(255,200,150));

      
/// 1ST MENU : STUDENT
      JMenu StudentMenu = new JMenu("Admission of an Student");
      StudentMenu.setToolTipText("Adding,Removing,Modifying Student Details");
      mbar.add(StudentMenu);
      
/// 1.1 New Student Record
      JMenuItem StudentSubMenu = new JMenuItem("New Student Record");
      StudentMenu.add(StudentSubMenu);
      StudentSubMenu.addActionListener(new ActionListener()
      {
	      public void actionPerformed(ActionEvent event)
	      {
			      	AddStudent ac=new AddStudent();	
	      }
      }
      );
///1.2 Remove Student Record          
      JMenu SremoveMenu = new JMenu("Remove Student Record");
      StudentMenu.add(SremoveMenu);
      ///1.2.1 Remove all
      JMenuItem SRemoveallItem = new JMenuItem("Remove all");
      SremoveMenu.add(SRemoveallItem);
      SremoveMenu.addSeparator();
      SRemoveallItem.addActionListener(new ActionListener()
      {
	      public void actionPerformed(ActionEvent event)
	      {
			      	RemoveAll ra=new RemoveAll();	
	      }
      }
      );          
     ///1.2.2 Remove One
      JMenuItem SRemoveoneItem = new JMenuItem("Remove One");
      SremoveMenu.add(SRemoveoneItem);
      SremoveMenu.addSeparator();
      SRemoveoneItem.addActionListener(new ActionListener()
      {
	      public void actionPerformed(ActionEvent event)
	      {
			     	RemoveOne ll=new RemoveOne();	
	      }
      }
      );

     StudentMenu.addSeparator();

  
///1.3 Modify Student Record          
      JMenuItem SmodifyItem = new JMenuItem("Modify Student Record");
      StudentMenu.add(SmodifyItem);
      SmodifyItem.addActionListener(new ActionListener()
      {
	      public void actionPerformed(ActionEvent event)
	      {
			      	View ld=new View();	
	      }
      }
      );        
      
      
/// 1.4 : THE EXIT ITEM EXITS THE PROGRAM
      JMenuItem exitItem = new JMenuItem("Exit");
      exitItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {System.exit(0);}
         });
      StudentMenu.add(exitItem);
      exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
      exitItem.setMnemonic('X');
      
/// 2ND MENU : External marks of an Student   
      JMenu ExternalMenu = new JMenu("External marks of an Student");
      ExternalMenu.setToolTipText("Depends to wrriten Examination with oral and Practical Marks");
      mbar.add(ExternalMenu);
  
///2.1 Click 
      JMenuItem SclickItem = new JMenuItem("Click");
      ExternalMenu.add(SclickItem);
      SclickItem.addActionListener(new ActionListener()
      {
	      public void actionPerformed(ActionEvent event)
	      {
			      	ExternalMarks lm=new ExternalMarks();
	      }
      }
      );      
      
      
/// 2.2 : THE EXIT ITEM EXITS THE PROGRAM
      JMenuItem exitItem1 = new JMenuItem("Exit");
      exitItem1.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {System.exit(0);}
         });
      ExternalMenu.add(exitItem1);
      exitItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
      exitItem1.setMnemonic('X');
   
            
                  
/// 3RD MENU : Internal Marks of an Student
      JMenu InternalMenu = new JMenu("Internal Marks of an Student");
      InternalMenu.setToolTipText("All the termwork and skill test marks");
      mbar.add(InternalMenu);
  
///3.1 Click 
      JMenuItem Sclick1Item = new JMenuItem("Click");
      InternalMenu.add(Sclick1Item);
      Sclick1Item.addActionListener(new ActionListener()
      {
	      public void actionPerformed(ActionEvent event)
	      {
			      	InternalMarks im=new InternalMarks();	
	      }
      }
      );      
      
      
/// 3.2 : THE EXIT ITEM EXITS THE PROGRAM
      JMenuItem exitItem2 = new JMenuItem("Exit");
      exitItem2.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {System.exit(0);}
         });
      InternalMenu.add(exitItem2);
      exitItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
      exitItem2.setMnemonic('X');



/// 5TH MENU : Report Generation of an Student
      JMenu ReportMenu = new JMenu("Report Generation of an Student");
      ReportMenu.setToolTipText("Report generated of an Student in the form of Marksheet");
      mbar.add(ReportMenu);
 

/// 5.1 : Click
      JMenuItem Click2Menu = new JMenuItem("Click");
	  ReportMenu.add(Click2Menu);
      Click2Menu.addActionListener(new ActionListener()
      {
	      public void actionPerformed(ActionEvent event)
	      {
               MenuReport mj5=new MenuReport();
	      }
      }
      );   
 
 /// 5.2 : THE EXIT ITEM EXITS THE PROGRAM
      JMenuItem exitItem4 = new JMenuItem("Exit");
      exitItem4.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {System.exit(0);}
         });
      ReportMenu.add(exitItem4);
      exitItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
      exitItem4.setMnemonic('X');
/// 6TH MENU : HELP
      JMenu HelpMenu = new JMenu("Help");
      mbar.add(HelpMenu);
 

/// 6.1 : ABOUT      
      JMenuItem AboutItem = new JMenuItem("About");
      AboutItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               if (dialog == null) 
                  dialog = new AboutDialog(MainMenuForm.this);   
               dialog.show(); 
            }
         });
	  HelpMenu.add(AboutItem);
      AboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
      AboutItem.setMnemonic('A');
      HelpMenu.addSeparator();

/// 6.2 : Show All Enrollnment no.      
      JMenuItem ENItem = new JMenuItem("Show All Enrollnment no.");
      ENItem.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               All a=new All();
            }
         });
	  HelpMenu.add(ENItem);
      ENItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
      ENItem.setMnemonic('E');
      HelpMenu.addSeparator();

   }

   public static final int WIDTH = 1300;
   public static final int HEIGHT = 800;  
   private AboutDialog dialog;
   private AboutDialog1 dialog1;
   private AboutDialog5 dialog2;
}


// FLUSH STUDENT
class AboutDialog5 extends JDialog
{  
   public AboutDialog5(JFrame owner)
   {  
      super(owner, "Delete a Student", true);         
      Container contentPane = getContentPane();
      JPanel panel1 = new JPanel();
      contentPane.add(panel1);     
      JPanel panel2 = new JPanel();
      contentPane.add(panel2);      
      JPanel panel3 = new JPanel();
      contentPane.add(panel3);      
      contentPane.setLayout (new GridLayout(3,2));
      
      ImageIcon i = new ImageIcon("QuestionStud.jpg");
	  JLabel Logo = new JLabel("", i, JLabel.CENTER);
      panel1.add(Logo);    
      
      panel2.add(new JLabel("Student Name "));
      SName = new JComboBox();
      panel2.add(SName);
      SName.setFont(f1);     
      SName.setToolTipText("Select a Student");
      SName.addActionListener(new ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
            		Studname1 = SName.getSelectedItem();
            		Studname = Studname1.toString();
            }
         });
         
       try
       {
	        Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
	        String url = "jdbc:odbc:CollegePlacement";
	        String sname[]=new String[100];
	        int k=0,j;
	        Connection con = DriverManager.getConnection(url);
	
	        Statement stmt = con.createStatement();
	
	        String sqlselect = 
	        " SELECT StudName " + 
	        " FROM Student; ";
			
	        ResultSet rs = stmt.executeQuery(sqlselect);
			
	        while(rs.next()) 
	        {
               sname[k]=rs.getString (1);
	           k++;
	        }
	        con.close();
	        
	        j=k;
	        for(k=0;k<j;k++)
	        {
	        	SName.addItem (sname[k]);
	        }
        }
	    catch(Exception e)
	    {
	         System.out.println(e.getMessage());
	    }

        
      Color color=new Color(202,228,255);
      panel1.setBackground (Color.blue);
      panel2.setBackground (Color.blue);
      panel3.setBackground (Color.blue);
      JButton Yes = new JButton("Yes");
   	  Cursor Pen = new Cursor(HAND_CURSOR);
      Yes.setCursor(Pen);
      JButton No = new JButton("No");
      No.setCursor(Pen);
      Yes.addActionListener(new 
         ActionListener() 
         {  
            public void actionPerformed(ActionEvent evt) 
            { 
                    Connection con1;	
				    Statement stmt1;
				    String CreateString;
				    
					try 
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					} 
					catch(java.lang.ClassNotFoundException e) 
					{
						System.err.print("ClassNotFoundException: "); 
						System.err.println(e.getMessage());
					}
					
					try 
					{
						con1 = DriverManager.getConnection(url);
						stmt1 = con1.createStatement();					
						int rollno = 0;
				        
						CreateString =
						" SELECT RollNo " +
						" FROM Student " +
						" WHERE StudName = '" + Studname + "';";
 						
						ResultSet rs11 = stmt1.executeQuery(CreateString);	
				        while(rs11.next()) 
				        {
			               rollno = rs11.getInt(1);
				        }	
						
						CreateString =
						" DELETE * FROM Student WHERE RollNo = " + rollno + ";";
						stmt1.executeUpdate(CreateString);

						CreateString =
						" DELETE * FROM StudentLanguage WHERE RollNo = " + rollno + ";";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentMail WHERE RollNo = " + rollno + ";";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentPhone WHERE RollNo = " + rollno + ";";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentQualification WHERE RollNo = " + rollno + ";";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentSkill WHERE RollNo = " + rollno + ";";
						stmt1.executeUpdate(CreateString);
						
						con1.close();
					} 
					catch(SQLException ex) 
					{
						System.err.println("SQLException: " + ex.getMessage());
					} 
               		SName.removeItem(Studname1);
		      		setVisible(false); 
            } 
         });      
      panel3.add(Yes);
      Yes.setBackground (color);
      Yes.setForeground (Color.red);
      No.addActionListener(new 
         ActionListener() 
         {  
            public void actionPerformed(ActionEvent evt) 
            { 
               setVisible(false); 
            } 
         });      
      panel3.add(No);
      No.setBackground (color);
      No.setForeground (Color.red);
      setSize(300, 200);
      setLocation(20,60);
   }
   private Font f1 = new Font("Tahoma",Font.BOLD,13);   
   private JComboBox SName;
   public String url = "jdbc:odbc:CollegePlacement";
   public Connection con;
   public String Studname;
   public Object Studname1;
   public static final int	HAND_CURSOR	= 12;
}


// FLUSH ALL
class AboutDialog1 extends JDialog
{  
   public AboutDialog1(JFrame owner)
   {  
      super(owner, "Flush All Information", true);         
      Container contentPane = getContentPane();
      JPanel panel1 = new JPanel();
      contentPane.add(panel1);     
      JPanel panel2 = new JPanel();
      contentPane.add(panel2);      
      JPanel panel3 = new JPanel();
      contentPane.add(panel3);      
      contentPane.setLayout (new GridLayout(3,2));
      
      ImageIcon i = new ImageIcon("Question.jpg");
	  JLabel Logo = new JLabel("", i, JLabel.CENTER);
      panel1.add(Logo);    
      
      panel2.add(new JLabel("Password "));
      Password = new JPasswordField(10);
      panel2.add(Password);
      Password.setFont(f1);  
      Password.setToolTipText("Write the Password & Click on 'Yes'. ");
        
      Color color=new Color(202,228,255);
      panel1.setBackground (color);
      panel2.setBackground (color);
      panel3.setBackground (color);
      JButton Yes = new JButton("Yes");
   	  Cursor Pen = new Cursor(HAND_CURSOR);
      Yes.setCursor(Pen);
      JButton No = new JButton("No");
      No.setCursor(Pen);
      Yes.addActionListener(new 
         ActionListener() 
         {  
            public void actionPerformed(ActionEvent evt) 
            { 
            	String password=Password.getText ();
            	if(password.equals("flushall"))
		      	{
                    Connection con1;	
				    Statement stmt1;
				    String CreateString;
				    
					try 
					{
						Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
					} 
					catch(java.lang.ClassNotFoundException e) 
					{
						System.err.print("ClassNotFoundException: "); 
						System.err.println(e.getMessage());
					}
					
					try 
					{
						con1 = DriverManager.getConnection(url);
						stmt1 = con1.createStatement();
				        
						CreateString =
						" DELETE * FROM Conversation;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM Placement;";
						stmt1.executeUpdate(CreateString);

						CreateString =
						" DELETE * FROM RemindMe;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM Shortlist;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM Student;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentLanguage;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentMail;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentPhone;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentQualification;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM StudentSkill;";
						stmt1.executeUpdate(CreateString);
						
						CreateString =
						" DELETE * FROM Test;";
						stmt1.executeUpdate(CreateString);

						con1.close();
					} 
					catch(SQLException ex) 
					{
						System.err.println("SQLException: " + ex.getMessage());
					} 
		      		setVisible(false); 
		      		Password.setText("");
		      	}
		      	else
		      	{
		      		JOptionPane.showMessageDialog(AboutDialog1.this,"         Please Try Again !","Invalid Password !!!",JOptionPane.WARNING_MESSAGE);
		      		Password.setText("");
		      	}
            } 
         });      
      panel3.add(Yes);
      Yes.setBackground (color);
      Yes.setForeground (Color.red);
      No.addActionListener(new 
         ActionListener() 
         {  
            public void actionPerformed(ActionEvent evt) 
            { 
               setVisible(false); 
               Password.setText("");
            } 
         });      
      panel3.add(No);
      No.setBackground (color);
      No.setForeground (Color.red);
      setSize(500, 300);
      setLocation(20,60);
   }
   private Font f1 = new Font("Tahoma",Font.BOLD,13);   
   private JPasswordField Password;
   public String url = "jdbc:odbc:CollegePlacement";
   public Connection con;
   public static final int	HAND_CURSOR	= 12;
}

//ABOUT SOFTWARE
class AboutDialog extends JDialog
{  
   public AboutDialog(JFrame owner)
   {  
      super(owner, "About Student Record Management System", true);         
      Container contentPane = getContentPane();
      JPanel panel1 = new JPanel();
      contentPane.add(panel1);      
      JPanel panel2 = new JPanel();      
      contentPane.add(panel2);  
      JPanel panel3 = new JPanel();
      contentPane.add(panel3);      
      contentPane.setLayout (new GridLayout(3,2));
      ImageIcon i = new ImageIcon("Flow1.gif");
	  JLabel Logo = new JLabel("", i, JLabel.CENTER);
      JLabel Heading=new JLabel("Student Record Management System",JLabel.CENTER);
      JLabel Credit=new JLabel("By : Shubham , Arvind , Rajni, Nikki",JLabel.CENTER);      
      panel1.add(Logo);      
      panel2.add(Heading);
      panel3.add(Credit);
      Heading.setFont (f1);
      Credit.setFont (f2);
      Color color=new Color(202,228,255);
      Heading.setForeground (Color.red);
      panel1.setBackground (Color.green);
      Credit.setForeground (Color.blue);
      panel2.setBackground (Color.green);
      panel3.setBackground (Color.green);
      JButton ok = new JButton("Ok");
   	  Cursor Pen1 = new Cursor(HAND_CURSOR);
      ok.setCursor(Pen1);
      ok.addActionListener(new 
         ActionListener() 
         {  
            public void actionPerformed(ActionEvent evt) 
            { 
               setVisible(false); 
            } 
         });      
      panel3.add(ok);
      ok.setBackground (color);
      ok.setForeground (Color.red);
      setSize(800, 500);
      setLocation(20,60);
   }
   private Font f1 = new Font("Tahoma",Font.BOLD,22);   
   private Font f2 = new Font("Arial",Font.BOLD,14);   
   public static final int	HAND_CURSOR	= 12;
}