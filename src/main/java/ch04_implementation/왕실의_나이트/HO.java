package ch04_implementation.왕실의_나이트;

import java.io.*;

public class HO {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String position = bf.readLine();

        int column = position.charAt(0) - 'a' + 1;
        int row = Integer.parseInt(String.valueOf(position.charAt(1)));

        // 나이트가 이동 가능한 x,y 경로
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        int nx = 0;
        int ny = 0;
        int result =0;

        for (int i = 0; i < 8; i++) {
            nx = row + dx[i];
            ny = column + dy[i];

            //이동 후 경로가 체스판안이라면 result 증가
            if ((nx >= 1 && nx <= 8) && ((ny >= 1 && ny <= 8))) {
                result++;
            }
        }
        System.out.println(result);
    }
}
