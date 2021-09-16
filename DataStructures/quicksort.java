import java.util.*;
class Quicksort {
  public static void main(String[] args) {
    int arr[] = {9,8,6,5,4,77,34,2,1};
    QS(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
  }
  
  public static void QS(int arr[], int start, int end){
    if(start>end)
      return;
    int p = partition(arr, start, end);
    QS(arr, start, p-1);
    QS(arr, p+1, end);
  }
  
  public static int partition(int arr[], int start, int end){
    int pivot = arr[end];
    int j = start-1;
    for(int i=start; i<end; i++){
      if(arr[i]<pivot){
        swap(arr, i, j+1);
        j++;
      }
    }
    swap(arr, j+1, end);
    return j+1;
  }
  
  public static void swap(int arr[], int i, int j){
    int temp = arr[j];
    arr[j] = arr[i];
    arr[i] = temp;
  }
}
