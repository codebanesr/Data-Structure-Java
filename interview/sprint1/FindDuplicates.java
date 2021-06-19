package interview.sprint1;


public class FindDuplicates {
  public static void main(String args[]) {
    int arr[] = {1,2,3,4,5,1,2,3,5};
  
    for(int i=0; i<arr.length; i++) {
      // when you see a number switch the sign at that index, and if the sign is already negative
      // that means we have seen that number

      int number = Math.abs(arr[i]);

      if(arr[number]<0) {
        System.out.println(number);
      }else {
        arr[number] = -1*arr[number];
      }
    }
  }
}
