package basics;

public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] rows = s.split("\n");
        int[][] matrix = new int[rows.length][];
        for (int i = 0; i < rows.length; i++){
            String[] row = rows[i].split(" ");
            int [] row_int = new int [row.length];
            for (int j = 0; j < row.length; j++){
                row_int[j] = Integer.parseInt(row[j]);
            }
            matrix[i] = row_int;
        }
        return matrix;
    }


    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int [][] transposed_matrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                transposed_matrix[j][i] = matrix[i][j];
            }
        }
        return transposed_matrix;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int [][] product_matrix = new int[matrix1.length][matrix2[0].length];
        for (int n = 0; n < matrix1.length; n++){
            for (int k = 0; k < matrix2[0].length; k++){
                for (int i = 0; i < matrix1[0].length; i++) {
                    product_matrix[n][k] += matrix1[n][i] * matrix2[i][k];
                }
            }
        }
        return product_matrix;
    }
}