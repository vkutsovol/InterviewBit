package arrays.simulation;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Given numRows, generate the first numRows of Pascal’s triangle.
 * <p>
 * Pascal’s triangle : To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1.
 * <p>
 * Example:
 * <p>
 * Given numRows = 5,
 * <p>
 * Return
 * <p>
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
class PascalArray {
    ArrayList<ArrayList<Integer>> solve(int A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == 0) return result;
        result.add(new ArrayList<>(Collections.singletonList(1)));
        for (int i = 1; i < A; i++) {
            result.add(generateNextRow(result.get(i - 1)));
        }
        return result;
    }

    private ArrayList<Integer> generateNextRow(ArrayList<Integer> input) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 1; i < input.size(); i++) {
            result.add(input.get(i - 1) + input.get(i));
        }
        result.add(1);
        return result;
    }
}
