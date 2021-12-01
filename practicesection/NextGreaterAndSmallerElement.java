import java.util.Stack;

public class NextGreaterAndSmallerElement {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 50, 49, 55, 43, 21, 3, 100 };
        System.out.println("Printing next greater elements for all array elements");
        printNextGreaterElement(arr);

        System.out.println("Printing next smaller elements for all array elements");
        printNextSmallerElement(arr);
    }
    


    /** At any point in time what we have in stack are the numbers for whom next greater
     * element has not been found, so the number that we have in a given iteration has
     * the possibility of being the next greater element for all elements in the stack.
     * 
     * but then comes the second problem, which is that in order for this algorithm to work
     * consecutive numbers in the stack should be greater otherwise we need to iterate over
     * the entire stack to find if the array element is the next greater element for 
     * those ..., if you look closely that is exactly the case.
     */
    static void printNextGreaterElement(int arr[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (st.isEmpty()) {
                st.push(arr[i]);
                continue;
            }

            while (!st.isEmpty() && st.peek() < arr[i]) {
                System.out.println("NGE " + st.peek() + " = " + arr[i]);
                st.pop();
            }

            if (st.isEmpty() || arr[i] < st.peek()) {
                st.push(arr[i]);
            }
        }
    }


    static void printNextSmallerElement(int arr[]) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
                continue;
            }

            while (!stack.isEmpty() && arr[i]<stack.peek()) {
                System.out.println("NSE " + stack.peek() + "=" + arr[i]);
                stack.pop();
            }


            if (stack.isEmpty() || stack.peek() < arr[i]) {
                stack.push(arr[i]);
            }
        }
    }   
}
