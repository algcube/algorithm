package programmers.미로탈출명령어;


class Solution {
    private static String[][] directions = {{"1,0", "d"}, {"0,-1", "l"}, {"0,1", "r"}, {"-1,0", "u"}};
    private static String answer = null;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        dfs(n, m, x, y, r, c, k, "", Math.abs(r - x) + Math.abs(c - y));
        return answer != null ? answer : "impossible";
    }

    private void dfs(int n, int m, int x, int y, int r, int c, int k, String route, int diff) {
        if (k < diff ||
                ((k - diff) % 2 != 0) ||
                answer != null || x > n || y > m || x < 1 || y < 1) {
            return;
        }

        if (k == 0) {
            if (x == r && y == c) {
                answer = route;
            }
            return;
        }
        for (String[] direction : directions) {
            String[] move = direction[0].split(",");
            int dx = Integer.parseInt(move[0]);
            int dy = Integer.parseInt(move[1]);
            String repr = direction[1];
            dfs(n, m, x + dx, y + dy, r, c, k - 1, route + repr, Math.abs(r - (x + dx)) + Math.abs(c - (y + dy)));
        }

    }
}