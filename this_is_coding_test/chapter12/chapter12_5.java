package this_is_coding_test.chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class chapter12_5 {
    private static class Snake {
        int x;
        int y;
        Snake(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class SnakeDir {
        int sec;
        String dir;
        SnakeDir(int sec, String dir) {
            this.sec = sec;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        int[][] loc = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board;
        HashMap<Integer, Integer> appleMap = new HashMap<>();
        Queue<SnakeDir> sdq = new LinkedList<>();
        Queue<Snake> snake = new LinkedList<>();
        int sec = 0;
        int cur = 0;
        // x : 행, y : 열
        int x = 0;
        int y = 0;
        // 꼬리의 위치
        int tx = 0;
        int ty = 0;

        final int N = Integer.parseInt(br.readLine());
        final int K = Integer.parseInt(br.readLine());

        board = new int[N][N];
        board[0][0] = 1;

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            board[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = 2;
        }

        final int L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            String[] input = br.readLine().split(" ");
            sdq.offer(new SnakeDir(Integer.parseInt(input[0]), input[1]));
        }

        SnakeDir sd = sdq.poll();

        // D라면 loc[cur++] L이라면 loc[cur--]
        while(true) {
            sec++;

            snake.offer(new Snake(x, y));
            x += loc[cur][1];
            y += loc[cur][0];

            // 벽에 부딪히거나 자기 자신에 부딪히는 경우 종료한다.
            if (x < 0 || x == N || y < 0 || y == N || board[x][y] == 1) break;

            // 사과를 먹지 않는 경우 꼬리를 자른다.
            if (board[x][y] != 2) {
                Snake tmp = snake.poll();
                board[tmp.x][tmp.y] = 0;
            }

            board[x][y] = 1;

            if (sd.sec == sec) {
                if (sd.dir.equals("D")) cur++;
                else cur--;

                if (!sdq.isEmpty()) {
                    sd = sdq.poll();
                    if (cur < 0) cur = 3;
                    else if (cur == 4) cur = 0;
                }
                else {
                    sd.sec = Integer.MAX_VALUE;
                }
            }
        }

        System.out.println(sec);
    }
}
