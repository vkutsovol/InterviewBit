package arrays.valueRanges;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MergeIntervalsTest {

    private MergeIntervals mergeIntervals = new MergeIntervals();

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(List<Interval> intervals, Interval newInterval, List<Interval> expected) {
        assertEquals(mergeIntervals.insert(new ArrayList<>(intervals), newInterval).toString(), new ArrayList<>(expected).toString());
    }

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(i(new int[][]{{1, 2}, {2, 3}}), new Interval(1, 3), i(new int[][]{{1, 3}})),
                Arguments.arguments(i(new int[][]{{1, 2}, {2, 3}}), new Interval(1, 3), i(new int[][]{{1, 3}})),
                Arguments.arguments(i(new int[][]{{1, 2}, {2, 3}}), new Interval(1, 3), i(new int[][]{{1, 3}})),
                Arguments.arguments(i(new int[][]{{1, 2}, {2, 3}}), new Interval(1, 3), i(new int[][]{{1, 3}})),
                Arguments.arguments(i(new int[][]{{1, 2}, {2, 3}}), new Interval(1, 3), i(new int[][]{{1, 3}})),
                Arguments.arguments(i(new int[][]{{1, 2}, {2, 3}}), new Interval(1, 3), i(new int[][]{{1, 3}})),
                Arguments.arguments(i(new int[][]{{1, 2}, {2, 3}}), new Interval(1, 3), i(new int[][]{{1, 3}}))
        );
    }

    private static List<Interval> i(int[][] input) {
        List<Interval> result = new ArrayList<>();
        for (int[] anInput : input) {
            result.add(new Interval(anInput[0], anInput[1]));
        }
        return result;
    }

    private static Interval convertToInterval(int[] startEnd) {
        return new Interval(startEnd[0], startEnd[1]);
    }
}