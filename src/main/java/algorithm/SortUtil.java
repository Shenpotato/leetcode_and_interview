package algorithm;

public class SortUtil {

    public static boolean less(Comparable w, Comparable v) {
        return w.compareTo(v) < 0;
    }

    public static boolean more(Comparable w, Comparable v) {
        return w.compareTo(v) > 0;
    }

    public static void exchange(Comparable a[], int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

}
