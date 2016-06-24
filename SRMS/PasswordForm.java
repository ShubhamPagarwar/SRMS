import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PasswordForm
{
   public static void main(String arg[])
   {  
    PasswordForm ac=new PasswordForm();
   }
   public PasswordForm()
   {
   	  PassForm frame = new PassForm();
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setResizable (false);
      frame.show();
   }
}

class PassForm extends JFrame 
{  
   public PassForm()
   {  
   
      setTitle("Password");
      setSize(WIDTH, HEIGHT);
	  setResizable(false);

      Container contentPane = getContentPane();

      JPanel panel1 = new JPanel();
      JPanel panel2 = new JPanel();
      JPanel panel3 = new JPanel();
      
      JLabel j1 = new JLabel("User Name");
      j1.setForeground(Color.lightGray);
      panel1.add(j1);
      UserName = new JTextField(15);
      panel1.add(UserName);
      UserName.setFont(font);   
      UserName.setText ("      GP GONDIA");
      UserName.setEnabled (false);
      
      JLabel j2 = new JLabel("                Password");
      j2.setForeground(Color.lightGray);
      panel1.add(j2);
      Password = new JPasswordField(15);
      panel1.add(Password);
      Password.setFont(font);  
      Password.addActionListener (new RightAction()) ;
      panel1.setBackground(Color.black);      
	  ImageIcon ii = new ImageIcon("stork.gif");
	  JLabel jl = new JLabel(ii);
	  panel1.add(jl);
	  
	  ImageIcon i = new ImageIcon("password-security-300x243.jpg");
	  JLabel j = new JLabel(i);
	  panel1.add(j);
			
      JButton OkButton = new JButton("Ok");
      panel1.add(OkButton);
      OkButton.setFont(font);
      OkButton.addActionListener(new RightAction());
      OkButton.setCursor(Pen);
      OkButton.setForeground(color);
            
      JButton CancelButton = new JButton("Cancel");
      panel1.add(CancelButton);
      CancelButton.setFont(font);
      CancelButton.setCursor(Pen);
      CancelButton.setForeground(color);
      CancelButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               System.exit(0);
            }
         });

      contentPane.add(panel1);
      contentPane.setLayout (new GridLayout(1,1));
    } 
   public static final int WIDTH = 800;
   public static final int HEIGHT = 600;
   public static  String DriverName="Shubham";
   public static  String Pass="shubhamp";
   
   private JTextField UserName;
   private JPasswordField Password;
   private Font font = new Font("Tahoma",Font.BOLD,13);   
   Cursor Pen = new Cursor(HAND_CURSOR);
   Color color = new Color(0,0,255);
   public static final int	HAND_CURSOR	= 12;
   
   private class RightAction implements ActionListener
   {
            public void actionPerformed(ActionEvent event)
            {
            	
		      	String Pass=Password.getText ();
		      	if(Pass.equalsIgnoreCase("gpg2014"))
		      	{
		      		MainMenu ac=new MainMenu();	
		      		PassForm.this.dispose();
		      	}
		      	else
		      	{
		      		JOptionPane.showMessageDialog(PassForm.this,"         Please try Again !","Invalid Password !!!",JOptionPane.WARNING_MESSAGE);
		      	}
            }
    }
}
