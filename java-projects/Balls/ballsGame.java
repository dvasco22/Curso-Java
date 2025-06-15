import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("serial")
public class ballsGame extends JPanel implements ActionListener, KeyListener, ItemListener {

  static final int WIDTH=800;
  static final int HEIGHT=600;
  static final int MAX_RADIUS=100;
  static final int MIN_RADIUS=20;
  static final int MAX_BALLS=100;
  static final int MAX_BALLS_X_GAME=3;
  static final int SLEEP=30;

  private JButton repaintButton;        

  Circle circles[]=new Circle[MAX_BALLS];   //Array of Circles 

/*------------------------------------------------------------------------------------------*/
/* Constructor                                                                              */
/*------------------------------------------------------------------------------------------*/

  public ballsGame() {  

         repaintButton= new JButton("");

         this.setLayout(new GridBagLayout());
         GridBagConstraints gbc = new GridBagConstraints();

         gbc.gridx=0;gbc.gridy=0;
         gbc.gridwidth=0;gbc.gridheight=0;
         gbc.weightx=0.0;gbc.weighty=0.0;
         gbc.fill=GridBagConstraints.NONE;
         this.add(repaintButton);
         repaintButton.addKeyListener(this);
         repaintButton.setVisible(false);
         setSize(WIDTH,HEIGHT); //Panel size
         initGame();
  }
/*------------------------------------------------------------------------------------------*/

  public void initGame() {
         int width  = getWidth();
         int height = getHeight();    
         int XCenter = width/2;
         int YCenter = height/2;

         boolean leave=true;
         Random random = new Random();
         int radius; 

         for (int i=0; i<MAX_BALLS_X_GAME; i++) {

             circles[i] = new Circle();

             radius=random.nextInt(MAX_RADIUS);
             if (radius<MIN_RADIUS)
                 radius=MIN_RADIUS+radius;

             do {
                 XCenter=random.nextInt(WIDTH);
                 YCenter=random.nextInt(HEIGHT);
 
                 if (XCenter+radius > WIDTH) 
                     XCenter-=radius;
                 if (YCenter+radius > HEIGHT)
                     YCenter-=radius;
                 if (XCenter-radius <= 0) 
                     XCenter+=radius;
                 if (YCenter-radius <= 0)
                     YCenter+=radius;

                 circles[i].setCircle(XCenter,YCenter,radius);

                 int j=i-1;
                 leave=false;
                 while ((j>=0) && (!leave))
                     if (!circles[i].crash(circles[j]))
                        j--;
                     else   
                        leave=true;

             } while (leave);
         }
  }
/*------------------------------------------------------------------------------------------*/
   /**/
   public void move() {
         for (int i=0; i<MAX_BALLS_X_GAME; i++) 
    	       for (int j=0; j<MAX_BALLS_X_GAME; j++) 
    	    	   if (i!=j)
                      circles[i].move(WIDTH,HEIGHT,circles[j],i,j);
  }
  /**/
  
  /*------------------------------------------------------------------------------------------*/  
  @Override
  public void paintComponent(Graphics g) {

         super.paintComponent(g);

         g.setColor(Color.BLUE);
         g.fillRect(0,0,WIDTH,HEIGHT);
         
         for (int i=0; i<MAX_BALLS_X_GAME; i++) 
    	      circles[i].drawCircle(g,i); 
  }
/*------------------------------------------------------------------------------------------*/  

  
  
        /*            
        for (int i=0; i<MAX_BALLS_X_GAME; i++) {
            circles[i].drawCircle(g);
            circles[i].move(WIDTH,HEIGHT);

            for (int j=0; j<MAX_BALLS_X_GAME; j++) 
                if (j!=i) 
                   if (circles[i].crash(circles[j])) 
                       circles[i].moveIfCrash(circles[j]);}
        }               
       */
           /*            
           int i=0;
           int j=0;
           boolean crash;
           while (i<MAX_BALLS_X_GAME) {
                  circles[i].move(WIDTH,HEIGHT);

            		 j=0;
                     crash=false;            		 
            		 while ((j<MAX_BALLS_X_GAME) && (!crash)) {
            			    if ((!circles[i].crash(circles[j]) || i==j))
            			       j++;
            			    else {
            			    	circles[i].moveIfCrash(circles[j]);
            			    	crash=true;
            			    }
            		 }
            	  
            	  if (crash) {
            		  i=0;
            	  }    
            	  else {
//            	      circles[i].drawCircle(g); 
                      i++;
                  }
           }

           for (int k=0; k<MAX_BALLS_X_GAME; k++) 
       	        circles[k].drawCircle(g); 
           */
  
  
/*------------------------------------------------------------------------------------------*/
/* IMPLEMENTS                                                                               */
/*------------------------------------------------------------------------------------------*/
  
   public void actionPerformed(ActionEvent e) {
          if (e.getSource()==repaintButton) {
             repaint();
          }
   }   
        
   public void keyPressed(KeyEvent e) {
          switch(e.getKeyCode()) {
          case KeyEvent.VK_ENTER: 
               repaint();
               break;
          }
   }

   public void keyReleased(KeyEvent e) {}
   public void keyTyped(KeyEvent e) {}
   public void itemStateChanged(ItemEvent e) {}

/*------------------------------------------------------------------------------------------*/
/* MAIN                                                                                     */
/*------------------------------------------------------------------------------------------*/
  public static void main(String[] args) throws InterruptedException {
         JFrame frame = new JFrame();
         ballsGame bg = new ballsGame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.add(bg);
         frame.setSize(WIDTH+MAX_RADIUS,HEIGHT+MAX_RADIUS);
         frame.setVisible(true);

         while (true) {
                bg.move();
                bg.repaint();
                Thread.sleep(SLEEP);
         }
  }
}