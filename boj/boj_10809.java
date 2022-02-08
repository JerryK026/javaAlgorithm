package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10809 {
    public static void main(String[] args) throws IOException {
        final int N = 26;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String S = br.readLine();
        int[] alp = new int[N];

        for (int i = 0; i < N; i++) {
            alp[i] = -1;
        }

        for (int i = 0; i < S.length(); i++) {
            if (alp[S.charAt(i) - 97] == -1) alp[S.charAt(i) - 97] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int cur : alp) {
            sb.append(cur).append(" ");
        }

        System.out.println(sb.toString());
    }
}
