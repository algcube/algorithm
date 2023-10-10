package programmers.CS.프렌즈4블록;

class Solution {
    public int solution(int m, int n, String[] board) {
        int count = 0;
        char[][] input = new char[m][n];
        for (int i = 0; i < m; i++) {
            input[i] = board[i].toCharArray();
        }
        while (true) {
            boolean[][] remove = new boolean[m][n];
            boolean isRemovedAny = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (input[i][j] != '#' &&
                            input[i][j] == input[i + 1][j] &&
                            input[i][j] == input[i][j + 1] &&
                            input[i][j] == input[i + 1][j + 1]) {
                        remove[i][j] = true;
                        remove[i + 1][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j + 1] = true;
                        isRemovedAny = true;
                    }
                }
            }
            if (!isRemovedAny) {
                break;
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (remove[i][j]) {
                        input[i][j] = '#';
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (input[i][j] == '#') {
                        int cnt = i;
                        while (cnt - 1 >= 0) {
                            input[cnt][j] = input[--cnt][j]; // 한칸씩떙기기
                            input[cnt][j] = '#';
                        }
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (input[i][j] == '#') {
                    count++;
                }
            }
        }
        return count;
    }
}