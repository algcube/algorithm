package programmers.HO.stack_queue.주식가격;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int count = 0;
            int price = prices[i];

            for (int j = (i+1); j < prices.length; j++) {
                count++;
                if (price > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }

        return answer;
    }
}