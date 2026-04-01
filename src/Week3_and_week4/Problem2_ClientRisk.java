package Week3_and_week4;

import java.util.*;

public class Problem2_ClientRisk {

    static class Client {
        String name;
        int risk;

        Client(String n, int r) {
            name = n;
            risk = r;
        }

        public String toString() {
            return name + ":" + risk;
        }
    }

    public static void run() {
        System.out.println("\n--- Problem 2 ---");

        Client[] arr = {
                new Client("C", 80),
                new Client("A", 20),
                new Client("B", 50)
        };

        bubble(arr);
        System.out.println("Bubble: " + Arrays.toString(arr));

        insertion(arr);
        System.out.println("Insertion DESC: " + Arrays.toString(arr));
    }

    static void bubble(Client[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].risk > arr[j + 1].risk) {
                    Client t = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = t;
                }
            }
        }
    }

    static void insertion(Client[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Client key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].risk < key.risk) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}