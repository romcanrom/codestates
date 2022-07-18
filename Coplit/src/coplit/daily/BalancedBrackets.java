package coplit.daily;

import java.util.*;

public class BalancedBrackets {
    public static void main(String[] args) {
        boolean output = balancedBrackets("(");
        System.out.println(output); // // -> false

        output = balancedBrackets("()");
        System.out.println(output); // --> true

        output = balancedBrackets("[](){}");
        System.out.println(output); // --> true

        output = balancedBrackets("[({})]");
        System.out.println(output); // --> true

        output = balancedBrackets("[(]{)}");
        System.out.println(output); // --> false

        output = balancedBrackets("())()(()");
        System.out.println(output); // --> false
    }

    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        final Map<Character, Character> pair = new HashMap<>() {
            {
                put(')', '(');
                put('}', '{');
                put(']', '[');
            }
        };

        for (char c : str.toCharArray()) {
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty()) return false;
                else if(stack.pop() != pair.get(c)) return false;
            }
        }

        return stack.isEmpty();
    }
}
