package programmers.HO.sort.가장_큰_수;

import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String [] convertStringArray = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        Arrays.sort(convertStringArray, (o1, o2) -> (o2+o1).compareTo((o1+o2)));

        //예외 처리
        if(convertStringArray[0].equals("0")) return "0";

        for (String i : convertStringArray) {
            answer.append(i);
        }

        return answer.toString();
    }
}