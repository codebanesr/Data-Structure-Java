package practicesection;

import java.util.*;
public class PostfixEvaluation {

    public static void main(String[] args) {
        String exp="231*+9-";
        int r = evaluatePostfix(exp.toCharArray());
        System.out.println(r);
    }
    static int evaluatePostfix(char charr[]) {
        Stack<Integer> st = new Stack<>();
        for (char c : charr) {
            if (Character.isDigit(c)) {
                st.push(c - '0');
                continue;
            }

            int num1 = st.pop();
            int num2 = st.pop();
            switch (c) {
                case '+': {
                    int r = num1 + num2;
                    st.push(r);
                    break;
                }
                case '-': {
                    int r = num2 - num1;
                    st.push(r);
                    break;
                }
                case '*': {
                    int r = num1 * num2;
                    st.push(r);
                    break;
                }
                case '/': {
                    int r = num2 / num1;
                    st.push(r);
                    break;
                }

                default: {
                    st.push(Integer.parseInt(c + ""));
                }
            }
        }

        int r = st.pop();
        return r;
    }
}