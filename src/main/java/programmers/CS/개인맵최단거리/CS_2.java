package programmers.CS.개인맵최단거리;
import java.util.LinkedList;
import java.util.Queue;

class CS_2{
    private static int[][] positions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    class Solution {

        public int solution(int[][] maps) {
            int n = maps.length;
            int m = maps[0].length;

            boolean[][] visited = new boolean[n][m];
            Queue<int[]> queue = new LinkedList();
            visited[0][0] = true;
            queue.add(new int[]{0,0,1}); //dx ,dy, cellNumber

            int result = Integer.MAX_VALUE;
            while(!queue.isEmpty()){
                int[] data = queue.poll();

                if(data[0] == n -1 && data[1] == m -1 ){
                    result = Math.min(result,data[2]);
                }

                for(int[] position : positions){
                    int dx = data[0] + position[0];
                    int dy = data[1] + position[1];

                    if(dx >= 0 && dx < n && dy >= 0 && dy < m && maps[dx][dy] == 1 && !visited[dx][dy] ){
                        visited[dx][dy] = true;
                        queue.add(new int[]{dx,dy,data[2]+1});
                    }
                }
            }


            return result == Integer.MAX_VALUE ? -1 : result;
        }
}}
