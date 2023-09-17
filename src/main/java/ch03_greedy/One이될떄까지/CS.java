package ch03_greedy.One이될떄까지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = input[0];
        int K = input[1];
        int cnt = 0;

        while (N != 1) {
            cnt++;
            if (N % K == 0) {
                N /= K;
            } else {
                N--;
            }
        }
        System.out.println(cnt);
    }
}