package interview.sprint1;

public class FindMissingInteger {
  public static void main(String args[]) {
    int arr[] = { 1,2,3,4,6,7,8 };
    System.out.println(getMissingIntegerWithBitwise(arr));
  }
  
  public static int getMissingIntegerWithBitwise(int arr[]) {
    int n = arr.length;
    int missing_number = arr[0];
    for(int i = 1; i < n; i++) {
      missing_number ^= arr[i];
    }

    for(int i=1; i<=n+1; i++) {
      missing_number ^= i;
    }

    return missing_number;
  }

  // naive method
  public static int getMissingInteger(int arr[]) {
    int sum = 0;
    int n = arr.length;
    for(int i=0; i< n; i++) {
      sum += arr[i];
    }
    return n * (n + 1) / 2 - sum;
  }
}
