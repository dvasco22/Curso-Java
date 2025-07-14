
import java.util.Random;
import java.util.Scanner;

public class MatrixRandomMultiply {

    // Genera una matriz de tamaño filas x columnas con valores aleatorios entre 0 y
    // 100
    public static int[][] setRandomicMatrix(int rows, int cols, int scope) {
        Random randomize = new Random();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                matrix[i][j] = randomize.nextInt(2 * scope) + 1 - (scope); // [from -scope to +scope]
            }
        }

        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;

        int[][] C = new int[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return C;
    }

    public static void showMatrix(String label, int[][] matrix) {
        System.out.println("\n" + label + " :");
        for (int[] row : matrix) {
            System.out.print("|");
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.println("   |");
        }
        // System.out.println(" %d x %d", row, col);
        // System.out.println();
    }

    public static void main(String[] args) {
        Scanner keyBoard = new Scanner(System.in);

        System.out.print("Filas de A: ");
        int rowsA = keyBoard.nextInt();
        System.out.print("Columnas de A (y filas de B): ");
        int colsA = keyBoard.nextInt();
        System.out.print("Columnas de B: ");
        int colsB = keyBoard.nextInt();
        System.out.print("rango de valores : ej. 10 [Toma valores entre -10 y 10] : ");
        int scope = keyBoard.nextInt();

        int[][] A = setRandomicMatrix(rowsA, colsA, scope);
        int[][] B = setRandomicMatrix(colsA, colsB, scope);
        int[][] C = multiplyMatrices(A, B);

        showMatrix("Matriz A", A);
        showMatrix("Matriz B", B);
        showMatrix("Matriz C = A x B", C);

        keyBoard.close();
    }
}
