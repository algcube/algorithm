package programmers.전화번호목록;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        new Solution().solution(new String[]{"12", "88", "1235"});
    }

    public boolean solution(String[] phone_book) {
        String[] sortedPhoneBooks = Arrays.stream(phone_book).sorted().toArray(String[]::new);
        for (int i = 0; i < sortedPhoneBooks.length; i++) {
            String value = sortedPhoneBooks[i];
            if (i + 1 < sortedPhoneBooks.length && sortedPhoneBooks[i + 1].startsWith(value)) {
                return false;
            }
        }
        return true;
    }
}
