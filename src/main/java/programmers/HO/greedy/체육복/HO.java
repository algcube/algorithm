package programmers.HO.greedy.체육복;

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);
        int lostCount = lost.length;
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    lostCount--;
                    break;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            int front = lost[i] +1;
            int back = lost[i] -1;
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] == front || reserve[j] == back) {
                    reserve[j] = -1;
                    lostCount--;
                    break;
                }
            }
        }
        return n - lostCount;
    }
}