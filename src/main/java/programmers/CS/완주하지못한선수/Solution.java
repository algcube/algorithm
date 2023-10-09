package programmers.CS.완주하지못한선수;

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap();
        for (String person : participant) {
            if (map.containsKey(person)){
                map.put(person,map.get(person) + 1);
            }else{
                map.put(person,1);
            }
        }
        for (String person : completion) {
            Integer cnt = map.get(person);
            if (cnt == 1){
                map.remove(person);
            }else{
                map.put(person,cnt-1);
            }
        }
        return map.keySet().iterator().next();
    }
}