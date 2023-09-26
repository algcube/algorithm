package programmers.문자열압축;

class Solution {
    public int solution(String s) {

        int minValue = s.length();

        for (int unit = 1; unit < (s.length() / 2) + 1; unit++) {
            int start = 0;
            int cnt = 1;
            String before = s.substring(start, start + unit);
            String after = s.substring(start + unit, start + unit * 2);
            StringBuilder sb = new StringBuilder();

            while (true) {
                if (before.equals(after)) {
                    cnt++;
                } else {
                    if (cnt != 1) {
                        sb.append(cnt);
                    }
                    sb.append(before);
                    cnt = 1;
                }
                before = after;
                start += unit;

                if (start + unit * 2 > s.length()) {
                    if (cnt != 1) {
                        sb.append(cnt);
                    }
                    sb.append(s.substring(start));
                    minValue = Math.min(minValue, sb.length());
                    break;
                }
                after = s.substring(start + unit, start + unit * 2);
            }
        }
        return minValue;

    }
}