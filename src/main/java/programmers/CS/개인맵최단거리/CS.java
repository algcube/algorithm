package programmers.CS.개인맵최단거리;


class CS {
    private static int[][] positions = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        visited[0][0] = true;
        int result = move(maps, visited, 0, 0, 1);
        return result == Integer.MAX_VALUE ? -1 : result;
    }


    private int move(int[][] maps, boolean[][] visited, int posX, int posY, int moveNumber) {
        if (posX == maps.length - 1 && posY == maps[0].length - 1) {
            return moveNumber;
        }

        int result = Integer.MAX_VALUE;
        for (int[] position : positions) {
            int dx = posX + position[0];
            int dy = posY + position[1];

            if (dx >= 0 && dx < maps.length && dy >= 0 && dy < maps[0].length &&
                    maps[dx][dy] != 0 && !visited[dx][dy]
            ) {
                visited[dx][dy] = true;
                result = Math.min(result, move(maps, visited, dx, dy, moveNumber + 1));
                visited[dx][dy] = false;
            }
        }
        return result;
    }
}