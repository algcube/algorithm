package ch03_greedy.큰수의법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class HO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] inputArray = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted().toArray();

        int firstMax = inputArray[N-1];
        int secondMax = inputArray[N-2];
        int result = 0;

        // SecondMax가 더해져야 하는수 count
        int secondCount = M/K;
        // FirstMax가 더해져야 하는수 count
        int firstCount = (M - secondCount);

        result += firstCount * firstMax;
        result += secondCount * secondMax;

        System.out.println("result = " + result);
    }
}