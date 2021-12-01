package practicesection;

public class MaxHistogram {
    public static void main(String[] args) {

    }
    



    public static int maxAreaSimple(int arr[]) {
        int maxArea = 1;


        return maxArea;
    }


    public static int maxAreaAdvanced(int arr[]) {
        int maxArea = 1;
        /** Why use stack 
         * Let' say you are standing on the ith index and want to see the max are that
         * can be formed using the current index. For that you would want to know all index
         * that will come after the current index and also all index that came before the 
         * current index. To look back you can use a stack....
         */

        // keep popping out elements from stack as long as they are less than the 
        // current arr[i]

        return maxArea;
    }
}
