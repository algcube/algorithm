package programmers.CS.디스크컨트롤러;

import java.util.Arrays;

class Solution {
    public int solution(int[][] jobs) {

        Arrays.sort(jobs, (x, y) -> {
            int result = Integer.compare(x[0], y[0]);
            if (result == 0) {
                return Integer.compare(x[1], y[1]);
            }
            return result;
        });
        boolean[] visited = new boolean[jobs.length];

        int spendTime = jobs[0][0];
        int acc = 0;
        int idx = 0;
        for (int j = 0; j < jobs.length; j++) {

            visited[idx] = true;
            int[] job = jobs[idx];
            if (spendTime < job[0]) {
                spendTime = job[0];
            }
            spendTime += job[1];
            acc += (spendTime - job[0]);

            // find next shortest job
            int minJobTime = Integer.MAX_VALUE;
            for (int i = 0; i < jobs.length; i++) {
                if (jobs[i][0] > spendTime) {
                    break;
                }
                if (jobs[i][1] <= minJobTime && !visited[i]) {
                    minJobTime = jobs[i][1];
                    idx = i;
                }
            }
            if (visited[idx]) {
                // 방문하지 않은 job중에 선입선출
                for (int i = 0; i < jobs.length; i++) {
                    if (!visited[i]) {
                        idx = i;
                        break;
                    }
                }
            }
        }
        return acc / jobs.length;
    }
}
