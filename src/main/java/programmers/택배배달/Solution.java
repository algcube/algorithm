package programmers.택배배달;

import java.util.LinkedList;
import java.util.Stack;


import java.util.Stack;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        LinkedList<int[]> toDelivery = new LinkedList<>();
        LinkedList<int[]> toPickUp = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (deliveries[i] != 0) {
                toDelivery.add(new int[]{deliveries[i], i + 1});
            }
            if (pickups[i] != 0) {
                toPickUp.add(new int[]{pickups[i], i + 1});
            }
        }
        int sum = 0;
        int dist = 0;

        while (!toDelivery.isEmpty() || !toPickUp.isEmpty()) {

            dist = 0;
            sum = 0;
            while (!toDelivery.isEmpty() && sum < cap) {
                int[] c = toDelivery.pollLast();
                dist = Math.max(dist, c[1]);

                if (c[0] + sum <= cap) {
                    sum += c[0];
                } else {
                    c[0] = c[0] - (cap - sum);
                    toDelivery.addLast(c);
                    break;
                }
            }
            sum = 0;
            while (!toPickUp.isEmpty() && sum < cap) {
                int[] c = toPickUp.pollLast();
                dist = Math.max(dist, c[1]);

                if (c[0] + sum <= cap) {
                    sum += c[0];
                } else {
                    c[0] = c[0] - (cap - sum);
                    toPickUp.addLast(c);
                    break;
                }
            }
            answer += (dist * 2L);

        }
        return answer;
    }
}