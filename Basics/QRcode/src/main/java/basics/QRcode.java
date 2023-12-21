package basics;

/**
 * Make sure that the equal method consider
 * two QR codes as identical if they have been flipped
 * by 0,1,2 or 3 quarter rotations
 *
 * For instance the two following matrices should be
 * considered equals if you flip your head by 180 degrees
 *
 *         boolean [][] t0 = new boolean[][] {
 *                 {false,true,false,false},
 *                 {false,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,true}
 *         };
 *
 *         // t2 is a version of t2 with two quarter rotations
 *         boolean [][] t2 = new boolean[][] {
 *                 {true,false,true,true},
 *                 {true,false,false,true},
 *                 {true,true,false,false},
 *                 {false,false,true,false}
 *         };
 */
public class QRcode {

    protected boolean [][] data;

    /**
     * Create a QR code object
     * @param data is a n x n square matrix
     */
    public QRcode(boolean [][] data) {
        this.data = data;
    }

    private boolean CheckRow (boolean[] row1, boolean[] row2){
        for (int i = 0; i < row1.length; i++){
            if (row1[i] != row2[i]) return false;
        }
        return true;
    }

    private boolean CheckMatrix(boolean[][] matrix1, boolean[][] matrix2){
        for (int i = 0; i < matrix1.length; i++){
            if (!CheckRow(matrix1[i], matrix2[i])) return false;
        }
        return true;
    }

    private boolean[][] RotateMatrix (boolean[][] matrix){
        int row = matrix.length;
        int column = matrix[0].length;
        boolean[][] rotatedMatrix = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rotatedMatrix[j][row - 1 - i] = matrix[i]  [j];
            }
        }
        return rotatedMatrix;
    }




    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     * @param o the other matrix to compare to
     * @return
     */
    @Override
    public boolean equals(Object o) {
        // TODO
        // BEGIN STRIP
        if (this == o) return true;
        QRcode qRcode = (QRcode) o;
        boolean[][] matrix = qRcode.data;
        for (int i = 0; i <= 3; i++){
            if (CheckMatrix(this.data, matrix)) return true;
            matrix = RotateMatrix(matrix);
        }
        return false;
    }
}
