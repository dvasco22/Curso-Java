import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/*------------------------------------------------------------------------------------------*/
public class Circle {
/*------------------------------------------------------------------------------------------*/
/* Private member variables                                                                 */
/*------------------------------------------------------------------------------------------*/
   private Point center;    // Declare instance center
   private int radius;

   private int dx;
   private int dy;

/*------------------------------------------------------------------------------------------*/
/* Constructors                                                                             */
/*------------------------------------------------------------------------------------------*/
   public Circle() {
      center = new Point(); // Construct instance at (0,0)
      radius = 1;
      dx=1;
      dy=1;
   }
 
   public Circle(int xCenter, int yCenter, int radius) {
      center = new Point(xCenter, yCenter); // Construct instance at (x,y)
      this.radius = radius;
      dx=1;
      dy=1;
   }
 
   public Circle(Point center, int radius) {
      this.center = center;
      this.radius = radius;
      dx=1; 
      dy=1;
   }

/*------------------------------------------------------------------------------------------*/
/* Getters and Setters                                                                      */
/*------------------------------------------------------------------------------------------*/

   public int getdX() {
          return dx;
   }

   public void setdX(int dx) {
          this.dx=dx;
   }

   public int getdY() {
          return dy;
   }

   public void setdY(int dy) {
          this.dy=dy;
   }

   public void setCircle(int xCenter, int yCenter, int radius) {
      center = new Point(xCenter, yCenter); // Construct instance
      this.radius = radius;
      dx=1;
      dy=1;
   }

   public void setRadius(int radius) {
      this.radius = radius;
   }

   public int getRadius() {
      return radius;
   }

   public void setCenter(Point center) {
      this.center = center;
   }

   public Point getCenter() {
      return center;
   }

   public void setCenterXY(int x, int y) {
      center.setX(x);
      center.setY(y);
   }

   public int getCenterX() {
      return center.getX();
   }
/*****************************/
   public int getX() {
	      return center.getX();
	   }
/*****************************/
   
   public void setCenterX(int x) {
      center.setX(x);
   }

   public void setCenterY(int y) {
      center.setY(y);
   }

   public int getCenterY() {
      return center.getY();
   }

/*****************************/
   public int getY() {
	      return center.getY();
   }
/*****************************/

   @Override
   public String toString() {
      return "center=" + center + " radius=" + radius;
   }
   
   public double getArea() {
      return Math.PI * radius * radius;
   }
 
   public double getPerimeter() {
      return 2.0 * Math.PI * radius;
   }
 
   public double distancePP(Circle circle) {
      double d=this.center.distance(circle.center);  // use distance() of Point
      return d;
   }

   public boolean crash(Circle circle) {
       return (this.distancePP(circle) - this.radius - circle.radius) <=0;
   }

   public void drawCircle(Graphics g, int i) {
          g.setColor(Color.YELLOW);  
          // TODO to set color at random
          g.drawOval(center.getX()-radius,center.getY()-radius,2*radius,2*radius);
          g.setFont( new Font("Serif", Font.BOLD,15) );
          g.drawString("C"+i,getCenterX()-10,getCenterY());
   }
/*------------------------------------------------------------------------------------------*/
/*  MOVE METHOD                                                                             */
/*------------------------------------------------------------------------------------------*/

   public void move(int width, int height, Circle c, int i, int j) {

	      int xi=this.getCenterX();
          int yi=this.getCenterY();
          int dxi=this.dx;
          int dyi=this.dy;
          int ri=this.radius;

          int xj=c.getCenterX();
          int yj=c.getCenterY();
          int dxj=c.getdX();
          int dyj=c.getdY();
          int rj=c.getRadius();
          
          boolean crash=this.crash(c);
          int d=0;
          if (crash) {
             d=(int)distancePP(c)-ri-rj;
        	
        	 if ((dxi==dxj) && (dyi!=dyj)) {
                System.out.printf("c1C%d(%d,%d)[%d,%d] C%d(%d,%d)[%d,%d] d=%d %n",i,xi,yi,dxi,dyi,j,xj,yj,dxj,dyj,d);        		 
                dy=-dy;
                c.setdY(-dyj);
        	 }
             if ((dxi!=dxj) && (dyi==dyj)) {
                 System.out.printf("c2C%d(%d,%d)[%d,%d] C%d(%d,%d)[%d,%d] d=%d %n",i,xi,yi,dxi,dyi,j,xj,yj,dxj,dyj,d);        		 
                dx=-dx; 
                c.setdX(-dxj);
             }
             if ((dxi!=dxj) && (dyi!=dyj)) {
                 System.out.printf("c3C%d(%d,%d)[%d,%d] C%d(%d,%d)[%d,%d] d=%d %n",i,xi,yi,dxi,dyi,j,xj,yj,dxj,dyj,d);        		 
                dx=-dx;
                dy=-dy;
                c.setdX(-dxj);
                c.setdY(-dyj);             
             }
             if ((dxi==dxj) && (dyi==dyj)) {
                 System.out.printf("c4C%d(%d,%d)[%d,%d] C%d(%d,%d)[%d,%d] d=%d %n",i,xi,yi,dxi,dyi,j,xj,yj,dxj,dyj,d);        		 
                c.setdY(-dyj);
                c.setdX(-dxj);
             }
             
             if ((xj+rj-d >= width)  || (xj-rj+d <= 0)) {     
           //if ((xj+rj-d/2 >= width)  || (xj-rj+d/2 <= 0)) {
                c.setdX(-dxj);
                System.out.printf("wjC%d(%d,%d) [%d,%d] out of range -width-d=%d %n",j,xj,yj,c.getdX(),dyj,d);        		 
             }

             if ((yj+rj-d >= height) || (yj-rj+d <= 0)) {    
             //if ((yj+rj-d/2 >= height) || (yj-rj+d/2 <= 0)) {
                c.setdY(-dyj);
                System.out.printf("hjC%d(%d,%d) [%d,%d] out of range -height- d=%d %n",j,xj,yj,dxj,c.getdY(),d);        		 
             }
             
             c.setCenterX(xj+c.getdX()+(c.getdX()*(-d)));   
             //c.setCenterX(xj+c.getdX()+(c.getdX()*(-d/2)));
             
             c.setCenterY(yj+c.getdY()+(c.getdY()*(-d)));   
             //c.setCenterY(yj+c.getdY()+(c.getdY()*(-d/2)));
             
             //c.setCenterX(xj+c.getdX());
             //c.setCenterY(yj+c.getdY());
          }
        
          if ((xi+ri-d >= width)  || (xi-ri+d <= 0)) {
          //if ((xi+ri-d/2 >= width)  || (xi-ri+d /2<= 0)) {
             dx=-dx;
             System.out.printf("wiC%d(%d,%d) [%d,%d] out of range -width- d=%d %n",i,xi,yi,dx,dy,-d);        		 
          }
        
          if ((yi+ri-d >= height) || (yi-ri+d <= 0)) {
          //if ((yi+ri-d/2 >= height) || (yi-ri+d/2 <= 0)) {
             dy=-dy;
             System.out.printf("hiC%d(%d,%d) [%d,%d] out of range -height- d=%d %n",i,xi,yi,dx,dy,-d);        		 
          }
         
          this.setCenterX(xi+dx+(dx*(-d)));  
          //this.setCenterX(xi+dx+(dx*(-d/2)));
          this.setCenterY(yi+dy+(dy*(-d)));  
          //this.setCenterY(yi+dy+(dy*(-d/2)));
          
          //this.setCenterX(xi+dx);
          //this.setCenterY(yi+dy);
          
          if (crash) {
             System.out.printf("---Crash C%d-C%d---%n",i,j);        		 
             System.out.printf("cFC%d(%d,%d)[%d,%d](r=%d) C%d(%d,%d)[%d,%d](r=%d)%n",i,getX(),getY(),getdX(),getdY(),ri,j,c.getX(),c.getY(),c.getdX(),c.getdY(),rj);        		 
          }
    }
   /*------------------------------------------------------------------------------------------*/
   /*  END MOVE METHOD                                                                         */
   /*------------------------------------------------------------------------------------------*/
}
/*------------------------------------------------------------------------------------------*/
