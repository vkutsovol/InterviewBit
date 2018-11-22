package arrays.simulation;

import java.util.ArrayList;
import java.util.List;

public class PascalArray {
    public static void main(String[] args) {
        System.out.println(generatePascal(4));

    }

    public static ArrayList<Integer> generatePascal(int A) {
        List<List<Integer>> pascal = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        pascal.add(first);
        List<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        pascal.add(second);
        List<Integer> third = new ArrayList<>();
        third.add(1);
        third.add(2);
        third.add(1);
        pascal.add(third);
        for (int i = 3; i <= A; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            System.out.println(pascal.get(i-1));
            for (int j = 1; j < (i +2) /2; j++) {
                int sum = pascal.get(i-1).get(j-1) + pascal.get(i-1).get(j);
                row.add(sum);
            }
            if ((i+1)%2 == 0) {
                int size = row.size() - 1;
                for (int   q  = size; q >= 0; q--) {
                    row.add(row.get(q));
                }
            } else {
                int size = row.size() - 2;
                for (int   q  = size; q >= 0; q--) {
                    row.add(row.get(q));
                }
            }
            System.out.println(row);
            pascal.add(row);
        }
        return (ArrayList<Integer>) pascal.get(A);
    }

    static void print(List<List<Integer>> arr) {
        System.out.println("Pascal:");
        for (List<Integer> aPascal : arr) {
            System.out.println(aPascal);
        }
        System.out.println("------------------");
    }

}
