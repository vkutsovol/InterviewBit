package arrays.math;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumAbsoluteDifferenceTest {
    MaximumAbsoluteDifference maximumAbsoluteDifference = new MaximumAbsoluteDifference();

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(5, new ArrayList<>(Arrays.asList(1, 3, -1))),
                Arguments.arguments(1, new ArrayList<>(Arrays.asList()))

        );
    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(int expected, ArrayList<Integer> input) {
        assertEquals(expected, maximumAbsoluteDifference.maxArr(input));
    }
}