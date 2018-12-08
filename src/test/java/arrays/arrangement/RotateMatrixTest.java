package arrays.arrangement;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

class RotateMatrixTest {
    private RotateMatrix rotateMatrix = new RotateMatrix();

/*    private static Stream<Arguments> valuesProviderVertical() {
        List<Integer> actual = new ArrayList<>();
        actual.add(1);
        actual.add(2);
        actual.add(3);
        actual.add(4);
        actual.add(5);

        List<Integer> expected = new ArrayList<>();
        expected.add(5);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        expected.add(1);
        return Stream.of(
                Arguments.arguments(actual, expected)
        );
    }

    @ParameterizedTest
    @MethodSource("valuesProviderswap")
    void main1(ArrayList<Object> actual, ArrayList<Integer> expected) {
        Assertions.assertEquals(expected, rotateMatrix.verticalMirror(actual));
    }*/

    private static Stream<Arguments> valuesProviderswap() {
        ArrayList<ArrayList<Integer>> actual = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(2);
        first.add(3);
        ArrayList<Integer> second = new ArrayList<>();
        second.add(4);
        second.add(5);
        second.add(6);
        ArrayList<Integer> third = new ArrayList<>();
        third.add(7);
        third.add(8);
        third.add(9);

        actual.add(first);
        actual.add(second);
        actual.add(third);


        return Stream.of(
                Arguments.arguments(actual, null)
        );
    }

    private static Stream<Arguments> valuesProviderD() {
        ArrayList<ArrayList<Integer>> actual = new ArrayList<>();
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        first.add(2);
//        first.add(3);
        ArrayList<Integer> second = new ArrayList<>();
        second.add(3);
        second.add(4);
//        second.add(6);
        ArrayList<Integer> third = new ArrayList<>();
        third.add(7);
        third.add(8);
        third.add(9);

        actual.add(first);
        actual.add(second);
//        actual.add(third);


        return Stream.of(
                Arguments.arguments(actual, null)
        );
    }

    @ParameterizedTest
    @MethodSource("valuesProviderswap")
    void main(ArrayList<ArrayList<Integer>> actual, ArrayList<ArrayList<Integer>> expected) {
        Assertions.assertEquals(actual, rotateMatrix.swap2D(actual, new RotateMatrix.Pair(0, 1), new RotateMatrix.Pair(1, 2)));
    }

    @ParameterizedTest
    @MethodSource("valuesProviderD")
    void main3(ArrayList<ArrayList<Integer>> actual, ArrayList<ArrayList<Integer>> expected) {
        Assertions.assertEquals(actual, rotateMatrix.diagonalMirror(actual));
    }
/*
    private ArrayList<ArrayList<Integer>> convertToList(Integer[][] array) {
        return Arrays.stream(array)  //'array' is two-dimensional
                .flatMap(Arrays::stream)
                .collect(Collectors.toList());
    }*/
}