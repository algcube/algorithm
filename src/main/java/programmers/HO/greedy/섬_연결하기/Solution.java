package programmers.HO.greedy.섬_연결하기;

import java.util.*;

//크루스칼 알고리즘 사용
class Solution {

    static int[] parent;

    public int solution(int n, int[][] costs) {

        int answer = 0;
        // cost순으로 정렬
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));

        //parent초기화
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        // union 성공하면(노드끼리 연결되면) answer에 cost 추가
        for (int[] cost : costs) {
            if (union(cost[0], cost[1])) {
                answer += cost[2];
            }
        }

        return answer;
    }

    private int findParent(int x) {
        if (parent[x] == x) return x;
        return findParent(parent[x]);
    }

    private boolean union(int x, int y) {
        x = findParent(x);
        y = findParent(y);

        //이미 같은 부모일 경우 return false
        if (x == y) {
            return false;
        }

        // 부모가 다를 경우 작은 값을 부모로 선정
        int max = Math.max(x, y);
        int min = Math.min(x, y);
        parent[max] = min;
        return true;
    }
}