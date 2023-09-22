package programmers.문자열압축;

class Solution {
    public int solution(String s) {

        int unit = 2;
        while (true) {
            String x = s.substring(0, unit);
            int start = unit;
            int cnt = 0;
            while (start + unit < s.length()) {
                String y = s.substring(start, start + unit);
                if (x.equals(y)) {
                    cnt++;
                }
                start += unit;
                x = y;
            }
            // 길이 계산
            int i = unit * cnt;

        }


    }
}