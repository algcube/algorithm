package ch03_greedy.큰수의법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// 시간 복잡도 : O(N) / 공간복잡도 : O(1)
public class CS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int K = Integer.parseInt(input[2]);

        int[] inputArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // 배열에서 가장 큰 값
        int firstMaxNum = Integer.MIN_VALUE;
        // 배열에서 두번쨰로 큰 값
        int secondMaxNum = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (inputArray[i] > firstMaxNum) {
                secondMaxNum = firstMaxNum;
                firstMaxNum = inputArray[i];
            }
        }
        // 배열에서 두번째 큰 값이 등장할 횟수
        int secondMaxNumCnt = M / K;

        System.out.println(secondMaxNumCnt * secondMaxNum + (M - secondMaxNumCnt) * firstMaxNum);
    }
}
