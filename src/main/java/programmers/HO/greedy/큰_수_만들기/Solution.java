package programmers.HO.greedy.큰_수_만들기;

class Solution {
    public String solution(String number, int k) {

        int answerCount = number.length() - k;
        StringBuilder sb = new StringBuilder();
        int index = 0 ;

        for (int i = 0; i < answerCount; i++) {
            char max = 0;
            for (int j = index; j <= (i + k); j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    index = j + 1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}