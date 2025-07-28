package local.concept2_vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import local.exceptions.BusinessException;
import local.exceptions.ErrorCodes;

public class CalcControllerTest {

    private CalcController calculator;

    @BeforeEach
    public void configure() {
        calculator = new CalcController();
    }

    @Test
    public void addDefaultTest() {
        // 0 + 0
        assertEquals(0, calculator.add());
    }

    @Test
    public void testAddPositives() {
        // int num1 = 5;
        // int num2 = 3;
        calculator.setNum1(5);
        calculator.setNum2(3);
        // int result = calculator.add();
        assertEquals(8, calculator.add());
    }

    @Test
    public void testAddOneNegative() {
        int num1 = 5;
        int num2 = -3;
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        int result = calculator.add();
        assertEquals(2, result);
    }

    @Test
    public void subtractDefaultTest() {
        // 0 - 0
        assertEquals(0, calculator.subtract());
    }

    @Test
    public void testSubtractPositives() {
        // int num1 = 5;
        // int num2 = 3;
        calculator.setNum1(5);
        calculator.setNum2(3);
        // int result = calculator.add();
        assertEquals(2, calculator.subtract());
    }

    @Test
    public void testSubtractOneNegative() {
        int num1 = 5;
        int num2 = -3;
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        int result = calculator.subtract();
        assertEquals(8, result);
    }

    @Test
    public void multiplyDefaultTest() {
        // 0 * 0
        assertEquals(0, calculator.multiply());
    }

    @Test
    public void testMultiplyPositives() {
        // int num1 = 5;
        // int num2 = 3;
        calculator.setNum1(5);
        calculator.setNum2(3);
        // int result = calculator.add();
        assertEquals(15, calculator.multiply());
    }

    @Test
    public void testMultiplyOneNegative() {
        int num1 = 5;
        int num2 = -3;
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        int result = calculator.multiply();
        assertEquals(-15, result);

    }

    @Test
    public void intDivideDefaultTest1() {
        // 0 / 0
        try {
            calculator.intDivide();
            fail("Situación no contemplada");
        } catch (BusinessException e) {
            BusinessException expected = new BusinessException(ErrorCodes.ERROR_ZERO, "Dividiendo por 0");
            assertEquals(expected.getMessage(), e.getMessage());

        } catch (Exception e) {
            fail("Excepción no soportada");
        }
    }

    @Test
    public void intDivideDefaultTest2() {
        // 0 / 0
        try {
            calculator.intDivide();
            fail("Situación no contemplada");
        } catch (BusinessException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Excepción no soportada");
        }
    }

    @Test
    public void testIntDividePositives() throws BusinessException {
        // int num1 = 5;
        // int num2 = 3;
        calculator.setNum1(5);
        calculator.setNum2(3);
        // int result = calculator.add();
        assertEquals(1, calculator.intDivide());
        assertEquals(2, calculator.restDivision());
    }

    @Test
    public void testIntDivideOneNegative() throws BusinessException {
        int num1 = 5;
        int num2 = -3;
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        assertEquals(-1, calculator.intDivide());
        assertEquals(2, calculator.restDivision());

    }

    @Test
    public void decimalDivideDefaultTest() {
        // 0 / 0
        double result = calculator.decimalDivide();
        assertEquals(Double.NaN, result, 1);
    }

    @Test
    public void testDecimalDividePositives() {
        // int num1 = 5;
        // int num2 = 3;
        calculator.setNum1(5);
        calculator.setNum2(3);
        // int result = calculator.add();
        assertEquals(1.66, calculator.decimalDivide(), 0.01);
    }

    @Test
    public void testDecimalDivideOneNegative() {
        int num1 = 5;
        int num2 = -3;
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        double result = calculator.decimalDivide();
        assertEquals(-1.66, result, 0.01);
    }

    @Test
    public void testDecimalDivideByZero() {
        int num1 = 3;
        int num2 = 0;
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        double result = calculator.decimalDivide();
        assertEquals(Double.POSITIVE_INFINITY, result, 0.01);
    }

    @Test
    public void decimalDivideNoNanDefaultTest() {
        // 0 / 0
        try {
            calculator.decimalDivideNoNan();
            fail("Situación no contemplada");
        } catch (BusinessException e) {
            assertTrue(true);
        } catch (Exception e) {
            fail("Excepción no soportada");
        }
    }

    @Test
    public void testDecimalDivideNoNanPositives() throws BusinessException {
        // int num1 = 5;
        // int num2 = 3;
        calculator.setNum1(5);
        calculator.setNum2(3);
        // int result = calculator.add();
        assertEquals(1.66, calculator.decimalDivideNoNan(), 0.01);
    }

    @Test
    public void testDecimalDivideNoNanOneNegative() throws BusinessException {
        int num1 = 5;
        int num2 = -3;
        calculator.setNum1(num1);
        calculator.setNum2(num2);
        double result = calculator.decimalDivideNoNan();
        assertEquals(-1.66, result, 0.01);
    }

    // ----------------------------

    @Test
    public void factorialDefaultTest() throws BusinessException {
        // 0
        assertEquals(1, calculator.calculateFactorial());
    }

    @Test
    public void testFactorialPositive() throws BusinessException {
        calculator.setNum1(5);
        assertEquals(120, calculator.calculateFactorial());
    }

    @Test
    public void testFactorialNegative() {
        int num1 = -3;
        calculator.setNum1(num1);
        try {
            calculator.calculateFactorial();
            fail("Situación no contemplada");
        } catch (BusinessException e) {
            assertTrue(e.getMessage()
                .contains(ErrorCodes.ERROR_NEGATIVE.toString()));
        }
    };
    
    @Test
    public void testFactorialNegativeLambda() {
        int num1 = -3;
        calculator.setNum1(num1);

         Exception e = assertThrows(BusinessException.class, 
        () ->  calculator.calculateFactorial());
        assertTrue(e.getMessage()
                .contains(ErrorCodes.ERROR_NEGATIVE.toString()));
    }

    @Test
    public void testFactorialBigger20() {
        int num1 = 23;
        calculator.setNum1(num1);
        try {
            calculator.calculateFactorial();
            fail("Situación no contemplada");
        } catch (BusinessException e) {
            assertTrue(e.getMessage()
                .contains(ErrorCodes.ERROR_BIGGER_20.toString()));
        }
    }
    
    @Test
    public void testFactorialBigger20Lambda() {
        int num1 = 23;
        calculator.setNum1(num1);
        Exception e = assertThrows(BusinessException.class, 
        () ->  calculator.calculateFactorial());
        assertTrue(e.getMessage()
                .contains(ErrorCodes.ERROR_BIGGER_20.toString()));
    }

    @ParameterizedTest(name = "[{index}] {0}^{1} = {2}")
    @CsvSource(value = {"2,2,4", "3,2,9","3,5,243", "-3,3,-27"})
    public void testPow_2_2(int n1, int n2, int e) throws BusinessException {
        // int num1 = 5;
        // int num2 = 3;
        calculator.setNum1(n1);
        calculator.setNum2(n2);
        // int result = calculator.add();
        assertEquals(e, calculator.pow());
    }

    @Test
    public void testPow_3_m2() {
        // int num1 = 5;
        // int num2 = 3;
        calculator.setNum1(3);
        calculator.setNum2(-3);
        // int result = calculator.add();
        assertThrows(BusinessException.class, () -> calculator.pow());
    }
}
