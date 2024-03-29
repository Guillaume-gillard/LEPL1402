package complexity;

import java.util.ArrayList;
import java.util.HashMap;

public class MaximumSumSubarray {
    
    /**
     * Class representing a sub-array in an array. It is defined by the start
     * and end position (both inclusive) of the sub-array in the array
     */
    public static class ArrayIndex {
        int start;
        int end;

        public ArrayIndex(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public boolean equals(Object other) {
            if (other instanceof ArrayIndex) {
                ArrayIndex o = (ArrayIndex) other;
                return o.start == this.start && o.end == this.end;
            }
            return false;
        }
        @Override
        public String toString() {
            return String.format("(%d, %d)", this.start, this.end);
        }
    }
    
    /**
     * Finds the contiguous sub-array for which the sum of its elements is maximal.
     * If multiple sub-arrays have the same maximal sum, returns the one that starts at
     * the lowest index.
     * 
     * For example, in the sub-array [1 ,1 , 3, -10, 3, 4, -5, -3, 2, 1], the methods returns
     * (4, 5).
     * 
     * @param array A non-empty array filled with non-zero integers (which might be negative)
     * @return The position of the array for which the sum of its element is maximal (if there
     *          is a tie, the one that starts the earliest is returned)
     */
    public static ArrayIndex maximumSumSubarray(int [] array) {
        ArrayIndex bestSlice = new ArrayIndex(0, 0);
        int bestSum = Integer.MIN_VALUE;
        int currentSum = array[0];
        int start = 0;
        for (int end = 1; end < array.length; end++){
            currentSum += array[end];
            if (currentSum > bestSum){
                bestSum = currentSum;
                bestSlice.start = start;
                bestSlice.end = end;
            }
            if (currentSum < 0){
                currentSum = 0;
                start = end + 1;
            }
        }
        return bestSlice;
    }
}
