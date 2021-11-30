package practicesection;

import java.util.*;

// Merge k sorted arrays | Set 2 (Different Sized Arrays)
public class ExternalSort {
    class Pair {
        int arrayNumber;
        int number;
        int elementIndex;


        Pair(int arrayNumber, int number, int elementIndex) {
            this.arrayNumber = arrayNumber;
            this.number = number;
            this.elementIndex = elementIndex;
        }
    }
    public static void main(String[] args) {
        int arr[][] = { 
                { -1, 0, 1, 99, 101 }, 
                { 1, 2, 3, 4 }, 
                { 0, 2, 3, 5, 6 }, 
                { 9, 10, 11, 44 } };

        ExternalSort es = new ExternalSort();
        Integer merged[] = es.externalSort(arr);
        System.out.println(Arrays.toString(merged));

    }
    

    public Integer[] externalSort(int arr[][]) {
        LinkedList<Integer> list = new LinkedList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.number, y.number));
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(i, arr[i][0], 0));
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            list.add(p.number);


            if (p.elementIndex >= arr[p.arrayNumber].length - 1) {
                continue;
            } else {
                pq.add(new Pair(p.arrayNumber, arr[p.arrayNumber][p.elementIndex + 1], p.elementIndex + 1));
            }
        }
        
        return list.toArray(new Integer[0]);
    }
}
