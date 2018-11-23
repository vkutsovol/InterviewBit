package arrays.simulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

class PascalArrayTest {
    private PascalArray pascalArray = new PascalArray();

    private static Stream<Arguments> valuesProvider() {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>(Collections.singletonList(1));
        ArrayList<Integer> second = new ArrayList<>(Arrays.asList(1, 1));
        ArrayList<Integer> third = new ArrayList<>(Arrays.asList(1, 2, 1));
        ArrayList<Integer> fourth = new ArrayList<>(Arrays.asList(1, 3, 3, 1));
        ArrayList<Integer> fifth = new ArrayList<>(Arrays.asList(1, 4, 6, 4, 1));
        list.add(first);
        list.add(second);
        list.add(third);
        list.add(fourth);
        list.add(fifth);
        return Stream.of(
                Arguments.arguments(new ArrayList<>(), 0),
                Arguments.arguments(new ArrayList<>(Collections.singletonList(first)), 1),
                Arguments.arguments(new ArrayList<>(Arrays.asList(first, second)), 2),
                Arguments.arguments(new ArrayList<>(Arrays.asList(first, second, third)), 3),
                Arguments.arguments(list, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(ArrayList<ArrayList<Integer>> expected, Integer numberOfRows) {
        Assertions.assertEquals(expected, pascalArray.solve(numberOfRows));
    }
}