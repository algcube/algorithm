package programmers.CS.더맵게;


import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> scoviles = new PriorityQueue();
        for (int sco : scoville) {
            scoviles.add(sco);
        }

        int cnt = 0;
        while (true) {
            if (scoviles.peek() < K) {
                if (scoviles.size() < 2) {
                    return -1;
                } else {
                    cnt++;
                    scoviles.add(mix(scoviles.poll(), scoviles.poll()));
                }
            } else {
                return cnt;
            }
        }
    }

    private int mix(int min, int max) {
        return min + max * 2;
    }
}