package programmers.CS.이중우선순위큐;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        new Solution().solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
    }

    public int[] solution(String[] operations) {

        List<Integer> nums = new ArrayList<>();
        for (String operation : operations) {
            String[] data = operation.split(" ");

            String op = data[0];
            Integer num = Integer.parseInt(data[1]);

            if (op.equals("I")) {
                if (nums.isEmpty()) {
                    nums.add(num);
                    continue;
                }
                int capacity = nums.size();
                for (int i = 0; i < capacity; i++) {
                    if (nums.get(i) > num ) {
                        nums.add(i , num);
                        break;
                    }
                    if (i == capacity - 1) {
                        nums.add(num);
                    }
                }
            } else {
                if (!nums.isEmpty()) {
                    if (num == 1) {
                        nums.remove(nums.size() - 1);
                    } else {
                        nums.remove(0);
                    }
                }
            }
        }
        if (nums.isEmpty()) {
            return new int[]{0, 0};
        }
        return new int[]{nums.get(nums.size() - 1), nums.get(0)};
    }
}