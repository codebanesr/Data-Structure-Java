public class FindStartAndEndOfK {
    public static void main(String args[]) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9, 10 };
        int a = 9;
        int low = findPosition(arr, a);
        int high = findPosition(arr, a + 1);
        System.out.println(low + ", " + high);
    }

    public static int findPosition(int arr[], int a) {
        int low = 0;
        int high = arr.length;

        int mid = 0;
        while (high > low) {
            mid = low + (high - low) / 2;
            if (arr[mid] >= a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return mid;
    }
}
