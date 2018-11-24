package arrays.simulation;

import java.util.ArrayList;
import java.util.Comparator;

public class MaxNonNegativeSubArray {
    public ArrayList<Integer> maxset(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> subArrays = splitArrayOnSubArrays(A);
        subArrays.sort(getComparator());
        return subArrays.size() > 0 ? subArrays.get(0) : new ArrayList<>();
    }

    ArrayList<ArrayList<Integer>> splitArrayOnSubArrays(ArrayList<Integer> array) {
        ArrayList<ArrayList<Integer>> subArrays = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) >= 0 && i != array.size() - 1) {
                continue;
            }
            if (array.get(i) < 0 && start == i) {
                start = i + 1;
                continue;
            }
            if (i == array.size() - 1 && array.get(i) >= 0) {
                i++;
            }
            subArrays.add(new ArrayList<>(array.subList(start, i)));
            start = i + 1;
        }
        return subArrays;
    }

    Comparator<ArrayList<Integer>> getComparator() {
        return (o1, o2) -> {
            long sum1 = getSumOfElement(o1);
            long sum2 = getSumOfElement(o2);
            if (sum1 < sum2) {
                return 1;
            } else if (sum1 > sum2) {
                return -1;
            } else {
                if (o1.size() <= o2.size()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        };
    }

    long getSumOfElement(ArrayList<Integer> list) {
        long sum = 0;
        for (int el : list) {
            sum += el;
        }
        return sum;
    }
}
