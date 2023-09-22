package ch04_implementation.시각;

import java.io.*;

public class HO {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int cnt = 0;

        for (int hour = 0; hour < N + 1; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                for (int second = 0; second < 60; second++) {
                    if (Integer.toString(second).contains("3") || Integer.toString(minute).contains("3") || Integer.toString(hour).contains("3")) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}
