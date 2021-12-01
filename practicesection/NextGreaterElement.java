import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 55, 43, 21, 3, 100 };
        printNextGreaterElement(arr);
    }
    


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
}
