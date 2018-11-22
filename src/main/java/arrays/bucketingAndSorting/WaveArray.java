package arrays.bucketingAndSorting;

import java.util.Arrays;
import java.util.List;

public class WaveArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(wave(arr)));
    }

    public static int[] wave(int[] A) {
        Arrays.sort(A);
        for (int i = 1; i < A.length; i=i+2) {
            int buffer = A[i];
            A[i] = A[i-1];
            A[i-1] = buffer;
        }
        return A;
    }
}
