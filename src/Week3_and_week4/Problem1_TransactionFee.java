package Week3_and_week4;

import java.util.*;

public class Problem1_TransactionFee {

    static class Transaction {
        String id;
        double fee;
        String ts;

        Transaction(String id, double fee, String ts) {
            this.id = id;
            this.fee = fee;
            this.ts = ts;
        }

        public String toString() {
            return id + ":" + fee + "@" + ts;
        }
    }

    public static void run() {
        System.out.println("\n--- Problem 1 ---");

        ArrayList<Transaction> list = new ArrayList<>();
        list.add(new Transaction("id1", 10.5, "10:00"));
        list.add(new Transaction("id2", 25.0, "09:30"));
        list.add(new Transaction("id3", 5.0, "10:15"));

        bubbleSort(list);
        System.out.println("Bubble: " + list);

        insertionSort(list);
        System.out.println("Insertion: " + list);

        outliers(list);
    }

    static void bubbleSort(ArrayList<Transaction> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < list.size() - i - 1; j++) {
                if (list.get(j).fee > list.get(j + 1).fee) {
                    Collections.swap(list, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    static void insertionSort(ArrayList<Transaction> list) {
        for (int i = 1; i < list.size(); i++) {
            Transaction key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j).fee > key.fee) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, key);
        }
    }

    static void outliers(ArrayList<Transaction> list) {
        System.out.print("Outliers: ");
        boolean found = false;

        for (Transaction t : list) {
            if (t.fee > 50) {
                System.out.print(t + " ");
                found = true;
            }
        }
        if (!found) System.out.println("None");
    }
}