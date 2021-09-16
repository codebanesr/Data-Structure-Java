package interview.stackAndQueue;

import java.util.PriorityQueue;

public class MaxOfALLSubarraysofSizeK {
    public static void main(String[] args) {
        int K = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, (x, y) -> Integer.compare(y, x));
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};

        for (int i=0; i < arr.length; i++) {
            pq.add(arr[i]);


            if (pq.size() == K) {
                System.out.println("Next greater element " + pq.peek());
                pq.remove(arr[i - K + 1]);
            }
        }
    }
}
