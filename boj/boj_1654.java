package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] Lans = new int[K];

        for(int i = 0; i < K; i++) Lans[i] = Integer.parseInt(br.readLine());

        Arrays.sort(Lans);

        binSearch(Lans, N);
    }

    static void binSearch(int[] Lans, int N) {
        long left = 1, right = Lans[Lans.length - 1];
        long middle = 0;

        while(left <= right) {
            middle = (left + right) / 2;
            if(check(Lans, middle, N)) {
                left = middle + 1;

            }
            else right = middle - 1;
        }
        System.out.println(right);
    }

    static boolean check(int[] Lans, long middle, int N) {
        long count = 0;
        for(int i = 0; i < Lans.length; i++) {
            count += Lans[i] / middle;
        }
        return N <= count;
    }
}
