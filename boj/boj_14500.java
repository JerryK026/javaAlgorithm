package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14500 {
    static int N, M;
    static int[][] arr;
    static int[] dh = {-1, 1, 0, 0};
    static int[] dw = {0, 0, -1, 1};
    static boolean[][] visited;
    static int sum = 0;

    static void DFS(int h, int w, int depth, int curSum) {

        if (depth == 4) {
            sum = Math.max(sum, curSum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextH = h + dh[i];
            int nextW = w + dw[i];

            if (nextH < 0 || nextW < 0 || nextH >= N || nextW >= M) {
                continue;
            }
            if (visited[nextH][nextW]) {
                continue;
            }
            visited[nextH][nextW] = true;
            DFS(nextH, nextW, depth + 1, curSum + arr[nextH][nextW]);
            visited[nextH][nextW] = false;

        }
    }

    static void ETC(int h, int w) {
        int tmp = 0;

        if (w + 2 < M) {
            if (h + 1 < N) {
                tmp = arr[h][w] + arr[h][w + 1] + arr[h][w + 2] + arr[h + 1][w + 1];
                sum = Math.max(sum, tmp);
            }
            if (h - 1 > 0) {
                tmp = arr[h][w] + arr[h][w + 1] + arr[h][w + 2] + arr[h - 1][w + 1];
                sum = Math.max(sum, tmp);
            }
        }
        if (0 < w - 2) {
            if (h + 1 < N) {
                tmp = arr[h][w] + arr[h][w - 1] + arr[h][w - 2] + arr[h + 1][w - 1];
                sum = Math.max(sum, tmp);
            }
            if (h - 1 > 0) {
                tmp = arr[h][w] + arr[h][w - 1] + arr[h][w - 2] + arr[h - 1][w - 1];
                sum = Math.max(sum, tmp);
            }
        }
        if (0 < h - 2) {
            if (w + 1 < M) {
                tmp = arr[h][w] + arr[h - 1][w] + arr[h - 2][w] + arr[h - 1][w + 1];
                sum = Math.max(sum, tmp);
            }
            if (w - 1 > 0) {
                tmp = arr[h][w] + arr[h - 1][w] + arr[h - 2][w] + arr[h - 1][w - 1];
                sum = Math.max(sum, tmp);
            }
        }
        if (h + 2 < N) {
            if (w + 1 < M) {
                tmp = arr[h][w] + arr[h + 1][w] + arr[h + 2][w] + arr[h + 1][w + 1];
                sum = Math.max(sum, tmp);
            }
            if (w - 1 > 0) {
                tmp = arr[h][w] + arr[h + 1][w] + arr[h + 2][w] + arr[h + 1][w - 1];
                sum = Math.max(sum, tmp);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DFS(i, j, 0, 0);
                ETC(i,j);
            }
        }

        System.out.println(sum);
    }
}
