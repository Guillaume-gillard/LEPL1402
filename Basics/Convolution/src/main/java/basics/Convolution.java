package basics;

public class Convolution {

    /**
     *
     * @param input is a n1 x m1 non-null rectangular matrix with at least 3 rows and 3 cols
     * @param kernel is a 3 x 3 square matrix
     * @return a matrix M with dimension (n1-2) x (m1-2) with
     *         M[i][j] = sum_{k in 0..2, l in 0..2} input[i+k][j+l]*kernel[k][l]
     */
    public static int [][] convolution(int [][] input, int [][] kernel) {
        int n1 = input.length;
        int m1 = input[0].length;
        int [][] M = new int[n1-2][m1-2];
        for (int i = 0; i <= n1-3; i++){
            for (int j = 0; j <= m1-3; j++){
                M[i][j] = 0;
                for (int k = 0; k <= 2; k++){
                    for (int l = 0; l <= 2; l++){
                        M[i][j] += (input[i+k][j+l])*(kernel[k][l]);
                    }
                }
            }
        }
        return M;
    }
}
