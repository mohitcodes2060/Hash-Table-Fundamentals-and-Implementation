package Week3_and_week4;

public class Problem6_RiskBinarySearch {

    public static void run() {
        System.out.println("\n--- Problem 6 ---");

        int[] arr = {10, 25, 50, 100};
        int target = 30;

        linearSearch(arr, target);
        binarySearch(arr, target);
    }

    // -------- Linear Search --------
    static void linearSearch(int[] arr, int target) {

        int comparisons = 0;

        for (int x : arr) {
            comparisons++;

            if (x == target) {
                System.out.println("Linear: Found (" + comparisons + " comps)");
                return;
            }
        }

        System.out.println("Linear: Not Found (" + comparisons + " comps)");
    }

    // -------- Binary Search (Floor & Ceiling) --------
    static void binarySearch(int[] arr, int target) {

        int low = 0, high = arr.length - 1;
        int floor = -1, ceil = -1, comparisons = 0;

        while (low <= high) {
            comparisons++;

            int mid = (low + high) / 2;

            if (arr[mid] == target) {
                floor = ceil = arr[mid];
                break;
            } else if (arr[mid] < target) {
                floor = arr[mid];
                low = mid + 1;
            } else {
                ceil = arr[mid];
                high = mid - 1;
            }
        }

        System.out.println("Binary -> Floor: " + floor +
                ", Ceil: " + ceil +
                ", Comparisons: " + comparisons);
    }
}