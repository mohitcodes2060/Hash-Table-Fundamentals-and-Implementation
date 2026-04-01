package Week3_and_week4;

import java.util.*;

public class Problem5_AccountLookup {

    public static void run() {
        System.out.println("\n--- Problem 5 ---");

        String[] arr = {"accB", "accA", "accB", "accC"};

        linearSearch(arr, "accB");

        Arrays.sort(arr);
        System.out.println("Sorted: " + Arrays.toString(arr));

        binarySearch(arr, "accB");
    }

    // -------- Linear Search --------
    static void linearSearch(String[] arr, String target) {

        int first = -1, last = -1, comparisons = 0;

        for (int i = 0; i < arr.length; i++) {
            comparisons++;

            if (arr[i].equals(target)) {
                if (first == -1) first = i;
                last = i;
            }
        }

        System.out.println("Linear -> First: " + first +
                ", Last: " + last +
                ", Comparisons: " + comparisons);
    }

    // -------- Binary Search + Count --------
    static void binarySearch(String[] arr, String target) {

        int low = 0, high = arr.length - 1, comparisons = 0;
        int index = -1;

        while (low <= high) {
            comparisons++;

            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                index = mid;
                break;
            } else if (arr[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // Count duplicates
        int count = 0;
        for (String s : arr) {
            if (s.equals(target)) count++;
        }

        System.out.println("Binary -> Index: " + index +
                ", Count: " + count +
                ", Comparisons: " + comparisons);
    }
}