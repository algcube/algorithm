package bj.bronze;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/submit/13458
public class CS_13458 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
        String[] input = br.readLine().split(" ");
        int B = Integer.parseInt(input[0]);
        int C = Integer.parseInt(input[1]);

        long cnt = A.length;
        for (int peopleNum : A) {
            int rest = peopleNum - B;
            if (rest <= 0) {
                continue;
            }
            cnt += rest / C;
            if (rest % C != 0) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
    }
}