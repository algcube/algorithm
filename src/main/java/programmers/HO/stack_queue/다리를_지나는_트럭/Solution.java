package programmers.HO.stack_queue.다리를_지나는_트럭;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        int crossedTruck = 0;
        Queue<Integer> queue = new LinkedList<>();

        while (crossedTruck != truck_weights.length) {
            answer++;
            int preSum = sum + truck_weights[crossedTruck];

            if (preSum <= weight) {
                sum += truck_weights[crossedTruck];
                queue.add(truck_weights[crossedTruck]);
                crossedTruck++;
            } else {
                sum -= queue.poll();
            }
        }

        answer += bridge_length;
        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        int solution = solution(bridge_length, weight, truck_weights);
        System.out.println("solution = " + solution);
    }
}
