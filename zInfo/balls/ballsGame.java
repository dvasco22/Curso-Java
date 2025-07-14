
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("serial")
public class ballsGame extends JPanel implements ActionListener, KeyListener, ItemListener, MouseListener {

  static final int WIDTH=800;
  static final int HEIGHT=600;
  static final int MAX_RADIUS=100;
  static final int MIN_RADIUS=20;
  static final int MAX_BALLS=100;
  static final int MAX_BALLS_X_GAME=4;
  static final int SLEEP=30;

  private JButton repaintButton;        

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
                    //addBall(e.getX(), e.getY());
                    addBall(e);
                    //System.out.println("Se presionó el botón drerecho del mouse.");
                } else if (e.getButton() == MouseEvent.BUTTON1) { // Clic izquierdo
                    removeLastBall();
                    //System.out.println("Se presionó el botón Izquierdo  del mouse.");
                }
            }
        });


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

         for (int i=0; i < countBalls /*MAX_BALLS_X_GAME*/; i++) {

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
   
    //si se presiona el boton derecho del mouse
    public void  addBall(MouseEvent e) {
        if (countBalls >= MAX_BALLS) 
            return;

        Random rand = new Random();
        int radius = rand.nextInt(MAX_RADIUS - MIN_RADIUS) + MIN_RADIUS;
        Circle newCircle = new Circle(e.getX(), e.getY(), radius);

        for (int i = 0; i < countBalls; i++) {
            if (newCircle.getCenter().distance(circles[i].getCenter()) < radius + circles[i].getRadius()) {
                return; // Colisión, no se agrega
            }
        }
        circles[countBalls++] = newCircle;
    }



   //si se presiona el botón Izquierdo del mouse
   public void removeLastBall() {
         if (countBalls > 0) {
            countBalls--;
            circles[countBalls] = null;
         }
    }

  
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

   /*public void keyReleased(KeyEvent e) {}
   public void keyTyped(KeyEvent e) {}
   public void itemStateChanged(ItemEvent e) {}*/

// Implementación vacía de otros métodos del MouseListener
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}

    /*public void actionPerformed(ActionEvent e) {}
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) repaint();
    }*/

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