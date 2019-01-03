package arrays.missinRepeatedNumber;

import java.util.List;

public class N3Repeat {
    // DO NOT MODIFY THE LIST
    public int repeatedNumber(final List<Integer> a) {
        int len = a.size();

        if (a.size() == 0) {
            return -1;
        }

        if (a.size() == 1) {
            return a.get(0);
        }

        int c1 = a.get(0);
        int c2 = a.get(1);
        int c1count = 0;
        int c2count = 0;

        for (int num : a) {
            if (c1 == num) {
                c1count++;
            } else if (c2 == num) {
                c2count++;
            } else if (c1count == 0) {
                c1 = num;
                c1count = 1;
            } else if (c2count == 0) {
                c2 = num;
                c2count = 1;
            } else {
                c1count--;
                c2count--;
            }
        }

        c1count = 0;
        c2count = 0;
        for (int num : a) {
            if (c1 == num) {
                c1count++;
            } else if (num == c2) {
                c2count++;
            }
        }

        if (c1count > len / 3) {
            return c1;
        } else if (c2count > len / 3) {
            return c2;
        } else {
            return -1;
        }

    }
}
