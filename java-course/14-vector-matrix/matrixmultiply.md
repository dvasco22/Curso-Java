
                
                
                 MULTIPLICACION DE MATRICES (Producto Punto)   C = A . B


Para poder multiplicar  2 matrices A y B , el número de Filas de A debe ser igual al numero de columnas de B
generando una matrix C con el número de filas de A y el número de coloumnas de B

       
A[][] = | A[1][1] A[1][2] A[1][3] |                             A = | 1 2 3 |
        | A[2][1] A[2][2] A[2][3] | m x n                           | 4 5 6 | 2x3
     
                                                 
B[][] = |  B[1][1] B[1][2] |                                    B = | 7   8 |
        |  B[2][1] B[2][2] |                                        | 9  10 |
        |  B[3][1] B[3][2] | n x p                                  | 11 12 | 3x2


C[][] = | C[1][1] C[1][2] |                             A.B -> C = | 58   64 |
        | C[2][1] C[2][2] | m x p                                  | 139 154 | 2x2




                  i  k      k  j
                  |  |      |  |
      C[1][1] = A[1][1] x B[1][1]  +    ->  (1 X  7) =  7 
                A[1][2] x B[2][1]  +    ->  (2 X  9) = 18
                A[1][3] x B[3][1]  +    ->  (3 X 11) = 33
                                                       --
                                                       58

      C[1][2] = A[1][1] x B[1][1]  +    ->  (1 X  8) =  8 
                A[1][2] x B[2][1]  +    ->  (2 X 10) = 20
                A[1][3] x B[3][1]  +    ->  (3 X 12) = 36
                                                       --
                                                       64

      C[2][1] = A[2][1] x B[1][1]  +    ->  (4 X  7) =  28 
                A[2][2] x B[2][1]  +    ->  (5 X  9) =  45
                A[2][3] x B[3][1]  +    ->  (6 X 11) =  66
                                                       ---
                                                       139

      C[2][2] = A[2][1] x B[1][2]  +    ->  (4 X  8) =  32 
                A[2][2] x B[2][2]  +    ->  (5 X 10) =  50
                A[2][3] x B[3][2]  +    ->  (6 X 12) =  72
                                                       ---
                                                       154
                                                 
                           n-1
                C[i][j] = SUM   (A[i][k] . B[k][j])
                           k=0


             for (int i = 0; i < ARows; i++) {
                for (int j = 0; j < BCols; j++) {
                   for (int k = 0; k < ACols; k++) {
                       C[i][j] += A[i][k] * B[k][j];
                   }
               }
            }


Nota : Para la división no existe A/B, se debe obtenr la matriz inversa B a la -1 y multiplicar por A

       B x B a la -1 = I (identica ) Matriz con al diagonal en 1 y el resto de la posiciones iguales a 0;

       Investigando para crear un algoritmo.