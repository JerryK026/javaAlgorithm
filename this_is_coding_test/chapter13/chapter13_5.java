package this_is_coding_test.chapter13;

import java.util.Scanner;

public class chapter13_5 {
    static final Scanner sc = new Scanner(System.in);
    static int N;
    static int[] arr;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int calculate(int fir, int sec, int oper) {
        if (oper == 0) return fir + sec;
        if (oper == 1) return fir - sec;
        if (oper == 2) return fir * sec;
        return fir / sec;
    }

    static void dfs(int ptr, int val, int[] opers) {
        if (ptr == N - 1) {
            max = Math.max(max, val);
            min = Math.min(min, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opers[i] == 0) continue;
            opers[i] -= 1;
            dfs(ptr + 1, calculate(val, arr[ptr + 1], i), opers);
            opers[i] += 1;
        }
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        arr = new int[N];
        int[] opers = new int[4];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            opers[i] = sc.nextInt();
        }

        dfs(0, arr[0], opers);

        System.out.println(max);
        System.out.println(min);
    }
}
