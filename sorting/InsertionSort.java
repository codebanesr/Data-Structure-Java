package sorting;
import java.util.Arrays;

class InsertionSort {
    void insertionsSort(int arr[]) {
        int size = arr.length;
        for(int step = 1; step<size; step++) {
            int rightEdge = arr[step];

            int j = step - 1;
            while(j>=0 && rightEdge < arr[j]) {
                arr[j+1] = arr[j];
                --j;
            }

            arr[j+1] = rightEdge;
        }
    }


    public static void main(String args[]) {
        int arr[] = { 3, 4, 5, 123, 6, 5, 1 };

        InsertionSort is = new InsertionSort();
        is.insertionsSort(arr);

        System.out.println(Arrays.toString(arr));
    }
}


