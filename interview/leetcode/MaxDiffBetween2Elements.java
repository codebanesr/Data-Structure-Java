package leetcode;

public class MaxDiffBetween2Elements {
    public static void main(String[] args)  
    {
        MaxDiffBetween2Elements maxdif = new MaxDiffBetween2Elements();
        int arr[] = { 1, 2, 90, 10, 110 };
        int size = arr.length;
        System.out.println("MaximumDifference is " + maxdif.maxDiffBetween2Elements(arr, size));
    }
    

    public int maxDiffBetween2Elements(int arr[], int size) {
        int max_diff = -1;
        int min_element = arr[0];
        for (int i = 0; i < size; i++) {
            if (arr[i] - min_element > max_diff) {
                max_diff = arr[i] - min_element;
            }
            if (arr[i] < min_element) {
                min_element = arr[i];
            }
        }

        return max_diff;
    }
}
