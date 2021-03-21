package boj;

import java.io.*;

public class boj_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cur;
        int[] cache = new int[11];
        cache[2] = 1;
        for(int i = 3; i < 11; i++) cache[i] = cache[i - 1] * 2 + 1;

        for(int i = 0; i < Integer.parseInt(br.readLine()); i++) {
            cur = Integer.parseInt(br.readLine());

        }
    }
}
