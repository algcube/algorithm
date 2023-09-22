package ch04_implementation.게임_개발;

import java.io.*;

// TODO 다시 풀기
public class HO {

    private final static int visited = 1;
    private static int direction = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] mapSize = bf.readLine().split(" ");
        int n = Integer.parseInt(mapSize[0]);
        int m = Integer.parseInt(mapSize[1]);

        String[] initPosition = bf.readLine().split(" ");
        int x = Integer.parseInt(initPosition[0]);
        int y = Integer.parseInt(initPosition[1]);
        direction = Integer.parseInt(initPosition[2]);

        int[][] visitedMap = new int[50][50];
        int[][] mapInfo = new int[50][50];
        String[] map;

        //map 설정
        for (int i = 0; i < n; i++) {
            map = bf.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                mapInfo[i][j] = Integer.parseInt(map[j]);
            }
        }

        //북, 동, 남, 서 순으로 정의
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int turnCount = 0;
        int result =1;

        // 처음 시작한 자리는 visited 처리
        visitedMap[x][y] = visited;
        while (true) {
            turnLeft();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            // 처음 가는 땅일 경우에만 이동
            if (mapInfo[nx][ny] == 0 && visitedMap[nx][ny] == 0) {
                visitedMap[nx][ny] = visited;
                x = nx;
                y = ny;
                turnCount = 0;
                result++;
                continue;
            } else {
                turnCount++;
            }

            if (turnCount == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];

                if (visitedMap[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                } else{
                    break;
                }
                turnCount = 0;
            }
        }

        System.out.println("result = " + result);
    }

    private static void turnLeft() {
        direction -= 1;
        if (direction == -1) {
            direction = 3;
        }
    }
}
