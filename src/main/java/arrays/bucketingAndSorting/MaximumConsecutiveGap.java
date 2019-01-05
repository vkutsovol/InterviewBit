package arrays.bucketingAndSorting;

import java.util.Arrays;
import java.util.List;

public class MaximumConsecutiveGap {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maximumGap(final List<Integer> A) {
        if (A == null || A.size() <= 1) {
            return 0;
        }
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int n = A.size();
        for (Integer integer : A) {
            minValue = Math.min(minValue, integer);
            maxValue = Math.max(maxValue, integer);
        }
        int maxGap = 0;
        double gap = (double) (maxValue - minValue)/ (n-1);
        int[] minValuesForGaps = new int[A.size()];
        int[] maxValuesForGaps = new int[A.size()];
        Arrays.fill(minValuesForGaps, Integer.MAX_VALUE);
        Arrays.fill(maxValuesForGaps, Integer.MIN_VALUE);
        for (Integer value : A) {
            if (value == minValue || value == maxValue) {
                continue;
            }
            int index = (int) (Math.floor(value - minValue) / gap);
            minValuesForGaps[index] = Math.min(minValuesForGaps[index], value);
            maxValuesForGaps[index] = Math.max(maxValuesForGaps[index], value);
        }
        int previousValue = minValue;
        for (int i = 0; i < n; i++) {
            if (minValuesForGaps[i] ==  Integer.MAX_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, minValuesForGaps[i] - previousValue);
            previousValue = maxValuesForGaps[i];
        }
        maxGap = Math.max(maxGap, maxValue - previousValue);
        return maxGap;

    }
}
