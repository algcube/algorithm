package ch04_implementation.상하좌우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HO {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        String[] input = bf.readLine().split(" ");

        int x = 1;
        int y = 1;

        String[] moveType = {"R", "L", "D", "U"};
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int i = 0; i < input.length; i++) {
            int index = Arrays.asList(moveType).indexOf(input[i]);

            int nx = x + dx[index];
            int ny = y + dy[index];

            //범위 내에 있을 경우만 update
            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                x = nx;
                y = ny;
            }
        }
        System.out.println(x + " " + y);
    }
}
