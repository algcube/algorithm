package programmers.CS.타겟넘버;

public class CS {

    static class Solution {
        public int solution(int[] numbers, int target) {
            return dfs(numbers, target, 0, 0, 0);
        }

        private int dfs(int[] numbers, int target, int index, int acc, int count) {
            if (index == numbers.length) {
                if (acc == target) {
                    return count + 1;
                }
                return count;
            }

            int countWithAddition = dfs(numbers, target, index + 1, acc + numbers[index], count);
            int countWithSubtraction = dfs(numbers, target, index + 1, acc - numbers[index], count);

            return countWithAddition + countWithSubtraction;
        }
    }
}
