package arrays.bucketingAndSorting;

import java.util.ArrayList;
import java.util.Arrays;

public class HotelBookingsPossible {
    /*
     * Performance is important this time
     * */
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        if (arrive.size() != depart.size() || K == 0 && arrive.size() > 0) {
            return false;
        }
        int[] arrives = new int[arrive.size()];
        int[] departs = new int[arrive.size()];

        // Why with stream it's slower almost twice???
        for (int i = 0; i < arrives.length; i++) {
            arrives[i] = arrive.get(i);
            departs[i] = depart.get(i);
        }
        Arrays.sort(arrives);
        Arrays.sort(departs);

        int i = 0, j = 0, counter = 0, max = 0;

        while (i < arrives.length && j < departs.length) {
            if (arrives[i] < departs[j]) {
                counter++;
                if (counter > max) {
                    max = counter;
                }
                i++;
            } else {
                counter--;
                j++;
            }
        }
        if (max > K) {
            return false;
        }

        return true;
    }

}
