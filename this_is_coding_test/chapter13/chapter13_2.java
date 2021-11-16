package this_is_coding_test.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chapter13_2 {
    static int N;
    static int M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    static int[][] arr;
    static int[][] wall;

    static void virus(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (wall[nx][ny] == 0) {
                    wall[nx][ny] = 2;
                    virus(nx, ny);
                }
            }
        }
    }

    static void updateScore() {
        int score = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (wall[i][j] == 0) score++;
            }
        }

        max = Math.max(max, score);
    }

    static void dfs(int cnt) {
        if (cnt == 3) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    wall[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (wall[i][j] == 2) {
                        virus(i, j);
                    }
                }
            }
            updateScore();
            return;
        }

        for (int i = 0 ; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    dfs(cnt + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        wall = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);

    }
}
