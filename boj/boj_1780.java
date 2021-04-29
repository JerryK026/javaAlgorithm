package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1780 {
    static int[][] arr;
    static boolean[][] visited;
    static int zero, one, mone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    check(i, j);
                }
            }
        }

        System.out.println(mone);
        System.out.println(zero);
        System.out.println(one);
    }

    static void check(int a, int b) {
        int val = arr[a][b];
        boolean pass;
        if(a % 3 == 0 && b % 3 == 0) pass = true;
        else pass = false;
        int cnt = 0;

        while (pass) {
            pass = check2(a, b, cnt);
            cnt += 1;
        }
        cnt -= 2;

        for (int i = a; i < a + Math.pow(3, cnt); i++) {
            for (int j = b; j < b + Math.pow(3, cnt); j++) {
                visited[i][j] = true;
            }
        }

        if(val == 0) zero += 1;
        else if(val == 1) one += 1;
        else mone += 1;
    }

    static boolean check2(int a, int b, int times) {
        int val = arr[a][b];

        for (int i = a; i < a + Math.pow(3, times); i++) {
            for (int j = b; j < b + Math.pow(3, times); j++) {
                if (i >= arr.length || j >= arr.length) {
                    return false;
                }
                if (val != arr[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
