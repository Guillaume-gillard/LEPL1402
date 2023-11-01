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

    int len = data.length;

    /**
     * Return true if the other matrix is identical up to
     * 0, 1, 2 or 3 number of rotations
     * @param o the other matrix to compare to
     * @return
     */

    private boolean zero_rotationcheck (boolean [][] matrix1, boolean [][] matrix2){
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if(matrix1[i][j] != matrix2[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean one_rotationcheck (boolean [][] matrix1, boolean [][] matrix2){
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if(matrix1[i][j] != matrix2[j][len-i-1]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean two_rotationcheck (boolean [][] matrix1, boolean [][] matrix2){
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if(matrix1[i][j] != matrix2[len-i-1][len-j-1]){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean three_rotationcheck (boolean [][] matrix1, boolean [][] matrix2){
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if(matrix1[i][j] != matrix2[len-j-1][i]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        boolean same = false;
        if (zero_rotationcheck(data, o)){
            same = true;
        }
        if (one_rotationcheck(data, o)){
            same = true;
        }
        if (two_rotationcheck(data, o)){
            same = true;
        }
        if (three_rotationcheck(data, o)){
            same = true;
        }
        return same;
    }
}
