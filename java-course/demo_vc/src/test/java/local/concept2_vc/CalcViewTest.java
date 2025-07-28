package local.concept2_vc;

import java.io.ByteArrayInputStream;
// import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import local.exceptions.BusinessException;
import local.exceptions.ErrorCodes;

// import java.util.NoSuchElementException;
// import org.mockito.Mockito;

public class CalcViewTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outputStream;
    private InputStream originalIn;
    private CalcView view;
    private CalcController ctrlMock;

    @BeforeEach
    public void setUp() {

        ctrlMock = Mockito.mock(CalcController.class);
        ;
        view = new CalcView(ctrlMock);

        // Guardar el input original
        originalIn = System.in;
        // Guarder el output original
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outputStream);

        // Seteamos el system output
        System.setOut(newOut);
    }

    @Test
    void testAdd() {

        ctrlMock.setNum1(3);
        ctrlMock.setNum2(2);

        Mockito.when(ctrlMock.add()).thenReturn(5);

        // creamos el string de lo que escribiría el usuario
        String userInput = "3";

        // creamos un ByteArrayInputStream a partir de un string
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // se lo pasamos a System.in
        System.setIn(inputStream);

        try {
            view.show();
        } catch (NoSuchElementException e) {
            // handle exception for exit while in the code
        }

        // Verify that the controller's add method was called
        Mockito.verify(ctrlMock).add();

        // // Verify terminal output

        String output = outputStream.toString().trim();
        assert output.contains("El resultado de la suma es 5") : "Output did not contain expected result.";

    }

    @Test
    void testSubtract() {

        ctrlMock.setNum1(5);
        ctrlMock.setNum2(2);

        Mockito.when(ctrlMock.subtract()).thenReturn(3);

        // creamos el string de lo que escribiría el usuario
        String userInput = "4";

        // creamos un ByteArrayInputStream a partir de un string
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // se lo pasamos a System.in
        System.setIn(inputStream);

        try {
            view.show();
        } catch (NoSuchElementException e) {
            // handle exception for exit while in the code
        }

        // Verify that the controller's add method was called
        Mockito.verify(ctrlMock).subtract();

        // // Verify terminal output

        String output = outputStream.toString().trim();

        assert output.contains("El resultado de la resta es 3") : "Output did not contain expected result.";

    }

    @Test
    void testFactorial() throws BusinessException {

        view = new CalcView(ctrlMock);
        ctrlMock.setNum1(5);

        Mockito.when(ctrlMock.calculateFactorial((byte) 1)).thenReturn(120l);

        // creamos el string de lo que escribiría el usuario
        String userInput = "3";

        // creamos un ByteArrayInputStream a partir de un string
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // se lo pasamos a System.in
        System.setIn(inputStream);

        try {
            view.show(true);
        } catch (NoSuchElementException e) {
            // handle exception for exit while in the code
        }

        // Verify that the controller's add method was called
        Mockito.verify(ctrlMock).calculateFactorial((byte) 1);

        // // Verify terminal output
        String output = outputStream.toString().trim();

        assert output.contains("El factorial de 0 es 120") : "Output did not contain expected result.";

    }

    @Test
    void testFactorialNegative() throws BusinessException {

        view = new CalcView(ctrlMock);
        ctrlMock.setNum1(-5);

        Mockito.when(ctrlMock.calculateFactorial((byte) 1))
                .thenThrow(new BusinessException(ErrorCodes.ERROR_NEGATIVE, "Error"));

        // creamos el string de lo que escribiría el usuario
        String userInput = "3";

        // creamos un ByteArrayInputStream a partir de un string
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // se lo pasamos a System.in
        System.setIn(inputStream);

        try {
            view.show(true);
        } catch (NoSuchElementException e) {
            // handle exception for exit while in the code
        }

        // Verify that the controller's add method was called
        Mockito.verify(ctrlMock).calculateFactorial((byte) 1);

        // // Verify terminal output
        String output = outputStream.toString().trim();
        assert output.contains(ErrorCodes.ERROR_NEGATIVE.toString()) : "Output did not contain expected result.";

    }

    @Test
    void testFactorialBigger() throws BusinessException {

        view = new CalcView(ctrlMock);
        ctrlMock.setNum2(25);

        Mockito.when(ctrlMock.calculateFactorial((byte) 2))
                .thenThrow(new BusinessException(ErrorCodes.ERROR_BIGGER_20, "Error"));

        // creamos el string de lo que escribiría el usuario
        String userInput = "4";

        // creamos un ByteArrayInputStream a partir de un string
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // se lo pasamos a System.in
        System.setIn(inputStream);

        try {
            view.show(true);
        } catch (NoSuchElementException e) {
            // handle exception for exit while in the code
        }

        // Verify that the controller's add method was called
        Mockito.verify(ctrlMock).calculateFactorial((byte) 2);

        // // Verify terminal output
        String output = outputStream.toString().trim();
        assert output.contains(ErrorCodes.ERROR_BIGGER_20.toString()) : "Output did not contain expected result.";

    }

    @AfterEach
    public void tearDown() {
        // Restablecer el input
        System.setIn(originalIn);
        // Restablecer el output
        System.setOut(originalOut);
    }
}
