package princeton.algo.sort;

import java.util.Comparator;

/**
 * A two-pivot quick sort implementation. Use insertion for length shorter than
 * {@code CUTOFF = 8}. This gives better adaptivity and reduces overhead.
 * When sorting primitive types, use three-mean key.
 */
public class Quick {

    private static final int CUTOFF = 12;

    public static <T extends Comparable<? super T>> void sort(T[] a) {
        Shuffle.shuffle(a);
        sort(a, 0, a.length);
    }

    public static <T> void sort(T[] a, Comparator<? super T> c) {
        Shuffle.shuffle(a);
        sort(a, 0, a.length, c);
    }

    public static void sort(int[] a) {
        sort(a, 0, a.length);
    }

    public static void sort(float[] a) {
        sort(a, 0, a.length);
    }

    public static void sort(char[] a) {
        sort(a, 0, a.length);
    }

    public static void sort(long[] a) {
        sort(a, 0, a.length);
    }

    public static void sort(short[] a) {
        sort(a, 0, a.length);
    }

    public static void sort(double[] a) {
        sort(a, 0, a.length);
    }

    private static void sort(int[] a, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }
        int loMem = lo;
        int hiMem = hi;
        int mid = lo;
        int key = medianOf3(a[lo], a[hi - 1], a[(lo + hi - 1) >>> 1]);
        while (mid < hi) {
            int cmp = key - a[mid];
            if (cmp > 0) {
                exch(a, lo++, mid++);
            } else if (cmp < 0) {
                exch(a, --hi, mid);
            } else {
                mid++;
            }
        }
        sort(a, loMem, lo);
        sort(a, hi, hiMem);
    }

    private static void exch(int[] a, int i0, int i1) {
        int temp = a[i0];
        a[i0] = a[i1];
        a[i1] = temp;
    }

    private static int medianOf3(int a1, int a2, int a3) {
        if (a1 > a2) {
            if (a2 > a3) {
                return a2;
            }
            if (a3 > a1) {
                return a1;
            }
        } else {
            if (a3 > a2) {
                return a2;
            }
            if (a1 > a3) {
                return a1;
            }
        }
        return a3;
    }

    private static void sort(float[] a, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }
        int loMem = lo;
        int hiMem = hi;
        int mid = lo;
        float key = medianOf3(a[lo], a[hi - 1], a[(lo + hi - 1) >>> 1]);
        while (mid < hi) {
            float cmp = key - a[mid];
            if (cmp > 0) {
                exch(a, lo++, mid++);
            } else if (cmp < 0) {
                exch(a, --hi, mid);
            } else {
                mid++;
            }
        }
        sort(a, loMem, lo);
        sort(a, hi, hiMem);
    }

    private static void exch(float[] a, int i0, int i1) {
        float temp = a[i0];
        a[i0] = a[i1];
        a[i1] = temp;
    }

    private static float medianOf3(float a1, float a2, float a3) {
        if (a1 > a2) {
            if (a2 > a3) {
                return a2;
            }
            if (a3 > a1) {
                return a1;
            }
        } else {
            if (a3 > a2) {
                return a2;
            }
            if (a1 > a3) {
                return a1;
            }
        }
        return a3;
    }

    private static void sort(char[] a, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }
        int loMem = lo;
        int hiMem = hi;
        int mid = lo;
        char key = medianOf3(a[lo], a[hi - 1], a[(lo + hi - 1) >>> 1]);
        while (mid < hi) {
            int cmp = key - a[mid];
            if (cmp > 0) {
                exch(a, lo++, mid++);
            } else if (cmp < 0) {
                exch(a, --hi, mid);
            } else {
                mid++;
            }
        }
        sort(a, loMem, lo);
        sort(a, hi, hiMem);
    }

    private static void exch(char[] a, int i0, int i1) {
        char temp = a[i0];
        a[i0] = a[i1];
        a[i1] = temp;
    }

    private static char medianOf3(char a1, char a2, char a3) {
        if (a1 > a2) {
            if (a2 > a3) {
                return a2;
            }
            if (a3 > a1) {
                return a1;
            }
        } else {
            if (a3 > a2) {
                return a2;
            }
            if (a1 > a3) {
                return a1;
            }
        }
        return a3;
    }

    private static void sort(long[] a, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }
        int loMem = lo;
        int hiMem = hi;
        int mid = lo;
        long key = medianOf3(a[lo], a[hi - 1], a[(lo + hi - 1) >>> 1]);
        while (mid < hi) {
            long cmp = key - a[mid];
            if (cmp > 0) {
                exch(a, lo++, mid++);
            } else if (cmp < 0) {
                exch(a, --hi, mid);
            } else {
                mid++;
            }
        }
        sort(a, loMem, lo);
        sort(a, hi, hiMem);
    }

    private static void exch(long[] a, int i0, int i1) {
        long temp = a[i0];
        a[i0] = a[i1];
        a[i1] = temp;
    }

    private static long medianOf3(long a1, long a2, long a3) {
        if (a1 > a2) {
            if (a2 > a3) {
                return a2;
            }
            if (a3 > a1) {
                return a1;
            }
        } else {
            if (a3 > a2) {
                return a2;
            }
            if (a1 > a3) {
                return a1;
            }
        }
        return a3;
    }

    private static void sort(short[] a, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }
        int loMem = lo;
        int hiMem = hi;
        int mid = lo;
        short key = medianOf3(a[lo], a[hi - 1], a[(lo + hi - 1) >>> 1]);
        while (mid < hi) {
            int cmp = key - a[mid];
            if (cmp > 0) {
                exch(a, lo++, mid++);
            } else if (cmp < 0) {
                exch(a, --hi, mid);
            } else {
                mid++;
            }
        }
        sort(a, loMem, lo);
        sort(a, hi, hiMem);
    }

    private static void exch(short[] a, int i0, int i1) {
        short temp = a[i0];
        a[i0] = a[i1];
        a[i1] = temp;
    }

    private static short medianOf3(short a1, short a2, short a3) {
        if (a1 > a2) {
            if (a2 > a3) {
                return a2;
            }
            if (a3 > a1) {
                return a1;
            }
        } else {
            if (a3 > a2) {
                return a2;
            }
            if (a1 > a3) {
                return a1;
            }
        }
        return a3;
    }

    private static void sort(double[] a, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }
        int loMem = lo;
        int hiMem = hi;
        int mid = lo;
        double key = medianOf3(a[lo], a[hi - 1], a[(lo + hi - 1) >>> 1]);
        while (mid < hi) {
            double cmp = key - a[mid];
            if (cmp > 0) {
                exch(a, lo++, mid++);
            } else if (cmp < 0) {
                exch(a, --hi, mid);
            } else {
                mid++;
            }
        }
        sort(a, loMem, lo);
        sort(a, hi, hiMem);
    }

    private static void exch(double[] a, int i0, int i1) {
        double temp = a[i0];
        a[i0] = a[i1];
        a[i1] = temp;
    }

    private static double medianOf3(double a1, double a2, double a3) {
        if (a1 > a2) {
            if (a2 > a3) {
                return a2;
            }
            if (a3 > a1) {
                return a1;
            }
        } else {
            if (a3 > a2) {
                return a2;
            }
            if (a1 > a3) {
                return a1;
            }
        }
        return a3;
    }

    private static <T extends Comparable<? super T>> void sort(T[] a, int lo, int hi) {
        if (lo + CUTOFF >= hi) {
            Insertion.sort(a, lo, hi);
            return;
        }
        T key = a[lo];
        int loMem = lo;
        int hiMem = hi;
        int mid = lo;
        while (mid < hi) {
            int cmp = key.compareTo(a[mid]);
            if (cmp > 0) {
                Util.exch(a, lo++, mid++);
            } else if (cmp < 0) {
                Util.exch(a, --hi, mid);
            } else {
                mid++;
            }
        }
        sort(a, loMem, lo);
        sort(a, hi, hiMem);
        assert Util.isSorted(a, loMem, lo);
        assert Util.isSorted(a, hi, hiMem);
    }

    private static <T> void sort(T[] a, int lo, int hi, Comparator<? super T> c) {
        if (lo + CUTOFF >= hi) {
            Insertion.sort(a, lo, hi, c);
            return;
        }
        T key = a[lo];
        int loMem = lo;
        int hiMem = hi;
        int mid = lo;
        while (mid < hi) {
            int cmp = c.compare(key, a[mid]);
            if (cmp > 0) {
                Util.exch(a, lo++, mid++);
            } else if (cmp < 0) {
                Util.exch(a, --hi, mid);
            } else {
                mid++;
            }
        }
        sort(a, loMem, lo, c);
        sort(a, hi, hiMem, c);
        assert Util.isSorted(a, loMem, lo, c);
        assert Util.isSorted(a, hi, hiMem, c);
    }
}