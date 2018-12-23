package arrays.bucketingAndSorting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class LargestNumberTest {
    private LargestNumber largestNumber = new LargestNumber();

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments("12121", Arrays.asList(121, 12)),
                Arguments.arguments("29829", Arrays.asList(29, 298)),
                Arguments.arguments("934", Arrays.asList(34, 9)),
                Arguments.arguments("6496495", Arrays.asList(649, 6495)),
                Arguments.arguments("9534330", Arrays.asList(3, 30, 34, 5, 9)),
                Arguments.arguments("0", Arrays.asList(0, 0, 0, 0, 0)),
                Arguments.arguments("821000", Arrays.asList(10, 8, 2, 0, 0)),
                Arguments.arguments("99197494093090589587787286882579979879178278077273570968668667867566465335024704093953663633573372982927126124019124113", Arrays.asList(782, 240, 409, 678, 940, 502, 113, 686, 6, 825, 366, 686, 877, 357, 261, 772, 798, 29, 337, 646, 868, 974, 675, 271, 791, 124, 363, 298, 470, 991, 709, 533, 872, 780, 735, 19, 930, 895, 799, 395, 905))
        );
    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(String expected, List<Integer> input) {
        long start = System.nanoTime();
        String result = largestNumber.largestNumber(new ArrayList<>(input));
        System.out.println(String.format("Time: %d", System.nanoTime() - start));
        Assertions.assertEquals(expected, result);
    }
}