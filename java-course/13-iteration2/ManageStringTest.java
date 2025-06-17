
public class ManageStringTest {
    public static void main(String[] args) {
        String test = "Una Prueba";
        String reverse = ManageString.reverseString2(test);
        String removed = ManageString.removeFirstLast(test);
        String noSpaces = ManageString.removeSpaces(test);
        System.out.println("Original: " + test);
        System.out.println("Reverse: " + reverse);
        System.out.println("Recortado: " + removed);
        System.out.println("Sin espacios " + noSpaces);
    }

}
