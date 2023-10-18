package programmers.HO.stack_queue.다리를_지나는_트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int crossedTruck = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (crossedTruck != truck_weights.length) {
            if (queue.size() == bridge_length) {
                sum -= queue.poll();
            }

            answer++;
            int preSum = sum + truck_weights[crossedTruck];

            if (preSum <= weight) {
                sum += truck_weights[crossedTruck];
                queue.add(truck_weights[crossedTruck]);
                crossedTruck++;
            } else {
                queue.add(0); // 무게가 초과되는 경우 대신 0을 큐에 넣어 다리 길이를 유지
            }
        }

        answer += bridge_length;
        return answer;
    }
}