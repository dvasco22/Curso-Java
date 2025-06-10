/*------------------------------------------------------------------------------------------*/

public class Point {
/*------------------------------------------------------------------------------------------*/
/* Private member variables                                                                 */
/*------------------------------------------------------------------------------------------*/
   private int x;
   private int y;
/*------------------------------------------------------------------------------------------*/
/* Constructor                                                                              */
/*------------------------------------------------------------------------------------------*/
   public Point() {
      x = 0;
      y = 0;
   }
 
   public Point(int x, int y) {
      this.x = x;
      this.y = y;
   }
/*------------------------------------------------------------------------------------------*/
/* Getters and Setters                                                                      */
/*------------------------------------------------------------------------------------------*/
   public int getX() {
      return x;
   }
 
   public int getY() {
      return y;
   }
 
   public void setX(int x) {
      this.x = x;
   }
 
   public void setY(int y) {
      this.y = y;
   }
 
   public void setXY(int x, int y) {
      this.x = x;
      this.y = y;
   }
 
   public String toString() {
      return "(" + x + "," + y + ")";
   }
 
   public double distance(int x, int y) {
      int xDiff = this.x - x;
      int yDiff = this.y - y;
      return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
   }
 
   public double distance(Point point) {
      int xDiff = this.x - point.x;
      int yDiff = this.y - point.y;
      return Math.sqrt(xDiff*xDiff + yDiff*yDiff);
   }
 }
/*------------------------------------------------------------------------------------------*/
