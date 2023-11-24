package basics;

import java.util.Arrays;

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

    public Boolean[][] rotateMatrix(QRcode[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        Boolean[][] rotated_matrix = new Boolean[column][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                rotated_matrix[j][row - 1 - i] = matrix[i]  [j];
            }
        }
        return rotated_matrix;
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
        if (o == null || getClass() != o.getClass()) return false;
        int elements = data.length * data[0].length;
        QRcode QR_to_check = (QRcode) o;
        boolean [][] matrix_to_check = QR_to_check.data;
        // checking first rotation
        for (int k = 0; k <= 4; k++) {
            int count = 0;
            for (int i = 0; i < data.length; i++){
                for (int j = 0; j < data[0].length; j++){
                    if (matrix_to_check[i][j] == data[i][j]) count++;
                }
            }
            matrix_to_check = rotateMatrix(matrix_to_check);
            if (count == elements) return true;
        }
        return false;
    }
}
