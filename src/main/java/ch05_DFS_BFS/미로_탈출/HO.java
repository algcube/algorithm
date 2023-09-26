package ch05_DFS_BFS.미로_탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

public class HO {

    private static int N =0;
    private static int M =0;
    private static final int[][] graph = new int[200][200];
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

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

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            x = node.getX();
            y = node.getY();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                // 예외 처리
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                // 벽인 경우 무시
                if (graph[nx][ny] == 0) continue;

                if (graph[nx][ny] == 1) {
                    graph[nx][ny] = graph[x][y] + 1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return graph[N - 1][M - 1];
    }
}
