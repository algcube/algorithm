package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CS_14889 {

    static int minDiff = Integer.MAX_VALUE;
    static int[][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int team = (N / 2);
        Deque<Integer> pick = new ArrayDeque<>();
        dfs(0, team, pick);
        System.out.println(minDiff);
    }


    public static void dfs(int person, int team, Deque<Integer> pick) {
        if (team == 0) {
            int x = 0;
            int[] vector = new int[graph.length];
            for (int i = 0; i < pick.size(); i++) {
                for (int j = i + 1; j < pick.size(); j++) {
                    x += (graph[i][j] + graph[j][i]);
                }
            }
            minDiff = Math.min(minDiff, x);
            return;
        }
        if (person >= graph.length) {
            return;
        }
        pick.add(person);
        dfs(person + 1, team - 1, pick);
        pick.pop();
        dfs(person + 1, team, pick);
    }
}
