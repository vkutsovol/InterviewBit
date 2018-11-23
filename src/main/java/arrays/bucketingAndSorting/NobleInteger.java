package arrays.bucketingAndSorting;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
 * If such an integer is found return 1 else return -1.
 */

class NobleInteger {
    int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        System.out.println(A);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) == A.size() - i - 1) {
                if (i == A.size() - 1 || i + 1 < A.size() && !A.get(i).equals(A.get(i + 1))) {
                    return 1;
                }
            }
            if (A.get(i) >= A.size() - i - 1) {
                break;
            }
        }
        return -1;
    }
}
