package programmers.CS.기능개발;

import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList();
        boolean[] visited = new boolean[progresses.length];
        for(int i = 0; i< progresses.length && !visited[i]; i++){
            if(visited[i]){
                continue;
            }
            visited[i]= true;
            int job = progresses[i];
            int speed = speeds[i];
            double restDay = Math.ceil((double) (100-job) / speed);
            int cnt = 1;
            for(int j = i +1 ; j < progresses.length ; j++){

                if( !visited[j] && (speeds[j] * restDay )>= (100-progresses[j])){
                    visited[j] = true;
                    cnt+=1;
                }else{
                    break;
                }
            }
            result.add(cnt);

        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}