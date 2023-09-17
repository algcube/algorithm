package bj.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.max;

// https://www.acmicpc.net/problem/14501
public class CS_14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            T[i] = Integer.parseInt(input[0]);
            P[i] = Integer.parseInt(input[1]);
        }

        // 점화식 : dp[x] = max(P[x] + dp[x+T[x]],dp[x+1])
        // dp[i] 는 i일째 에서의 최대 수익 = max( i에서 상담 비용 + dp[i+상담소요시간] , dp[i+1])
        int[] dp = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            if (i + T[i] > N) {
                dp[i] = dp[i + 1];
                continue;
            }
            dp[i] = max(P[i] + dp[i + T[i]], dp[i + 1]);
        }
        System.out.println(dp[0]);
    }
}
