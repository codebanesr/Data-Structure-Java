package interview.crackingthecodinginterview.Dynamic;

import java.util.*;


// This program gives the correct answer but the stack is not empty, the stack should ideally be empty
class Parens {
    public static void main(String args[]) {
        int n = 6;
        Stack<Character> st = new Stack<>();
        int result = findCombination(st, 0, 0, n);

        System.out.println(result);
    }


    public static int findCombination(Stack<Character> st, int oi, int ci, int n) {

        if(ci>oi) {
            return 0;
        }
        if (oi == n && ci == n) {
            return 1;
        }

        else if (oi > n || ci > n) {
            return 0;
        }
        st.push('(');
        int push = findCombination(st, oi + 1, ci, n);

        if(st.isEmpty()) {
            return 0;
        }
        st.pop();
        
        int dontPush = findCombination(st, oi, ci + 1, n);

        return push + dontPush;
    }
}
