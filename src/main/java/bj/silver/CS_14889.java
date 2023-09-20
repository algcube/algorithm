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
        boolean[] visited = new boolean[N];
        dfs(0, team, visited);
        System.out.println(minDiff);
    }


    public static void dfs(int person, int team, boolean[] visited) {
        if (team == 0) {
            int START = 0;
            int LINK = 0;
            for (int i = 0; i < visited.length; i++) {
                for (int j = i + 1; j < visited.length; j++) {
                    if (visited[i] != visited[j]) {
                        continue;
                    }
                    if (visited[i]) {
                        START += graph[i][j] + graph[j][i];
                    } else {
                        LINK += graph[i][j] + graph[j][i];
                    }
                }
            }
            minDiff = Math.min(minDiff, Math.abs(START - LINK));
            return;
        }
        if (person >= graph.length) {
            return;
        }
        visited[person] = true;
        dfs(person + 1, team - 1, visited);
        visited[person] = false;
        dfs(person + 1, team, visited);
    }
}