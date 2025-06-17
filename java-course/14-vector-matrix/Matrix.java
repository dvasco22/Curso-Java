public class Matrix {

    static void vector() {
        int[] vectorNumbers = { 3, 4, 5, 23, 54 };
        String[] vectorNames = new String[4];

        vectorNames[0] = "Pepe";
        vectorNames[1] = "Luisa";
        vectorNames[3] = "Ramón";

        for (int i = 0; i < vectorNumbers.length; i++) {
            System.out.println(vectorNumbers[i]);
        }

        for (String name : vectorNames) {
            System.out.println(name);
        }
    }

    static void matrix() {

        String[][] matrixNames = { { "Pepe", "Luisa", "Ramon" }, { "Perez", "Gomez", "Smith" },
                { "Ruiz", "Martin", "Walter" } };

        int[][] matrixNumbers = new int[3][3];

        matrixNumbers[0][0] = 22;
        matrixNumbers[0][1] = 44;
        matrixNumbers[0][2] = 50;
        matrixNumbers[1][0] = 25;
        matrixNumbers[1][1] = 46;
        matrixNumbers[1][2] = 57;
        matrixNumbers[2][0] = 13;
        matrixNumbers[2][1] = 5;
        matrixNumbers[2][2] = 0;

        for (int i = 0; i < matrixNumbers.length; i++) {
            for (int j = 0; j < matrixNumbers[0].length; j++) {
                System.out.print(matrixNumbers[i][j] + " ");
            }
            System.out.println("");
        }

        for (int[] row : matrixNumbers) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        vector();
        matrix();
    }
}
