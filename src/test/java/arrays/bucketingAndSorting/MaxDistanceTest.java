package arrays.bucketingAndSorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class MaxDistanceTest {

    private final MaxDistance maxDistance = new MaxDistance();

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(int expectedRepeatedNumber, List<Integer> list) {
        Assertions.assertEquals(expectedRepeatedNumber, maxDistance.maximumGap(list));
    }

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(5, Arrays.asList(5,5,5,6,5,5,4)),
                Arguments.arguments(2, Arrays.asList(3,5,4,2))
        );
    }
}