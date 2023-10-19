package programmers.HO.heap.더_맵게;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int scov : scoville) {
            queue.add(scov);
        }

        while (queue.peek() < K) {
            if (queue.size() == 1) return -1;

            answer++;
            int result = getScoville(queue.poll(), queue.poll());
            queue.add(result);
        }

        return answer;
    }

    private int getScoville(int x, int y) {
        return x + (y * 2);
    }
}