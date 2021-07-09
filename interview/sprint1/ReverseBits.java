package interview.sprint1;

public class ReverseBits {
  public static void main(String[] args) {
    int n = 139;
    System.out.println(Integer.toBinaryString(n));
    int result = 0;

    while(n!=0) {
      int last = n & 1;
      n = n >> 1;
      result = (result << 1) | last;
    }



    System.out.println(Integer.toBinaryString(result));
  }
}
