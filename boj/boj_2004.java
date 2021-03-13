package boj;

import java.io.*;

public class boj_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int two = 0;
        int five = 0;

        for(int i = 2; i <= n; i *= 2) two += (n - m) / i + 1;
        for(int i = 5; i <= n; i *= 5) five += (n - m) / i + 1;
        for(int i = 2; i <= m; i *= 2) {
            if(two <= 0) break;
            two -= (m - i) / i + 1;
        }
        for(int i = 5; i <= m; i *= 5) {
            if(two <= 0 || five <= 0) break;
            five -= (m - i) / i + 1;
        }

        int ten = (two < five) ? two : five;
        bw.write(String.valueOf((ten < 0) ? 0 : ten));
        bw.flush();
        bw.close();
    }
}
