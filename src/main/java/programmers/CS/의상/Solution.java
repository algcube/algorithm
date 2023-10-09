package programmers.CS.의상;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap();
        for (String[] cloth : clothes) {
            if (map.containsKey(cloth[1])) {
                map.put(cloth[1], map.get(cloth[1]) + 1);
            } else {
                map.put(cloth[1], 1);
            }
        }
        int sum = 1;
        for (String k : map.keySet()) {
            sum *= (map.get(k) + 1);
        }
        return sum - 1;
    }
}