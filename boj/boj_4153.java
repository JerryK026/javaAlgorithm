package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_4153 {
    static final int N = 3;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int[] fillInput(int[] input) throws IOException {
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        return input;
    }

    static boolean isFinished(int[] input) {
        return input[0] == 0 && input[1] == 0 && input[2] == 0;
    }

    static boolean isRectangle(int[] input) {
        Arrays.sort(input);
        return Math.pow(input[0], 2) + Math.pow(input[1], 2) == Math.pow(input[2], 2);
    }

    public static void main(String[] args) throws IOException {
        int[] input = new int[N];
        input = fillInput(input);

        while(!isFinished(input)) {
            if (isRectangle(input)) sb.append("right\n");
            else sb.append("wrong\n");

            input = fillInput(input);
        }

        System.out.println(sb);
    }
}
