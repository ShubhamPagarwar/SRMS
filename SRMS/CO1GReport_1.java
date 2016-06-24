import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import java.sql.*;

public class CO1GReport
{
   public static void main(String arg[])
   {  
    CO1GReport r1=new CO1GReport();
   }
   public  CO1GReport()
   {
   	
       AddingMarkr1 fn = new AddingMarkr1();
      fn.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      fn.setResizable (false);
      fn.show();
   }
}

 class AddingMarkr1 extends JFrame //implements Runnable
{  
    private JTextField ENG,PHY,CHE,MAT,ENO;
   private JLabel re,gf,st;
      private JTable table;
   private JScrollPane jsp ;

   private ButtonGroup group;
   private JTextArea Address;
   private JRadioButton Male,Female;
   private Font font = new Font("Tahoma",Font.BOLD,17);   
   public String url = "jdbc:Oracle:thin:@localhost:1521:XE";
   public  Connection con;
   public String CreateString;
   public static final int	HAND_CURSOR	= 12;
   
   
    public AddingMarkr1()
   {  
      setTitle("CO1GReport Generation");
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
 
                           String Bran,fname,sd,sg,sh,sj;
                            int enroll,ss,s1ex,s2ex,s3ex,s4ex,si5,si6,si7,si8,si9,si10,si11,si12,si13;
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
                                 sd="select * from ExCO1G where exeno="+enroll;
                                    ResultSet rs5=stmt.executeQuery(sd); 
                                   while(rs5.next())
                                    {
                                              s1ex=rs5.getInt("exEnglish");                                      
                                              s2ex=rs5.getInt("exPhysics");                                      
                                              s3ex=rs5.getInt("exChemistry");                                      
                                              s4ex=rs5.getInt("exMath");
                                  sg="select * from InCO1G where en="+enroll;
                                    ResultSet rs6=stmt.executeQuery(sg); 
                                   while(rs6.next())
                                    {
                                              si5=rs6.getInt("etw");                                      
                                              si6=rs6.getInt("ptw");                                      
                                              si7=rs6.getInt("ctw");                                      
                                              si8=rs6.getInt("cmfw");
                                              si9=rs6.getInt("wpitw");                                      
                                              si10=rs6.getInt("cft");                                      
                                              si11=rs6.getInt("egp");                                      
                                              si12=rs6.getInt("egt");
                                              si13=rs6.getInt("sw");                                      
                                                                                
                                     
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
      JPanel panel8 = new JPanel();
      JPanel panel9 = new JPanel();
      JPanel panel10 = new JPanel();
      JPanel panel11 = new JPanel();
      JPanel panel12 = new JPanel();
      JPanel panel13= new JPanel();
      JPanel panel14= new JPanel();
      JPanel panel15= new JPanel();
      JPanel panel16= new JPanel();
                       
      
						

            
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
          	   	   
        String sm="Select Seatno from ExCO1G where exeno="+enroll;
           ResultSet rs2=stmt.executeQuery(sm);
            while(rs2.next())
          {
                ss=rs2.getInt("Seatno");
                                                          
      JLabel nh=new JLabel("Seat No.=");
      nh.setFont(new Font("Tahoma",Font.BOLD,17));
      panelseat.add(nh);     
      st=new JLabel(String.valueOf(ss));
      st.setFont(new Font("Tahoma",Font.BOLD,17));
      panelseat.add(st);
         }

    JLabel ls=new JLabel("Title of Subject                                  Subject head                  Max. Marks                 Marks Obtained");
      ls.setFont(new Font("Tahoma",Font.BOLD,17));
       ls.setForeground(Color.red);     
      label.add(ls);	
    
      JLabel s1=new JLabel("English                                              TH                                   100                                             "+s1ex);
      s1.setFont(font);  
      panel3.add(s1);
       
     JLabel s2=new JLabel("                                                          TW                                   25                                              "+si5);
      s2.setFont(font);  
      panel4.add(s2);     
     
     JLabel s3=new JLabel("Basic Science                                   TH                                   100                                            "+(s2ex+s3ex));
      s3.setFont(font);  
      panel5.add(s3);     
     
      JLabel s4=new JLabel("                                                          PR                                    50                                             "+(si6+si7));
      s4.setFont(font);  
      panel6.add(s4);     
    
     JLabel s5=new JLabel("Basic Mathematics                            TH                                   100                                           "+s4ex);
      s5.setFont(font);  
      panel7.add(s5);     
    
     JLabel s6=new JLabel("Engineering Graphics                      PR                                    50                                             "+si11);
      s6.setFont(font);  
      panel8.add(s6);     
     
      JLabel s7=new JLabel("                                                           TW                                   50                                             "+si12);
      s7.setFont(font);  
      panel9.add(s7);     
     
      JLabel s8=new JLabel("Computer Fundamental                   PR                                    50                                             "+si7);
      s8.setFont(font);  
      panel11.add(s8);     
     
      JLabel s9=new JLabel("                                                            TW                                   25                                             "+si8);
      s9.setFont(font);  
      panel12.add(s9); 
    
      JLabel s10=new JLabel("Basic Workshop Practice                  TW                                   50                                             "+si9);
      s10.setFont(font);  
      panel13.add(s10); 
     
      JLabel s11=new JLabel("Sessional                                            SW                                   50                                             "+si13);
      s11.setFont(font);  
      panel14.add(s11); 
     
      JLabel s12=new JLabel("Total Marks  :                                                                650                                   "+(s1ex+s2ex+s3ex+s4ex+si5+si6+si7+si8+si9+si10+si11+si12+si13));
      s12.setFont(new Font("Arial",Font.BOLD,20)); 
      s12.setForeground(Color.blue);
      panel15.add(s12); 
     
      JLabel s13=new JLabel("Percentage  :        "+((float)(s1ex+s2ex+s3ex+s4ex+si5+si6+si7+si8+si9+si10+si11+si12+si13)/650)*100);
      s13.setFont(new Font("Arial",Font.BOLD,20)); 
      s13.setForeground(Color.blue); 
      panel16.add(s13); 
               
                             
      
      JButton CloseButton = new JButton("Close");
      panel10.add(CloseButton);
      CloseButton.setFont(font);
      Cursor Pen1 = new Cursor(HAND_CURSOR);
      CloseButton.setCursor(Pen1);
      CloseButton.setForeground(Color.blue);
     CloseButton.addActionListener(new  Closedtr1());

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
      contentPane.add(panel8);
      contentPane.add(panel9);
      contentPane.add(panel11);
      contentPane.add(panel12);
      contentPane.add(panel13);
      contentPane.add(panel14);
      contentPane.add(panel15);
      contentPane.add(panel16);
      contentPane.add(panel10);
       contentPane.setLayout (new GridLayout(28,20));

         String tru="truncate table T";
              stmt.executeUpdate(tru);  
}
}
}
}
  }catch(Exception e){}
                 
 }

   
private class Closedtr1 extends JFrame implements ActionListener 
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
              AddingMarkr1.this.dispose();
              }catch(Exception e){System.err.println(e.getMessage());} 
              
             
            }
    }
 

		 
		  	
   }
            
