package arrays.bucketingAndSorting;

import java.util.Arrays;
import java.util.List;

public class MaxDistance {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        int maxDiff;
        int i, j;
        int n = A.size();

        int[] LMin = new int[n];
        int[] RMax = new int[n];

       /* Construct LMin[] such that LMin[i] stores the minimum value
           from (arr[0], arr[1], ... arr[i]) */
        LMin[0] = A.get(0);
        for (i = 1; i < n; ++i)
            LMin[i] = Math.min(A.get(i), LMin[i - 1]);
        System.out.println(Arrays.toString(LMin));
        /* Construct RMax[] such that RMax[j] stores the maximum value
           from (arr[j], arr[j+1], ..arr[n-1]) */
        RMax[n - 1] = A.get(n - 1);
        for (j = n - 2; j >= 0; --j)
            RMax[j] = Math.max(A.get(j), RMax[j + 1]);
        System.out.println(Arrays.toString(RMax));
        /* Traverse both arrays from left to right to find optimum j - i
            This process is similar to merge() of MergeSort */
        i = 0;
        j = 0;
        maxDiff = 0;
        while (j < n && i < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j = j + 1;
            } else
                i = i + 1;
        }

        return maxDiff;
    }

// O(nlogn) solution
  /*  public int maximumGap(final List<Integer> A) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            pairs.add(new Pair(A.get(i), i));
        }
        pairs.sort(Comparator.comparingInt(a -> a.number));
        int max = -1;
        for (int i = pairs.size() - 1; i >= 0; i--) {
            int maxDiff = findMaxDifference(pairs, i, pairs.get(i).index);
            if (maxDiff > max) {
                max = maxDiff;
            }
        }
        return max < 0 ? -1 : max;
    }

    private int findMaxDifference(List<Pair> list, int upperBound,  Integer number) {
        int max = 0;
        for (int i = 0; i < upperBound; i++) {
            int diff = number - list.get(i).index;
            if (diff > max) {
                max = diff;
            }
        }
        return max;
    }

    static class Pair {
        int number;
        int index;

        public Pair(int number, int index) {
            this.number = number;
            this.index = index;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "number=" + number +
                    ", index=" + index +
                    '}';
        }
    }
    */
}
