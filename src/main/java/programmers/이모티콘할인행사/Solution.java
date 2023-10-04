package programmers.이모티콘할인행사;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {

    private static int[] DISCOUNT_RULE = {10,20,30,40};
    private static int[] answer = {0,0};

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(users , emoticons,new ArrayDeque<>(), emoticons.length );
        return answer;
    }

    private void dfs(int[][] users, int[] emoticons , Deque<Integer> picks, int numberOfEmoticons) {
        if (picks.size() == numberOfEmoticons){

            int serviceUser = 0;
            int profit =0;
            for (int[] user : users) {
                int userRule = user[0];
                int serviceSignUpMoney = user[1];

                int cnt = 0;
                int totalPrice= 0;
                for (Integer discountRule : picks) {
                    if (discountRule >= userRule){
                        // buy item !
                        totalPrice += emoticons[cnt] * (100 - discountRule) * 0.01;
                    }
                    cnt++;
                }
                if (serviceSignUpMoney - totalPrice <= 0){
                    serviceUser+=1;
                }else{
                    profit += totalPrice;
                }
            }
            if (answer[0] < serviceUser){
                answer[0] = serviceUser;
                answer[1] = profit;
            }else if (answer[0] == serviceUser){
                if (answer[1] < profit){
                    answer[1]= profit;
                }
            }
            return;
        }
        for (int rule : DISCOUNT_RULE) {
            picks.addLast(rule);
            dfs(users,emoticons,picks,numberOfEmoticons);
            picks.pollLast();
        }

    }
}