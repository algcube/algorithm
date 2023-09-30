package programmers.괄호변환;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (p.length() == 0) {
            return "";
        }
        int left = 0;
        int right = 0;
        for (int i = 0; i < p.length(); i++) {
            char x = p.charAt(i);
            if (x == '(') {
                left += 1;
            } else if (x == ')') {
                right += 1;
            }
            if (left == right) {
                String u = p.substring(0, i + 1);
                String v = "";
                if (p.length() >= i + 1) {
                    v = p.substring(i + 1);
                }

                StringBuilder sb = new StringBuilder();
                if (isValidBracket(u)) {
                    return sb.append(u).append(solution(v)).toString();
                }
                return sb.append("(").append(solution(v)).append(")").append(removeAndReplace(u)).toString();

            }
        }
        return null;
    }

    private String removeAndReplace(String input) {
        StringBuilder sb = new StringBuilder();
        String replaceStr = input.substring(1, input.length() - 1);
        for (int j = 0; j < replaceStr.length(); j++) {
            if (replaceStr.charAt(j) == '(') {
                sb.append(')');
            } else {
                sb.append('(');
            }
        }
        return sb.toString();
    }

    private boolean isValidBracket(String input) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.add(input.charAt(i));
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