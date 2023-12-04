package basics;

public class MagicSquare {

    /**
     * A magic square is an (n x n) matrix such that:
     *
     * - all the positive numbers 1,2, ..., n*n are present (thus each number appears exactly once)
     * - the sums of the numbers in each row, each column and both main diagonals are the same
     *
     *   For instance a 3 x 3 magic square is the following
     *
     *   2 7 6
     *   9 5 1
     *   4 3 8
     *
     *   You have to implement the method that verifies if a matrix is a valid magic square
     */

    /**
     *
     * @param matrix a square matrix of size n x n
     * @return true if matrix is a n x n magic square, false otherwise
     */
    public static boolean isMagicSquare(int [][] matrix) {
        // TODO Implement the body of this method, feel free to add other methods but do not change the signature of isMagiSquare
        int n = matrix.length;
        //checking row and column
        int oldrowsum = 0;
        int oldcolumnsum = 0;
        int diag1 = 0;
        int diag2 = 0;
        int number;
        int [] elements = new int[n * n];
        for (int i = 0; i <= n-1; i++){
            int rowsum = 0;
            int columnsum = 0;
            for(int j = 0; j <= n-1; j++){
                rowsum += matrix[i][j];
                columnsum += matrix[j][i];
                //checking elements
                number = matrix[i][j];
                if (number < 1 || number > n*n || elements[number-1] != 0){
                    return false;
                }
                elements[number-1] = number;
            }
            if (i == 0) {
                oldrowsum = rowsum;
                oldcolumnsum = columnsum;
            }
            if (rowsum != oldrowsum || columnsum != oldcolumnsum){
                return false;
            }
            // checking diag
            diag1 += matrix[i][i];
            diag2 += matrix[i][n-1-i];
        }
        if(diag1 != diag2){
            return false;
        }
        return true;
    }
}
