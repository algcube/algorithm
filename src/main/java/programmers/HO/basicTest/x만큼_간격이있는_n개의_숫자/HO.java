package programmers.HO.basicTest.x만큼_간격이있는_n개의_숫자;

//https://school.programmers.co.kr/learn/courses/30/lessons/12954
class Solution {
    public long[] solution(int x, int n) {

        long[] list = new long[n];
        for(int i = 0; i < n; i++){
            list[i] = (long) x * (i+1);
        }

        return list;
    }
}