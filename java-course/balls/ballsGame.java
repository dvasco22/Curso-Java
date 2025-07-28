
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public final class ballsGame extends JPanel implements ActionListener, KeyListener, ItemListener, MouseListener {

  static final int WIDTH=800;
  static final int HEIGHT=600;
  static final int MAX_RADIUS=100;
  static final int MIN_RADIUS=20;
  static final int MAX_BALLS=100;
  static final int MAX_BALLS_X_GAME=4;
  static final int SLEEP=30;

   private final JButton repaintButton;        

  public int countBalls = MAX_BALLS_X_GAME;

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


        // Manejo de clicks
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) { // Clic derecho
                    //removeLastBall();
                    addBall(e);
                } else if (e.getButton() == MouseEvent.BUTTON1) { // Clic izquierdo
                    //addBall(e);
                    removeLastBall();
                }
            }
        });//clase Anónima

    /*  Forma alternativa a la clase anónima
       class MiMouseListener extends MouseAdapter {
       @Override
         public void mousePressed(MouseEvent e) {
           //code here
          }
        }
       // Y luego en el constructor:
         addMouseListener(new MiMouseListener());
    */

         initGame();
  }
/*------------------------------------------------------------------------------------------*/
  
  public void initGame() {
         /*int width  = getWidth();*/
         /*int height = getHeight();*/    
         int xCenter /* = width/2*/;
         int yCenter /* = height/2*/;

         boolean leave /*=true*/;
         Random random = new Random();
         int radius; 

         for (int i=0; i < countBalls /*MAX_BALLS_X_GAME*/; i++) {

             circles[i] = new Circle();

             radius=random.nextInt(MAX_RADIUS);
             if (radius<MIN_RADIUS)
                 radius=MIN_RADIUS+radius;

             do {
                 xCenter=random.nextInt(WIDTH);
                 yCenter=random.nextInt(HEIGHT);
 
                 if (xCenter+radius > WIDTH) 
                     xCenter-=radius;
                 if (yCenter+radius > HEIGHT)
                     yCenter-=radius;
                 if (xCenter-radius <= 0) 
                     xCenter+=radius;
                 if (yCenter-radius <= 0)
                     yCenter+=radius;

                 circles[i].setCircle(xCenter,yCenter,radius);

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
         for (int i=0; i < countBalls /*MAX_BALLS_X_GAME*/; i++) 
    	       for (int j=0; j < countBalls /*MAX_BALLS_X_GAME*/; j++) 
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
         
         for (int i=0; i < countBalls /*MAX_BALLS_X_GAME*/; i++) 
    	      circles[i].drawCircle(g,i); 
  }
/*------------------------------------------------------------------------------------------*/  
   
    //Wheter mouse right button is pressed
    public void  addBall(MouseEvent e) {
        if (countBalls >= MAX_BALLS) 
            return;

        Random random = new Random();
        int radius = random.nextInt(MAX_RADIUS - MIN_RADIUS) + MIN_RADIUS;
        Circle newCircle = new Circle(e.getX(), e.getY(), radius);

        for (int i = 0; i < countBalls; i++) {
            if (newCircle.crash(circles[i])) {
               return; // Colisión, is not added
            }
        }
        circles[countBalls++] = newCircle;
    }

   //if mouse left button is pressed
   public void removeLastBall() {
         if (countBalls > 0) {
            countBalls--;
            circles[countBalls] = null;
         }
    }

  
/*------------------------------------------------------------------------------------------*/
/* IMPLEMENTS                                                                               */
/*------------------------------------------------------------------------------------------*/
  @Override
   public void actionPerformed(ActionEvent e) {
          if (e.getSource()==repaintButton) {
             repaint();
          }
   }   
 
   @Override
   public void keyPressed(KeyEvent e) {
          switch(e.getKeyCode()) {
          case KeyEvent.VK_ENTER -> repaint();
          }
   }

   /*public void keyReleased(KeyEvent e) {}
   public void keyTyped(KeyEvent e) {}
   public void itemStateChanged(ItemEvent e) {}*/

// Empty Implementation of thr others method from MouseListener
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}

    /*public void actionPerformed(ActionEvent e) {}
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) repaint();
    }*/

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
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

         /*while (true)*/ for(;;) {
                bg.move();
                bg.repaint();
                Thread.sleep(SLEEP);
         }
  }
}