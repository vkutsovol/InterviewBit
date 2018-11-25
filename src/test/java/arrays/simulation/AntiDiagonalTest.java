package arrays.simulation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AntiDiagonalTest {

    AntiDiagonal antiDiagonal = new AntiDiagonal();

    private static Stream<Arguments> valuesProvider() {
        return Stream.of(
                Arguments.arguments(new int[][]{{1}, {2, 4}, {3, 5, 7}, {6, 8,}, {9}}, new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})
        );


    }

    private static ArrayList<ArrayList<Integer>> convertToList(int[][] array) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < array[i].length; j++) {
                row.add(array[i][j]);
            }
            result.add(row);
        }
        return result;
    }

    @ParameterizedTest
    @MethodSource("valuesProvider")
    void main(int[][] expected, int[][] input) {
        assertEquals(convertToList(expected), antiDiagonal.diagonal(convertToList(input)));
    }

}