import java.util.Scanner;

public class InverseGaussJordan {

    // Aplica Gauss-Jordan para obtener la inversa de una matriz cuadrada
    public static double[][] invertirMatriz(double[][] A) {
        int n = A.length;
        double[][] aug = new double[n][2 * n];

        // Construir matriz aumentada [A | I]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                aug[i][j] = A[i][j];
            }
            aug[i][n + i] = 1;
        }

        // Proceso Gauss-Jordan
        for (int i = 0; i < n; i++) {
            double pivote = aug[i][i];
            if (pivote == 0) {
                throw new ArithmeticException("No se puede invertir: pivote cero (matriz singular)");
            }

            // Normalizar fila actual
            for (int j = 0; j < 2 * n; j++) {
                aug[i][j] /= pivote;
            }

            // Hacer ceros en otras filas
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = aug[k][i];
                    for (int j = 0; j < 2 * n; j++) {
                        aug[k][j] -= factor * aug[i][j];
                    }
                }
            }
        }

        // Extraer la parte derecha como la inversa
        double[][] inversa = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inversa[i][j] = aug[i][n + j];
            }
        }

        return inversa;
    }

    // Imprimir matriz
    public static void imprimirMatriz(double[][] matriz) {
        for (double[] fila : matriz) {
            for (double val : fila) {
                System.out.printf("%10.4f", val);
            }
            System.out.println();
        }
    }

    // Método principal
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Tamaño de la matriz cuadrada: ");
        int n = sc.nextInt();

        double[][] A = new double[n][n];

        System.out.println("Introduce los elementos de la matriz A:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("A[" + i + "][" + j + "]: ");
                A[i][j] = sc.nextDouble();
            }
        }

        System.out.println("\nMatriz original A:");
        imprimirMatriz(A);

        try {
            double[][] Ainv = invertirMatriz(A);
            System.out.println("\nMatriz inversa A^-1:");
            imprimirMatriz(Ainv);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}