package interview.sprint2;

import java.util.LinkedList;
public class RotateLLInChunks {
    public static void reverseK(int k, LinkedList<Integer> list) {
        int len = list.size();
        for (int i = 0; i < len; i+=k) {
            
            int start = i;
            int end = Math.min(len - 1, start + k - 1);

            while (start <= end) {
                int temp = list.get(start);
                list.set(start, list.get(end));
                list.set(end, temp);
                start++;
                end--;
            }
        }

        System.out.println(list.toString());
    }


    public static void main(String args[]) {
        int a[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        LinkedList<Integer> list = new LinkedList<Integer>();


        for (int i = 0; i < a.length; i++) {
            list.add(a[i]);
        }


        reverseK(5, list);
    }
}
