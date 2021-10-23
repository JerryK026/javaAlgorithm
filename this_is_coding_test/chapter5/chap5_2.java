package this_is_coding_test.chapter5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chap5_2 {
    static int[][] graph;
    static boolean[][] visited;
    static int N, M, cnt = 0;

    private static void dfs(int i, int j) {
        if (visited[i][j] == true) return;

        visited[i][j] = true;
        if (j - 1 > 0 && graph[i][j - 1] == 0) dfs(i , j - 1);
        if (j + 1 < M && graph[i][j + 1] == 0) dfs(i, j + 1);
        if (i - 1 > 0 && graph[i - 1][j] == 0) dfs(i - 1, j);
        if (i + 1 < N && graph[i + 1][j] == 0) dfs(i + 1, j);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(input[j]);
                if (graph[i][j] == 1) visited[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0 && !visited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }
}
