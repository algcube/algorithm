package programmers.전화번호목록;

import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        String[] sortedPhoneBooks = Arrays.stream(phone_book).sorted().toArray(String[]::new);
        for (int i = 0 ; i < sortedPhoneBooks.length; i++){
            String value = sortedPhoneBooks[i];
            for (int j = i+1; j < sortedPhoneBooks.length;j++){
                if (sortedPhoneBooks[j].startsWith(value)){
                    return false;
                }
            }
        }
        return true;
    }
}