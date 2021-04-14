package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_3079 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] T = new int[N];

        for(int i = 0; i < N; i++) T[i] = Integer.parseInt(br.readLine());
        Arrays.sort(T);

        long result = BinSearch(T, M);
        System.out.println(result);
    }

    static long BinSearch(int[] T, int M) {
        long left = 1, right = (long)T[T.length - 1] * M, middle = 0;
        long result = Long.MAX_VALUE;

        while(left <= right) {
            middle = (left + right) / 2;
            if(canPass(T, M, middle)) {
                result = middle < result ? middle : result;
                right = middle - 1;
            }
            else left = middle + 1;
        }

        return result;
    }

    static boolean canPass(int[] T, int M, long middle) {
        long count = 0;
        for(int i = 0; i < T.length; i++) {
            count += middle / T[i];
        }
        return M <= count;
    }
}
