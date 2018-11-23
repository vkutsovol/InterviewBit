package arrays.missinRepeatedNumber;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a read only array of n + 1 integers between 1 and n, find one number that repeats in linear time using less than O(n) space and traversing the stream sequentially O(1) times.
 * <p>
 * Sample Input:
 * [3 4 1 4 1]
 * Sample Output:
 * 1
 * If there are multiple possible answers ( like in the sample case above ), output any one.
 * <p>
 * If there is no duplicate, output -1
 */

class FindDuplicate {
    static int NO_REPEATED_NUMBER_VALUE = -1;

    /**
     * @param a @NotNull
     * @return repeatedNumber
     */
    int repeatedNumber(final List<Integer> a) {
        Set<Integer> hashSet = new HashSet<>();
        for (Integer element : a) {
            if (!hashSet.add(element)) {
                return element;
            }
        }
        return NO_REPEATED_NUMBER_VALUE;
    }
}
