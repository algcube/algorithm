package programmers.HO.greedy.구멍보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        int index = 0;
        int length = people.length;
        Arrays.sort(people);

        for (int i = 0; i < length; i++) {
            int sum = people[index] + people[people.length - (i +1)];
            if (sum <= limit) {
                index++;
                length--;
            }
            answer++;
        }
        return answer;
    }
}