package arrays.valueRanges;

import java.util.ArrayList;

public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        if (newInterval.start > newInterval.end) {
            int buff = newInterval.start;
            newInterval.start = newInterval.end;
            newInterval.end = buff;
        }
        if (intervals == null || intervals.size() == 0) {
            intervals = new ArrayList<>();
            intervals.add(newInterval);
            return intervals;
        }
        int startPlaceToPut = findStartPlaceToPut(intervals, newInterval);
        int endPlaceToPut = findEndPlaceToPut(intervals, newInterval, startPlaceToPut);

        if (endPlaceToPut < 0) {
            intervals.add(0, newInterval);
            return intervals;
        }

        Interval startInterval = intervals.get(startPlaceToPut < 0 ? 0 : startPlaceToPut);
        Interval endInterval = intervals.get(endPlaceToPut >= intervals.size() ? intervals.size() - 1 : endPlaceToPut);

        if (startInterval.end < newInterval.start) {
            startPlaceToPut++;
        }
        if (endInterval.start > newInterval.end) {
            endPlaceToPut--;
        }

        if (startInterval.end >= newInterval.start) {
            if (startPlaceToPut >= 0) {
                newInterval.start = startInterval.start;
            } else {
                startPlaceToPut = 0;
            }

        }

        if (endInterval.start <= newInterval.end) {
            if (endPlaceToPut < intervals.size()) {
                newInterval.end = endInterval.end;
            }
        }

        if (endPlaceToPut >= intervals.size()) {
            endPlaceToPut = intervals.size() - 1;
        }

        for (int i = endPlaceToPut; i >= startPlaceToPut; i--) {
            intervals.remove(i);
        }

        if (startPlaceToPut == endPlaceToPut) {
            intervals.add(endPlaceToPut, newInterval);
            return intervals;
        }

        intervals.add(startPlaceToPut, newInterval);


        return intervals;
    }

    private Integer findStartPlaceToPut(ArrayList<Interval> intervals, Interval newInterval) {
        int i = 0;
        while (intervals.get(i).start <= newInterval.start) {
            i++;
            if (i >= intervals.size()) {
                break;
            }
        }
        i--;
        return i;
    }

    private Integer findEndPlaceToPut(ArrayList<Interval> intervals, Interval newInterval, int start) {
        int i = start;
        int extraValue = 0;
        if (i < 0) {
            i++;
        }
        while (intervals.get(i).end <= newInterval.end) {
            i++;
            if (i >= intervals.size()) {
                break;
            }
        }
        i = i - extraValue;
        return i;
    }
}
