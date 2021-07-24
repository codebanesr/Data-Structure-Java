package interview.sprint1;

public class MajorityElement {
  public static void main(String args[]) {
    int arr[] = { 5, 1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 1, 1 };
    int majorityElement = arr[0];
    int majCount = 1;
    for (int i = 1; i < arr.length; i++) {
      if(majCount == 0) {
        majCount ++;
        majorityElement = arr[i];
      }
      else if(arr[i] != majorityElement && majCount > 0) {
        majCount --;
      } else if(arr[i] == majorityElement){
        majCount++;
      }
    }


    System.out.println(majCount + " " + majorityElement);
  }
}
