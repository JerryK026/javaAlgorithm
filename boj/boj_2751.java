package boj;

import java.io.*;
import java.util.Arrays;

public class boj_2751 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        final int[] arr = new int[N];

        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        final StringBuilder sb = new StringBuilder();
        for (int cur : arr) {
            sb.append(cur).append("\n");
        }

        System.out.println(sb.toString());
    }
}
