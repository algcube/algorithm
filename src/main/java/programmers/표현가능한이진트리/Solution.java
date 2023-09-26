package programmers.표현가능한이진트리;

import java.util.Arrays;
class Solution {

    public static void main(String[] args) {
        new Solution().solution(new long[]{7, 42, 5});
    }

    public int[] solution(long[] numbers) {

        int[] answer = new int[numbers.length];
        int cnt = 0;
        for (long number : numbers) {

            int treeHeight = 1;
            double maxNode;
            double maxNumber;
            while (true) {
                maxNode = Math.pow(2, treeHeight++) - 1;
                maxNumber = Math.pow(2, maxNode) - 1;
                if (number <= maxNumber) {
                    break;
                }
            }
            String input = Long.toBinaryString(number);
            while(input.length() < maxNode ){
                input="0"+input;
            }

            boolean result = isValidBinaryTree(input);
            if(result){
                answer[cnt] = 1;
            }
            cnt++;
        }

        return answer;
    }

    private boolean isValidBinaryTree(String input){
        int mainIdx = (input.length()-1) / 2;
        String leftTree = input.substring(0,mainIdx);
        String rightTree = input.substring(mainIdx+1,input.length());

        if (input.charAt(mainIdx) == '0' && (
                (leftTree.charAt((leftTree.length()-1) / 2) == '1') || (rightTree.charAt((rightTree.length()-1) / 2) == '1')  )
        ){
            return false;
        }

        if(leftTree.length() >= 3 ){
            return isValidBinaryTree(leftTree) && isValidBinaryTree(rightTree);
        }
        return true;
    }
}