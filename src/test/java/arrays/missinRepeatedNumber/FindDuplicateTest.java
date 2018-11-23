package arrays.missinRepeatedNumber;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static arrays.missinRepeatedNumber.FindDuplicate.NO_REPEATED_NUMBER_VALUE;

class FindDuplicateTest {

    private FindDuplicate findDuplicate = new FindDuplicate();

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(List<Integer> list, int expectedRepeatedNumber) {
        Assertions.assertEquals(findDuplicate.repeatedNumber(list), expectedRepeatedNumber);
    }

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(Collections.emptyList(), NO_REPEATED_NUMBER_VALUE),
                Arguments.arguments(Collections.singletonList(1), NO_REPEATED_NUMBER_VALUE),
                Arguments.arguments(Arrays.asList(1, 2, 3), NO_REPEATED_NUMBER_VALUE),
                Arguments.arguments(Arrays.asList(1, 1, 2, 2), 1),
                Arguments.arguments(Arrays.asList(3, 2, 3, 1, 2, 5), 3),
                Arguments.arguments(Arrays.asList(1, 2, 3, 4, 5, 6, 4, 5, 4), 4),
                Arguments.arguments(Arrays.asList(5, 5, 5, 5), 5)
        );
    }
}