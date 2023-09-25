package ch05_DFS_BFS.큐_예제;

import java.util.LinkedList;
import java.util.Queue;

public class HO {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(5);
        queue.offer(2);
        queue.offer(3);
        queue.offer(7);
        queue.poll();
        queue.offer(1);
        queue.offer(4);
        queue.poll();

        queue.forEach(System.out::println);
    }
}
