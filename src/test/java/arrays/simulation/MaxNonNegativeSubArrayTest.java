package arrays.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

class MaxNonNegativeSubArrayTest {
    private MaxNonNegativeSubArray maxNonNegativeSubArray = new MaxNonNegativeSubArray();

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(1, 2, -1, 2, 1))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(1, 3, 5, 3, 0)), new ArrayList<>(Arrays.asList(1, 3, 5, 3, 0, -3, -5, -2, 2, 3, 5, -3, 5, 2))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(2, 3, 5)), new ArrayList<>(Arrays.asList(1, 3, 0, -3, -5, -2, 2, 3, 5, -3, 1, 3, 0, 0))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(1, 3, 0, 0)), new ArrayList<>(Arrays.asList(1, 3, 0, -3, -5, -2, 1, 1, 1, -3, 1, 3, 0, 0))),
                Arguments.arguments(new ArrayList<>(Arrays.asList()), new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1, -1))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(424238335)), new ArrayList<>(Arrays.asList(-846930886, -1714636915, 424238335, -1649760492))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(2, 1)), new ArrayList<>(Arrays.asList(-1, 2, 1, -2, -4, 1, 2, -2))),
                // Integer overflow case
                Arguments.arguments(new ArrayList<>(Arrays.asList(1101513929, 1315634022)), new ArrayList<>(Arrays.asList(336465782, -278722862, -2145174067, 1101513929, 1315634022, -1369133069, 1059961393, 628175011, -1131176229, -859484421)))
        );
    }

    private static Stream<Arguments> splitTest() {
        ArrayList<ArrayList<Integer>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(Arrays.asList(1, 3, 5, 3, 0)));
        expected.add(new ArrayList<>(Arrays.asList(2, 3, 5)));
        expected.add(new ArrayList<>(Arrays.asList(5, 2)));
        return Stream.of(
                Arguments.arguments(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(5, 2)))), new ArrayList<>(Arrays.asList(-3, 5, 2))),
                Arguments.arguments(expected, new ArrayList<>(Arrays.asList(1, 3, 5, 3, 0, -3, -5, -2, 2, 3, 5, -3, 5, 2))),
                Arguments.arguments(new ArrayList<>(), new ArrayList<>(Arrays.asList(-1, -2, -3))),
                Arguments.arguments(new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(1, 2, 3)))), new ArrayList<>(Arrays.asList(1, 2, 3)))
        );
    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(ArrayList<Integer> expected, ArrayList<Integer> inputList) {
        Assertions.assertEquals(expected, maxNonNegativeSubArray.maxset(inputList));
    }

    @ParameterizedTest
    @MethodSource("splitTest")
    void splitArrayOnSubArrays(ArrayList<ArrayList<Integer>> expected, ArrayList<Integer> input) {
        Assertions.assertEquals(expected, maxNonNegativeSubArray.splitArrayOnSubArrays(input));
    }
}