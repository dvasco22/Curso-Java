public class MatrixMultiply {

    public static int[][] multiplyMatrices(int[][] A, int[][] B) {
        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        // Crear matriz resultado
        int[][] C = new int[rowsA][colsB];

        // Verificar si se pueden multiplicar
        if (colsA != rowsB) {
            System.out.println("No se pueden multiplicar: columnas de A diferente a filas de B.");
        } else {
            // Algoritmo de multiplicación
            for (int i = 0; i < rowsA; i++) {
                for (int j = 0; j < colsB; j++) {
                    C[i][j] = 0;
                    for (int k = 0; k < colsA; k++) {
                        C[i][j] += A[i][k] * B[k][j];  
                    }
                }
            }

        }
        return C;
    }

    public static void showMatrix(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] A = {
                { 1, 2, 3 },
                { 4, 5, 6 } // 3x2
        };

        int[][] B = {
                { 7, 8 },
                { 9, 10 },
                { 11, 12 } // 2x3
        };

        int[][] C = multiplyMatrices(A, B);
        System.out.println("Resultado de A x B:");
        showMatrix(C);
    }
}
