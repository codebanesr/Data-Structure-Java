import java.util.*;

class InfixtoPostfix {
    static HashMap<Character, Integer> precedenceMap = new HashMap<>();

    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(generatePostfix(exp.toCharArray()));
    }

    static void onInit() {
        precedenceMap.put('-', 1);
        precedenceMap.put('+', 2);
        precedenceMap.put('*', 3);
        precedenceMap.put('/', 4);
        precedenceMap.put('^', 5);
    }


    // in postfix operators come after the operand, but operators with higher
    // precedence come first ....
    // If you see an operand add it to output
    // if you see operand check the stack - If empty push the operator
    // if higher precedence is present on stack it add stack top to output and then push this
    // current one to top of stack... handle the brackets separately ....
    static String generatePostfix(char charr[]) {
        onInit();
        String postfix = "";
        Stack<Character> st = new Stack<>();
        for (char c : charr) {
            if (Character.isLetterOrDigit(c)) {
                postfix += c;
            } else if (c == '(') {
                st.push('(');
            }

            else if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(')
                    postfix += st.pop();
                st.pop();
            }

            else {
                // if(!st.isEmpty())
                // System.out.println(st.peek() + " " + c);
                while (!st.isEmpty() && precedenceMap.getOrDefault(st.peek(), -1) > precedenceMap.getOrDefault(c, -1)) {
                    postfix += st.pop();
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            if (st.peek() == '(')
                return "Invalid Expression";
            postfix += st.pop();
        }

        return postfix;
    }
}
