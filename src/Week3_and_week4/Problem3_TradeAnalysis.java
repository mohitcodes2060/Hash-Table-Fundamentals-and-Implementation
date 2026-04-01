package Week3_and_week4;

import java.util.*;

public class Problem3_TradeAnalysis {

    public static void run() {
        System.out.println("\n--- Problem 3 ---");

        int[] arr = {500, 100, 300};

        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Merge: " + Arrays.toString(arr));

        quickSort(arr, 0, arr.length - 1);
        reverse(arr);
        System.out.println("Quick DESC: " + Arrays.toString(arr));

        System.out.println("Total: " + Arrays.stream(arr).sum());
    }

    static void mergeSort(int[] a, int l, int r) {
        if (l >= r) return;
        int m = (l + r) / 2;

        mergeSort(a, l, m);
        mergeSort(a, m + 1, r);
        merge(a, l, m, r);
    }

    static void merge(int[] a, int l, int m, int r) {
        int[] t = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;

        while (i <= m && j <= r)
            t[k++] = (a[i] <= a[j]) ? a[i++] : a[j++];

        while (i <= m) t[k++] = a[i++];
        while (j <= r) t[k++] = a[j++];

        System.arraycopy(t, 0, a, l, t.length);
    }

    static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            int p = partition(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
    }

    static int partition(int[] a, int l, int r) {
        int pivot = a[r], i = l - 1;

        for (int j = l; j < r; j++) {
            if (a[j] < pivot) {
                i++;
                int t = a[i]; a[i] = a[j]; a[j] = t;
            }
        }

        int t = a[i + 1]; a[i + 1] = a[r]; a[r] = t;
        return i + 1;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int t = a[i];
            a[i] = a[a.length - 1 - i];
            a[a.length - 1 - i] = t;
        }
    }
}