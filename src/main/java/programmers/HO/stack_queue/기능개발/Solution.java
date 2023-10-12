package programmers.HO.stack_queue.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> releaseDate = new ArrayList<>();

//        30 + (30 * x) >= 100 이거를 만족하는 최소 x 값 = 작업하는데 걸리는 시간
        for (int i = 0; i < progresses.length; i++) {
            int x = 0;
            while (progresses[i] + (speeds[i] * x) < 100) {
                x++;
            }
            releaseDate.add(x);
        }

        int count = 1;
        int x = releaseDate.get(0);
        List<Integer> answer = new ArrayList<>();
        for (int i = 1; i < releaseDate.size(); i++) {
            if (x >= releaseDate.get(i)) {
                count++;
            } else {
                answer.add(count);
                count = 1;
                x = releaseDate.get(i);
            }
        }
        answer.add(count);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}