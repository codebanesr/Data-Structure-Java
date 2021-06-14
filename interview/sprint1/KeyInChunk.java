package interview.sprint1;

public class KeyInChunk {
  public static void main(String args[]) {
    int arr[] = { 1, 2, 3, 4, 2, 5, 6, 7, 2, 8, 9, 0, 0, 0, 0, 2 };
    int chunkSize = 4;
    int number = 2;
    boolean isPresent = true;
    for(int i=0; i<arr.length; i+=chunkSize) {
      if(!isPresent(arr, i, i+chunkSize, number)) {
        isPresent = false;
        break;
      }
    }
    
    System.out.println(isPresent);
  }


  public static boolean isPresent(int arr[], int start, int endIndex, int number) {
    boolean isPresent = false;
    for(int i=start; i<endIndex; i++) {
      if(arr[i] == number) {
        isPresent = true;
      }
    }
    return isPresent;
  }
}
