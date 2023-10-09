package programmers.HO.greedy.단속카메라;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int arrive = -9999999;

        for (int i = 0; i < routes.length; i++) {
            // 전에 단속카메라에 등록한 arrive가 routes내에 포함 한다면 continue
            if (arrive >= routes[i][0] && arrive <= routes[i][1]) {
                continue;
            }
            answer++;
            arrive =routes[i][1];
        }

        return answer;
    }
}