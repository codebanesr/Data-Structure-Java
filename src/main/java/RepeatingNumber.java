package src.main.java;

import java.util.HashSet;
import java.util.LinkedHashMap;

public class RepeatingNumber {
    public static void main(String[] args) {
        int arr[] = { 2, 1, 3, 2, 4, 3, 1, 5 };
        HashSet<Integer> hs = new HashSet<>();
        int minDuplicateIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (hs.contains(arr[i])) {
                // arr[i] is a duplicate
            }
            hs.add(arr[i]);
        }
        

        if (minDuplicateIndex == -1) {
            System.out.println("No repeating numbers found");
        }
    }
}
