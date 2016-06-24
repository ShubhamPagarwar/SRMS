/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Component;
import java.awt.*;
import java.io.*;
import java.sql.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.*;



public class Main  extends JFrame implements ActionListener,ChangeListener,Runnable
{
      JPanel p3;
      JSlider s;
       JButton b,pause,resume,stop,close;
       JFileChooser fc;
       MenuBar m;
       Menu file,visual;
       MenuItem open,circle,ball,wave;
       static String name;
       File tf,of;
       JLabel l1,l2,l3,l4;
       InputStream fi;
       Thread t1=new Thread(this);
         ;
        int NOTSTARTED = 0, PLAYING = 1,PAUSED = 2,FINISHED = 3;

    // the player actually doing all the work
     Player player;
    // locking object used to communicate with player thread
     Object playerLock = new Object();

    // status variable what player thread is doing/supposed to do
     int playerStatus = NOTSTARTED;

    public Main(){
        m=new MenuBar();
        file=new Menu("file");
        visual=new Menu("Visualizer");
        open=new MenuItem("Open");
        circle=new MenuItem("Circle");
        ball=new MenuItem("ball");
        wave=new MenuItem("Wave");
       name="D:/Music/Silent song/suno.mp3";
        ImageIcon i1=new ImageIcon("wave.jpg");
        p3=new JPanel();
        l3=new JLabel("Shubham Pagarwar");
        l1=new JLabel("Dazzler MP3 Player");
        l1.setFont(new Font("Algerian",Font.BOLD+Font.ITALIC,30));
        l2=new JLabel(i1);
        l4=new JLabel("Volume");
        b= new JButton("Play");
         s=new JSlider(JSlider.VERTICAL, 0,100,20);
         s.setMajorTickSpacing(50);
         s.setPaintTicks(true);
         pause= new JButton("Pause");
         resume= new JButton("Resume");
         stop= new JButton("stop");
         close= new JButton("close");
         fc = new JFileChooser();
         fc.setFileSelectionMode(JFileChooser.FILES_ONLY);

         open.addActionListener(this);
         //circle.addActionListener(this);
         //ball.addActionListener(this);
         //wave.addActionListener(this);
         b.addActionListener(this);
         pause.addActionListener(this);
         resume.addActionListener(this);
         stop.addActionListener(this);
         close.addActionListener(this);
         s.addChangeListener(this);
             
         p3.add(l1);
         p3.add(l2); 
         p3.add(b);
        
         file.add(open);
         visual.add(circle);
         visual.add(ball);
         visual.add(wave);
         m.add(file);
         m.add(visual);
         
         
         p3.add(pause);
         p3.add(resume);
         p3.add(stop);
         p3.add(close);
         p3.add(l3);
         p3.add(s);
         p3.add(l4);
         p3.setBackground(new Color(150,140,150));
         
         
         getContentPane().add(p3);
         setMenuBar(m);
         t1.start();
    }
  public void run()
  {
       try{
            while(true)
            {
                 l1.setForeground(Color.RED);
                 t1.sleep(500);
                 l1.setForeground(Color.BLUE);
                 t1.sleep(500);
                 l1.setForeground(Color.YELLOW);
                 t1.sleep(500);
                 l1.setForeground(Color.GREEN);
                 t1.sleep(500);
                 l1.setForeground(Color.CYAN);
                 t1.sleep(500);
                 l1.setForeground(Color.MAGENTA);
                 t1.sleep(500);
            }
       }catch(Exception e){}
  }
  public void initi(InputStream fis)throws JavaLayerException{
           
        this.player = new Player(fis);
        
    }
    
    public void stateChanged(ChangeEvent e)
         {
          
             l4.setText(""+s.getValue()+" %");
          
/*             s = (JSlider) e.getSource();
if(player!=null){
s.getMinimum();
long durationNanoseconds =
(player.getPosition());
s.setMaximum((int) player.getPosition());
int duration=(int) player.getPosition();
int percent = s.getValue();
long t = (durationNanoseconds / duration) * percent;
Time newTime = new Time(t);
s.setMajorTickSpacing(30);
pause();
player.wait(newTime);
player.start();
*/
}
       
    public void play() throws JavaLayerException {
        synchronized (playerLock) {
                     
                     Runnable r = new Runnable() {
                         public void run() {
                            playInternal();
                     
                        }
                    };
                     Thread t = new Thread(r);
                     t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    playerStatus = PLAYING;
                    t.start();
                  
        }
    }
         
    /**
     * Pauses playback. Returns true if new state is PAUSED.
     */
    public boolean pause() {
        synchronized (playerLock) {
            if (playerStatus == PLAYING) {
                playerStatus = PAUSED;
            }
            return playerStatus == PAUSED;
        }
        
    }

    /**
     * Resumes playback. Returns true if the new state is PLAYING.
     */
    public boolean resume() {
        synchronized (playerLock) {
            if (playerStatus == PAUSED) {
                playerStatus = PLAYING;
                playerLock.notifyAll();
            }
            return playerStatus == PLAYING;
        }
    }

    /**
     * Stops playback. If not playing, does nothing
     */
    public void stop() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
            playerLock.notifyAll();
        }
    }

    private void playInternal() {
        while (playerStatus != FINISHED) {
            try {
                if (!player.play(1)) {
                    break;
                }
            } catch (final JavaLayerException e) {
                break;
            }
            synchronized (playerLock) {
                while (playerStatus == PAUSED) {
                    try {
                        playerLock.wait();
                    } catch (final InterruptedException e) {
                        break;
                    }
                }
            }
        }
        close();
    }

    /**
     * Closes the player, regardless of current state.
     */
    public void close() {
        synchronized (playerLock) {
            playerStatus = FINISHED;
        }
        try {
            player.close();
        } catch (final Exception e) {
            // ignore, we are terminating anyway
        }
    }
      public static void main(String[] args) {
      try{
           
            FileInputStream fis=new FileInputStream("D:/Music/Silent song/suno.mp3"); 
            Main m=new Main();
            m.setTitle("MP3 Player");
            m.setSize(400,400);
            m.setVisible(true);                     
            m.initi(fis);
             } catch (final Exception e) {
            throw new RuntimeException(e);
        }
      
    
    }
     public void actionPerformed(ActionEvent e)
     {  
     try{
        if(e.getSource()==b)
        {
					          
        play();}
        else if(e.getSource()==pause)
        pause();
        else if(e.getSource()==resume)
        resume();
        else if(e.getSource()==stop)
           stop();
        else if(e.getSource()==close)
        {
           close();
           setVisible(false);
        }  
        else if (e.getSource()==open)
         {
            
				int r = fc.showOpenDialog(this);
				tf = fc.getSelectedFile(); // File type
				if (r == JFileChooser.CANCEL_OPTION)
					JOptionPane.showMessageDialog(this, "File NotSelected",
							"Error", JOptionPane.ERROR_MESSAGE);
				else {
					name = tf.getPath();
                                           
                                        if (!(name.endsWith(".mp3")))

						JOptionPane.showMessageDialog(this, "Select OnlyMP3",
								"Error", JOptionPane.ERROR_MESSAGE);

					else {
                                               l3.setText(name);
                                               try{
                                               fi=new FileInputStream(name);
                                               initi(fi);
                                                       
                                               }
                                               catch(Exception e1){e1.printStackTrace();}
                                            }
                                                 
                                             }
                              
               }
     /*else if (e.getSource()==circle)
         {
             l2=new JLabel(new ImageIcon("circle.jpg")+" ");
         }   
     else if (e.getSource()==wave)
         {
             l2=new JLabel(new ImageIcon("wave.jpg"+" "));
         }   
     else if (e.getSource()==ball)
         {
             l2=new JLabel(new ImageIcon("balls.jpg")+" ");
         }*/   
             
     
        
        }catch(JavaLayerException ex){}
             
            
        
     
     
     }
}















