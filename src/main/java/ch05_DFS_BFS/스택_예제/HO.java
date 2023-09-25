package ch05_DFS_BFS.스택_예제;

import java.util.Stack;

public class HO {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(7);
        stack.pop();
        stack.push(1);
        stack.push(4);
        stack.pop();

        for (Integer data : stack) {
            System.out.println("data = " + data);
        }
    }
}
