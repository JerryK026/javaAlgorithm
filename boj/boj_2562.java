package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2562 {
    static final int N = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int idx = -1;
        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(br.readLine());
            result = Math.max(result, cur);
            if (result == cur) idx = i;
        }

        System.out.println(result + "\n" + idx);
    }
}

