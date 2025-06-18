
import java.text.*;
 
public class format {
 
    public static void main(String[] args) {
 
        double d = (double)Math.pow(2,50);
        DecimalFormat df = new DecimalFormat("###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###,###");
        System.out.print(df.format(d));
    }
 
}