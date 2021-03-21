package boj;

import java.io.*;

public class boj_11727 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int [] cache = new int[n + 2];

        cache[1] = 1;
        cache[2] = 3;
        for(int i = 3; i <= n; i++) {
            cache[i] = (cache[i - 1] + 2 * cache[i - 2]) % 10007;
        }
        bw.write(String.valueOf(cache[n] % 100007));
        bw.flush();
        bw.close();
    }
}
