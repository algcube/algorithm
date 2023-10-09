package programmers.HO.stack_queue.올바른_괄호;

import java.util.Stack;

class Solution {
    private static final char OPEN = '(';
    private static final char CLOSE = ')';

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == OPEN) {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();

    }
}

