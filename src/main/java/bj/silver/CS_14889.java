package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution {

    public static void main(String[] args) {
        long solution = new Solution().solution(4, 5, new int[]{1, 0, 3, 1, 2}, new int[]{0, 3, 0, 4, 0});
        System.out.println("solution = " + solution);
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        long dist = 0;
        long tmp = cap;
        for(int i = deliveries.length -1 ; i >=0  ; i--){
            while (deliveries[i] != 0){
                deliveries[i] =(int) Math.max(0,  deliveries[i] - tmp);
                tmp -=deliveries[i];
                if (tmp <= 0){
                    tmp = cap;
                    dist+= ((i+1)*2);
                }
            }
        }

        return dist;
    }

}