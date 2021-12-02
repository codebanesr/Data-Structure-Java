import java.util.*;

// The solution to this problem is going to be 
// next smaller element for index i -> nse[i]
// previous smaller element for index i -> pse[i]
// max area = [max(nse[i] - pse[i])|i=0....n-1] * arr[i];
public class MaxHistogram {
    class Pair {
        int index, value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 6, 4, 7, 100, 98, 101 };
        MaxHistogram mh = new MaxHistogram();
        int nge[] = mh.getNextGreaterElement(arr);
        int nse[] = mh.getNextSmallerElement(arr);


        System.out.println(Arrays.toString(nge) + "\n" + Arrays.toString(nse));
    }


    int[] getNextGreaterElement(int arr[]) {
        int nge[] = new int[arr.length];
        Stack<Pair> stack = new Stack<>();

        stack.add(new Pair(0, arr[0]));
        for (int i = 1; i < nge.length; i++) {
            while (!stack.isEmpty() && arr[i] > stack.peek().value) {
                Pair currentElement = stack.pop();
                nge[currentElement.index] = i;
                System.out.println(currentElement.value + "'s next greater element -> " + arr[i]);
            }
            stack.push(new Pair(i, arr[i]));
        }
        return nge;
    }


    int[] getNextSmallerElement(int arr[]) {
        int nse[] = new int[arr.length];
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0, arr[0]));
        for (int i = 1; i < nse.length; i++) {
            while (!stack.isEmpty() && arr[i] < stack.peek().value) {
                Pair currentElement = stack.pop();
                nse[currentElement.index] = i;
                System.out.println(arr[i] + " is the next smaller element for" + currentElement.value);
            }
            
            stack.push(new Pair(i, arr[i]));
        }
        return nse;
    }
}
