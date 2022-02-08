package boj;

import java.io.*;

public class boj_15650 {
    static final StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static boolean[] checked;
    static int[] answer;

    static void dfs(int depth) {
        if (depth == M) {
            for (int val : answer) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (depth > 0 && answer[depth - 1] >= i + 1) continue;
            if (!checked[i]) {
                checked[i] = true;
                answer[depth] = i + 1;
                dfs(depth + 1);
                checked[i] = false;
            }
        }
        return;

    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        checked = new boolean[N];
        answer = new int[M];

        dfs(0);

        System.out.println(sb.toString());
    }
}
