package local.concept2_vc;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalcControllerTest {
    @Test
    public void testAddOk() {
        int num1 = 5;
        int num2 = 3;
        CalcController calculator = new CalcController();
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        int result = calculator.add();
        assertEquals("Suma 5 y 3", 8, result);

    }
    
    @Test
    public void testAddFail() {
        int num1 = 5;
        int num2 = 3;
        CalcController calculator = new CalcController();
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        int result = calculator.add();
        assertEquals("Suma 5 y 3", 9, result);

    }

    @Test
    public void testAddException() {
        int num1 = 5;
        int num2 = 3;
        CalcController calculator = new CalcController();
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        int result = calculator.add();
        assertEquals("Suma 5 y 3", 9, result);

    }
}