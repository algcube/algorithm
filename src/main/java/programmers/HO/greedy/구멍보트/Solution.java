package programmers.HO.greedy.구멍보트;

import java.util.Arrays;

class Solution {
    public static int solution(int[] people, int limit) {
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

    public static void main(String[] args) {
        int solution1 = solution(new int[]{70, 50, 80, 50}, 100);
        int solution2 = solution(new int[]{70, 80, 50}, 100);

        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
    }
}


