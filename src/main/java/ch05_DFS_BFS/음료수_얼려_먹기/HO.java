package ch05_DFS_BFS.음료수_얼려_먹기;

import java.io.*;
import java.util.*;

public class HO {

    private static final int[][] graph = new int[1000][1000];

    private static int N =0;
    private static int M =0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] size = bf.readLine().split(" ");
        N = Integer.parseInt(size[0]);
        M = Integer.parseInt(size[1]);

        //입력
        for (int i = 0; i < N; i++) {
            String row = bf.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
            }
        }

        int result = 0;
        //탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }

        System.out.println("result = " + result);
    }

    private static boolean dfs(int i, int j) {

        if (i < 0 || j < 0 || i >= N || j >= M) {
            return false;
        }

        if (graph[i][j] == 0) {
            graph[i][j] = 1;
            dfs(i + 1, j);
            dfs(i, j + 1);
            dfs(i - 1, j);
            dfs(i, j - 1);

            return true;
        }
        return false;
    }
}
