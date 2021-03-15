package boj;

import java.io.*;
import java.util.StringTokenizer;

public class boj_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int N = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int [] sum = new int[stk.countTokens() + 1];

        sum[0] = 0;
        for(int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(stk.nextToken());
        }

        int start, end;

        for(int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine());
            start = Integer.parseInt(stk.nextToken()) - 1;
            end = Integer.parseInt(stk.nextToken());
            bw.write(String.valueOf(sum[end] - sum[start]) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
