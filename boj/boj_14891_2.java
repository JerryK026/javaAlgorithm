package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_14891_2 {
    static int[][] teeth;
    static int K;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        teeth = new int[4][8];

        for (int i = 0; i < 4; i++) {
            String[] tokens = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                teeth[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            visited = new boolean[4];
            String[] tokens = br.readLine().split(" ");
            int idx = Integer.parseInt(tokens[0]) - 1;
            int dir = Integer.parseInt(tokens[1]);

            rotate(idx, dir);
        }

        int a = 1;
        int sum = 0;
        for (int i = 0; i < 4; i++, a *= 2) {
            sum += teeth[i][0] * a;
        }

        System.out.println(sum);
    }

    private static void rotate(int cur, int dir) {
        visited[cur] = true;

        int prev = cur - 1;
        int next = cur + 1;

        if (prev >= 0 && !visited[prev]) {
            if (teeth[cur][6] != teeth[prev][2]) {
                rotate(prev, dir * -1);
            }
        }

        if (next < 4 && !visited[next]) {
            if (teeth[cur][2] != teeth[next][6]) {
                rotate(next, dir * -1);
            }
        }

        rotateTeeth(cur, dir);
    }

    private static void rotateTeeth(int cur, int dir) {
        int tmp = teeth[cur][7];

        if (dir == -1) {
            tmp = teeth[cur][0];
            for (int i = 0; i < 7; i++) {
                teeth[cur][i] = teeth[cur][i + 1];
            }
            teeth[cur][7] = tmp;
            return;
        }

        for (int i = 7; i > 0; i--) {
            teeth[cur][i] = teeth[cur][i - 1];
        }
        teeth[cur][0] = tmp;
    }
}
