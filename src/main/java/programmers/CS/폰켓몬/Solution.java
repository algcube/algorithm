package programmers.CS.폰켓몬;

import java.util.Arrays;

class Solution {
    public int solution(int[] nums) {
        return Math.min((int) Arrays.stream(nums).distinct().count(), nums.length);
    }
}