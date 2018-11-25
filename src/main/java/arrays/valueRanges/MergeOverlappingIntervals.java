package arrays.valueRanges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MergeOverlappingIntervals {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        intervals.sort((o1, o2) -> {
            if (o1.start < o2.start) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println(intervals);
        int i = 1;
        while (i < intervals.size()) {
            ArrayList<Interval> merged = mergeIntervals(intervals.get(i - 1), intervals.get(i));
            if (merged.size() == 1) {
                intervals.set(i - 1, merged.get(0));
                intervals.remove(i);
            } else {
                i++;
            }
        }
        return intervals;
    }

    ArrayList<Interval> mergeIntervals(Interval i1, Interval i2) {
        if (i1.end >= i2.start) {
            int maxEnd = Math.max(i1.end, i2.end);
            return new ArrayList<>(Collections.singletonList(new Interval(i1.start, maxEnd)));
        }
        return new ArrayList<>(Arrays.asList(i1, i2));
    }


}
