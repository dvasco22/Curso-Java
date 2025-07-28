package local.concept_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class InputTest {

    private InputStream originalIn;

    @BeforeClass
    void setUp() {
        originalIn = System.in;
    }

    @Test
    void demo() {

        // creamos el string de lo que escribiría el usuario
        String userInput = "This is a test for console input.";

        // creamos un ByteArrayInputStream a partir de un string
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());

        // se lo pasamos a System.in
        System.setIn(inputStream);

        // Comparamos userInput
        assertEquals(userInput, simulateScanner());

    }

    @AfterClass
    void tearDown() {
        // Recuperamos el System.in original
        System.setIn(originalIn);
    }


    public String simulateScanner() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Ingresa tu nombre: ");
            return scanner.nextLine();
        }
    }

}
