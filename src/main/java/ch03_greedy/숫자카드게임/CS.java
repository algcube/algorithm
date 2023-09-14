package ch03_greedy.숫자카드게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);

        int totalMinValue = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int rowMinValue = Integer.MAX_VALUE;
            for (String card : br.readLine().split(" ")) {
                rowMinValue = Math.min(Integer.parseInt(card), rowMinValue);
            }
            totalMinValue = Math.max(totalMinValue, rowMinValue);
        }

        System.out.println(totalMinValue);
    }
}
