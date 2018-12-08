package arrays.arrangement;

import java.util.ArrayList;
import java.util.Collections;

public class RotateMatrix {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        diagonalMirror(a);
    }

    public ArrayList<ArrayList<Integer>> diagonalMirror(ArrayList<ArrayList<Integer>> list) {

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                swap2D(list, new Pair(i, j), new Pair(list.size() - 1 - j, list.size() - 1 - i));
            }
        }
        list = verticalMirror(list);
        return list;
    }

    public ArrayList<ArrayList<Integer>> verticalMirror(ArrayList<ArrayList<Integer>> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Collections.swap(list, i, list.size() - 1 - i);
        }
        return list;
    }

    public ArrayList<ArrayList<Integer>> swap2D(ArrayList<ArrayList<Integer>> list, Pair first, Pair second) {
        Integer f = list.get(first.a).get(first.b);
        Integer s = list.get(second.a).get(second.b);
        list.get(first.a).set(first.b, s);
        list.get(second.a).set(second.b, f);
        return list;
    }

    static class Pair {
        int a;
        int b;

        public Pair(int first, int second) {
            this.a = first;
            this.b = second;
        }
    }

}
