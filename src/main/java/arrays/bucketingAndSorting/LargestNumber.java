package arrays.bucketingAndSorting;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        // Streams are slow, almost one line solution fails time execution limit!
        List<String> strings = new ArrayList<>();
        for (Integer aA : A) {
            strings.add(String.valueOf(aA));
        }
        strings.sort(this::compareFunction);
        StringBuilder stringBuilder = new StringBuilder();
        for (String element : strings) {
            if ("0".equals(element) && stringBuilder.length() == 0) {
                continue;
            }
            stringBuilder.append(element);
        }
        String result = stringBuilder.toString();
        return result.length() == 0 ? "0" : result;
    }

    private int compareFunction(String a, String b) {
        String val1 = a.concat(b);
        String val2 = b.concat(a);
        return val2.compareTo(val1);
    }

}
