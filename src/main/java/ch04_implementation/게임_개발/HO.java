package ch04_implementation.게임_개발;

import java.io.*;
import java.util.*;

public class HO {

    private final static int visited = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = bf.readLine().split(" ");

        int n = Integer.parseInt(mapSize[0]);
        int m = Integer.parseInt(mapSize[1]);

        String[] initPosition = bf.readLine().split(" ");
        int x = Integer.parseInt(mapSize[0]);
        int y = Integer.parseInt(mapSize[1]);
        int direction = Integer.parseInt(mapSize[2]);

        int[][] visitedMap = new int[50][50];
        int[][] mapInfo = new int[50][50];

        //map 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mapInfo[i][j] = Integer.parseInt(bf.readLine());
            }
        }

        // 시작
        // 처음 시작한 자리는 visited 처리
        visitedMap[x][y] = visited;

    }
}
