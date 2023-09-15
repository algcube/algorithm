package bj.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CS_3190 {

    static int[][] board;
    static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int row = Integer.parseInt(input[0]);
            int col = Integer.parseInt(input[1]);
            board[row - 1][col - 1] = 1;
        }
        int L = Integer.parseInt(br.readLine());

        Map<Integer, String> moveInfo = new HashMap<>();
        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            moveInfo.put(Integer.parseInt(input[0]), input[1]);
        }

        int second = 0;
        Snake snake = new Snake();
        boolean isGameEnd = false;
        while (!isGameEnd) {
            isGameEnd = snake.move();
            String direction = moveInfo.get(++second);
            if (direction != null) {
                snake.changeHeadPosition(direction);
            }
        }
        System.out.println(second);
    }

    static class Snake {
        int headRow;
        int headCol;
        int headDirection = 0;
        Deque<int[]> tails = new ArrayDeque();

        private boolean isConflict() {
            return (headCol < 0 || headRow < 0 || headCol >= board.length || headRow >= board.length);
        }

        public boolean move() {
            tails.addLast(new int[]{headRow, headCol});
            headRow += direction[headDirection][0];
            headCol += direction[headDirection][1];
            if (isConflict() || isEatingSelf()) {
                return true;
            }
            // if snake found apple
            if (board[headRow][headCol] == 1) {
                board[headRow][headCol] = 0;
                // do not remove tail
            } else {
                // remove tail
                tails.removeFirst();
            }
            return false;
        }

        private boolean isEatingSelf() {
            for (int[] tail : tails) {
                if (tail[0] == headRow && tail[1] == headCol) {
                    return true;
                }
            }
            return false;
        }

        // 왼쪽(C가 'L') 또는 오른쪽(C가 'D')
        public void changeHeadPosition(String direction) {
            if (direction.equals("D")) {
                headDirection = (headDirection + 1) % 4;
            } else if (direction.equals("L")) {
                headDirection = (headDirection + 3) % 4;
            }
        }
    }
}











