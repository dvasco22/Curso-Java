package local.concept_test;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputTest {

    private PrintStream originalOut;
    private ByteArrayOutputStream outputStream; 

    @BeforeEach
    public void setUp() {
        // Guarder el output original
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        PrintStream newOut = new PrintStream(outputStream);

        // Seteamos el system output
        System.setOut(newOut);
    }


    @Test
    void demo() {
        // Código a probar
        final String TEXT = "Texto de prueba";

        System.out.println(TEXT);
        String output = outputStream.toString().trim();

        // Assert
        assertEquals( TEXT, output);
    }

    @AfterEach
    public void tearDown() {
        // Restablecer el output
        System.setOut(originalOut);
    } 



}
