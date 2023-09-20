package programmers.개인정보수집유효기간;

import java.util.*;

// https://school.programmers.co.kr/learn/courses/30/lessons/150370
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String,Integer> map = new HashMap();
        for(String term : terms){
            String[] input = term.split(" ");
            map.put(input[0], Integer.parseInt(input[1]));
        }

        List<Integer> output = new ArrayList();
        int currentDay = getDay(today);
        for(int i = 0 ; i < privacies.length ; i++){
            String[] input = privacies[i].split(" ");
            if(getDay(input[0]) +(map.get(input[1]) * 28) - 1 < currentDay){
                output.add(i+1);
            }
        }
        return  output.stream().sorted().mapToInt(v->v).toArray();
    }

    private int getDay(String date){
        String[] input = date.split("\\.");
        int year = Integer.parseInt(input[0]);
        int month = Integer.parseInt(input[1]);
        int day = Integer.parseInt(input[2]);
        return (year * 12 * 28) + (month * 28) + day;
    }
}