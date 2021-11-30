package practicesection;

public class MajorityElement {
    public static int findMajorityElement(int arr[]) throws Exception {
        int majority = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == majority) {
                count++;
            } else {
                count--;
                if (count < 1) {
                    count = 0;
                    majority = arr[i];
                }
            }
        }


        if (count == 0) {
            throw new Exception("No majority element in the array");
        }

        return majority;
    }
    public static void main(String[] args) {
        int arr[] = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };
        // int arr[] = { 3, 3, 4, 5, 6, 7, 84 };
        try {
            int m = findMajorityElement(arr);
            System.out.println(m);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
