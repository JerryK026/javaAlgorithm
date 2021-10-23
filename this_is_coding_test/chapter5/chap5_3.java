package this_is_coding_test.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class chap5_3 {
    static int N, M;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Box> queue = new LinkedList<>();
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    private static class Box {
        int x;
        int y;
        Box(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs() {
        queue.offer(new Box(0, 0));

        while (!queue.isEmpty()) {
            Box cur = queue.poll();
            if (cur.x == N - 1 && cur.y == M - 1) break;
            visited[cur.x][cur.y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < M && arr[nx][ny] == 1 && !visited[nx][ny]) {
                    arr[nx][ny] = arr[cur.x][cur.y] + 1;
                    queue.offer(new Box(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0;i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
                if (arr[i][j] == 0) visited[i][j] = true;
            }
        }

        bfs();
        System.out.println(arr[N - 1][M - 1]);
    }
}
