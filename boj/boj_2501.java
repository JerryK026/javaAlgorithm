package boj;

import java.io.*;

public class boj_2501 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String[] input = br.readLine().split(" ");

        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);

        int cnt = 0;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (N % i == 0) cnt++;
            if (cnt == K) {
                result = i;
                break;
            }
        }
        if (cnt < K) result = 0;

        System.out.println(result);
    }
}

