import java.io.*;
 
class GFG {
    public static int minswaps(int arr[], int n)
    {
        int total = 0;
        int nzeroes = 0;
 
        for (int i = n - 1; i >= 0; i--)
        {
            if (arr[i] == 0)
                nzeroes += 1;
            else
                total += nzeroes;
        }
        return total;
    }
   
    // Driver Code
    public static void main(String[] args)
    {
        int[] arr = { 0, 0, 1, 0, 1, 0, 1, 1 };
        System.out.println(minswaps(arr, 9));
    }
}