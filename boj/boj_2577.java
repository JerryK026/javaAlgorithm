package boj;

import java.io.*;

public class boj_2577 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int getNextNum() throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static void main(String[] args) throws IOException {
        int mul = 1;
        for (int i = 0; i < 3; i++) mul *= getNextNum();

        String s = String.valueOf(mul);
        int[] alp = new int[10];

        for (int i = 0; i < s.length(); i++) alp[s.charAt(i) - 48]++;

        StringBuilder sb = new StringBuilder();
        for (int cur : alp) sb.append(cur).append("\n");

        System.out.println(sb.toString());
    }
}
