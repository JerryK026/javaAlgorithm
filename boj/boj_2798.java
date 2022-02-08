package boj;

import java.io.*;

public class boj_2798 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        final int N = Integer.parseInt(input[0]);
        final int M = Integer.parseInt(input[1]);

        final int[] arr = new int[N];

        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            int sum = arr[i];
            for (int j = i + 1; j < N; j++) {
                int sum2 = sum + arr[j];
                for (int k = j + 1; k < N; k++) {
                    int sum3 = sum2 + arr[k];
                    if (sum3 <= M) result = Math.max(result, sum3);
                }
            }
        }

        System.out.println(result);
    }
}
