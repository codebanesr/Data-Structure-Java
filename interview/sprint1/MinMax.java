package interview.sprint1;


class Pair {
  int max;
  int min;

  Pair(int min, int max) {
    this.min = min;
    this.max = max;
  }

  public String toString() {
    return "(" + min + "," + max + ")";
  }
}

public class MinMax {
  public static void main(String args[]) {
    int arr[] = { 5, 6, 7, 8, 9, 1, 2, 3, 4 };
    System.out.println(minmax(arr, 0, arr.length - 1));
  }



  public static Pair minmax(int arr[], int start, int end) {
    // its not end-start<=2; then there are 3 elements that's wrong
    if(end - start < 2) {
      int min = Math.min(arr[start], arr[end]);
      int max = Math.max(arr[start], arr[end]);
      return new Pair(min, max);
    }

    // this is not arr.length / 2 => we are concerned with the current inputs not the array
    // in divide an conquer always think in terms of indices not the array
    int mid = (start + end) / 2;
    Pair leftpair = minmax(arr, start, mid);
    Pair rightPair = minmax(arr, mid, end);

    int max = Math.max(leftpair.max, rightPair.max);
    int min = Math.min(leftpair.min, rightPair.min);

    return new Pair(min, max);
  }
}
