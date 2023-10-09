package programmers.HO.basicTest.숫자_짝꿍;

class Solution {
    public String solution(String X, String Y) {

        // 0 ~ 9까지 count값을 담을 배열 선언
        int[] arrX = new int[10];
        int[] arrY = new int[10];

        // 문자열을 하나씩 꺼내 해당하는 숫자 index에 count 증가
        for (int i = 0; i < X.length(); i++) {
            int number = X.charAt(i) - '0';
            arrX[number]++;
        }
        for (int i = 0; i < Y.length(); i++) {
            int number = Y.charAt(i) - '0';
            arrY[number]++;
        }

        // 0 ~ 9 까지 배열을 돌면서 값이 있는 것들 추출
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            if (arrX[i] > 0 && arrY[i] > 0) {
                //숫자가 겹치는 만큼 반환
                int min = Math.min(arrX[i], arrY[i]);
                for (int j = 0; j < min; j++) {
                    sb.append(i);
                }
            }
        }

        //예외 처리
        String answer;
        if (sb.length() > 0) {
            answer = sb.reverse().toString();
            if (answer.charAt(0) == '0') {
                answer = "0";
            }
        } else {
            answer = "-1";
        }

        return answer;
    }
}
