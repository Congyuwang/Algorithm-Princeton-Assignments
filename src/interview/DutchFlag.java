package interview;

import java.util.Arrays;
import java.util.Random;

/**
 * Dutch national flag problem solution.
 * The algorithm opens the buckets n times.
 */
public class DutchFlag {

    /**
     * Sort the buckets and return the number of swaps and openings used.
     * @param c the buckets
     * @return the number of swaps used, and the number of times opening the
     *         buckets.
     */
    public static int[] sortPebbles(PebbleColor[] c) {
        assert(c.length > 2);

        int swapCount = 0;
        int openBucketCount = 0;

        int p1 = 0;
        int p = 0;
        int p2 = c.length;

        while (p < p2) {
            openBucketCount++;
            switch(c[p]) {
                case R:
                    swap(c, p++, p1++);
                    swapCount++;
                    break;
                case B:
                    swap(c, p, --p2);
                    swapCount++;
                    break;
                case W:
                    p++;
                    break;
                default:
                    break;
            }
        }

        // return the counting statistics.
        return new int[] {swapCount, openBucketCount};
    }

    public static boolean isSorted(PebbleColor[] a) {
        int i = 1;
        for (; i < a.length; i++) {
            if (!PebbleColor.R.equals(a[i])) {
                break;
            }
        }
        for(; i < a.length; i++) {
            if (!PebbleColor.W.equals(a[i])) {
                break;
            }
        }
        for (; i < a.length - 1; i++) {
            if (!PebbleColor.B.equals(a[i])) {
                return false;
            }
        }
        return true;
    }

    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void test(int testLength, boolean printArray) {
        Random random = new Random();
        PebbleColor[] pebbles = new PebbleColor[testLength];
        for (int i = 0; i < testLength; i++) {
            int j = random.nextInt(3);
            switch (j) {
                case 0:
                    pebbles[i] = PebbleColor.R;
                    break;
                case 1:
                    pebbles[i] = PebbleColor.W;
                    break;
                case 2:
                    pebbles[i] = PebbleColor.B;
                    break;
                default:
                    break;
            }
        }
        if (printArray) {
            System.out.printf("Before sorting: %s\n", Arrays.toString(pebbles));
            System.out.printf(" Is sorted?              : %b\n", isSorted(pebbles));
        }
        int[] statistics = sortPebbles(pebbles);
        if (printArray) {
            System.out.printf(" After sorting: %s\n", Arrays.toString(pebbles));
        }
        System.out.printf(" Is sorted?              : %b\n", isSorted(pebbles));
        System.out.printf(" Number of swap          : %d\n", statistics[0]);
        System.out.printf(" Number of bucket opening: %d\n", statistics[1]);
    }

    public static void main(String[] args) {
        test(6, true);
        test(20, true);
        for (int i = 1; i < 20; i++) {
            test(1000, false);
        }
    }
}
