/// Student Record Management System by Shubham,Arvind,Nikki,Rajni

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

public class StartProject 
{	
   public static void main(String[] args)
   {  
     StartProject sp=new StartProject();
   }
   public StartProject()
   {
      StartingProject frame = new StartingProject();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setResizable (false);
      frame.show();

   }
}
	
class StartingProject extends JFrame
{
	public StartingProject()
	{
      setTitle("Student Record ManageMent System");
      setSize(WIDTH,HEIGHT);
      
		Container container=getContentPane();
        container.setLayout (new GridLayout(1,1));
        JPanel panel1 = new JPanel();
        container.add(panel1);
        panel1.setBackground(new Color(230,170,210));
        
        Dimension  Prefer=new Dimension(775,22);
        Processing.setPreferredSize (Prefer);
		Processing.setMinimum(1);
		Processing.setMaximum(1000);
		Processing.setOrientation(JProgressBar.HORIZONTAL);
		
		Processing.setForeground(new Color(0,255,0));
		
			ImageIcon ii = new ImageIcon("20130815_064126.jpg");
			JLabel Picture = new JLabel(ii);
			panel1.add(Picture);
			panel1.add(Processing);
			panel1.add(On);
			Processing.setStringPainted(true);
			On.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
				    if(timer == null) 
				    {
				    	timer = new javax.swing.Timer(18, createAction());
		    			timer.start();
		    		}
				}
			});
			
			panel1.add(Off);
			Off.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					System.exit (0);
				}
			});
	    On.setCursor(Pen);
        On.setForeground(Color.red);
        Off.setForeground(Color.red);
	    Off.setCursor(Pen);
		}

	    public static final int WIDTH = 1300;
   		public static final int HEIGHT = 800;  
		private JProgressBar Processing=new JProgressBar();
		private JButton On=new JButton("LOG IN");
		private JButton Off=new JButton("LOG Off");
	    Cursor Pen = new Cursor(HAND_CURSOR);
		private javax.swing.Timer timer;
        
		public static final int	HAND_CURSOR	= 12;
		
	public Action createAction() 
    {
		return new AbstractAction("") 
		{
		    public void actionPerformed (ActionEvent e) 
		    {
				if(Processing.getValue() < Processing.getMaximum()) 
				{
				    Processing.setValue(Processing.getValue() + 10);
				} 
				else 
				{
				    if(timer != null) 
				    {
					timer.stop();
					timer = null;
                                         SRMS19 s19=new SRMS19();
					StartingProject.this.dispose();
				    }
				}
		    }
		};
    }
}