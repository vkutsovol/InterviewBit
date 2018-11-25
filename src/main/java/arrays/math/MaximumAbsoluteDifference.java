package arrays.math;

import java.util.ArrayList;

public class MaximumAbsoluteDifference {
    public int maxArr(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 1;
        }
        // max and min variables as described
        // in algorithm.
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int i = 0; i < A.size(); i++) {

            // Updating max and min variables
            // as described in algorithm.
            max1 = Math.max(max1, A.get(i) + i);
            min1 = Math.min(min1, A.get(i) + i);
            max2 = Math.max(max2, A.get(i) - i);
            min2 = Math.min(min2, A.get(i) - i);
        }

        // Calculating maximum absolute difference.
        return Math.max(max1 - min1, max2 - min2);
/*        int max = 0;
        for (int i = 0; i < A.size(); i++) {
            for (int j = i; j < A.size(); j++) {
                max = Math.max(max, f(A, i, j));
            }
        }
        return max;*/
    }

    // |A[i] - A[j]| + |i - j|
    private int f(ArrayList<Integer> list, int i, int j) {
        return Math.abs(list.get(i) - list.get(j)) + Math.abs(i - j);
    }
}
