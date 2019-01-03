package arrays.missinRepeatedNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static arrays.missinRepeatedNumber.N3Repeat.NO_REPEATED_NUMBER_VALUE;


class N3RepeatTest {
    private N3Repeat n3Repeat = new N3Repeat();

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(int expectedRepeatedNumber, List<Integer> list) {
        Assertions.assertEquals(expectedRepeatedNumber, n3Repeat.repeatedNumber(list));
    }

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(NO_REPEATED_NUMBER_VALUE, Arrays.asList(1, 2, 3)),
                Arguments.arguments(1, Arrays.asList(1, 2, 1)),
                Arguments.arguments(1, Arrays.asList(1, 2, 3, 1, 1))
        );
    }
}