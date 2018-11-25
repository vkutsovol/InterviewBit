package arrays.simulation;

import java.util.ArrayList;

public class AntiDiagonal {
    public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> A) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int arrSize = A.size();
        Point point = new Point(0, 0);
        for (int i = 1; i <= A.get(0).size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            while (!point.isEmpty()) {
                row.add(A.get(point.x).get(point.y));
                point = getNextIndex(point, arrSize);
            }
            point = new Point(0, i);
            result.add(row);
        }

        point = new Point(1, A.get(0).size() - 1);
        for (int i = 2; i <= A.size(); i++) {
            ArrayList<Integer> row = new ArrayList<>();
            while (!point.isEmpty()) {
                row.add(A.get(point.x).get(point.y));
                point = getNextIndex(point, arrSize);
            }
            point = new Point(i, A.get(0).size() - 1);
            result.add(row);
        }
        return result;
    }

    private Point getNextIndex(Point point, Integer arrSize) {
        Point newPoint = new Point();
        if (point.y - 1 >= 0) {
            newPoint.y = point.y - 1;
        }
        if (point.x + 1 < arrSize) {
            newPoint.x = point.x + 1;
        }
        if (newPoint.y < 0 || newPoint.x >= arrSize || newPoint.x < 0 || newPoint.y >= arrSize) {
            return new Point();
        }
        return newPoint;
    }

    class Point {
        int x;
        int y;

        public Point() {
            x = -1;
            y = -1;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isEmpty() {
            return x == -1 && y == -1;
        }
    }
}
