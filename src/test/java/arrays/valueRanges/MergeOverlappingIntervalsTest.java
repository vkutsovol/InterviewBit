package arrays.valueRanges;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


class MergeOverlappingIntervalsTest {

    MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(i(new int[][]{{1, 3}}), i(new int[][]{{1, 2}, {2, 3}})),
                Arguments.arguments(i(new int[][]{{1, 2}, {3, 8}}), i(new int[][]{{1, 2}, {3, 7}, {5, 6}, {6, 8}})),
                Arguments.arguments(i(new int[][]{{1, 2}, {3, 8}}), i(new int[][]{{3, 7}, {1, 2}, {5, 6}, {6, 8}})),
                Arguments.arguments(i(new int[][]{{}}), i(new int[][]{{}}))
        );
    }

    private static List<Interval> i(int[][] input) {
        List<Interval> result = new ArrayList<>();
        if (input.length == 0) {
            return result;
        }
        for (int[] anInput : input) {
            if (anInput.length != 0) {
                result.add(new Interval(anInput[0], anInput[1]));
            }
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(List<Interval> expected, List<Interval> intervals) {
        assertEquals(new ArrayList<>(expected), mergeOverlappingIntervals.merge(new ArrayList<>(intervals)));
    }

}