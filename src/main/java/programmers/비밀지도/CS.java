package programmers.비밀지도;

import java.util.ArrayList;
import java.util.List;

public class CS {
    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            List<String> answer = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                String result = Integer.toBinaryString(arr1[i] | arr2[i])
                        .replaceAll("1", "#")
                        .replaceAll("0", " ");
                if (result.length() < n) {
                    answer.add(" ".repeat(n - result.length()) + result);
                } else {
                    answer.add(result);
                }
            }
            return answer.toArray(String[]::new);
        }
    }
}
