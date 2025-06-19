
import java.text.*;
 
public class format {
 
    public static void main(String[] args) {
 
        double d = /*(double)*/Math.pow(2,50);
        DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###");
        System.out.print(df.format(d));  //1.125.899.906.842.624
        System.out.print(d);             //1.125.899.906.842.6241.125899906842624E15
    }
 
}