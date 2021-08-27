package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14890 {
    static int N;
    static int L;
    static int count = 0;
    static int[][] arr;

    static void check(int r, boolean d) {
        int map[] = new int[N];
        // 이전 값을 저장한다.
        boolean[] vis = new boolean[N];

        // 행검사
        if (d) {
            for (int i = 0; i < N; i++) {
                map[i] = arr[r][i];
            }
        }
        // 열검사
        else {
            for (int i = 0; i < N; i++) {
                map[i] = arr[i][r];
            }
        }

        for (int i = 0; i < N - 1; i++) {
            // 격차가 1 초과라면 탈락한다.
            if (Math.abs(map[i] - map[i + 1]) > 1) return;

            // 같은 층이라면 넘어간다.
            if (map[i] == map[i + 1]) {
                continue;
            }

            // 오르막길일 경우 -> 자신을 기준으로 왼쪽으로 경사로를 둔다.
            if (map[i] < map[i + 1]) {
                for (int j = 0; j < L; j++) {
                    // 경사로를 놓을 공간이 충분하지 않으면 탈락한다.
                    if(i < j || vis[i - j]) return;
                    vis[i - j] = true;
                }
            }

            // 내리막길의 경우 -> 현재부터 오른쪽으로 경사로를 둔다.
            if (map[i] > map[i + 1]) {
                for (int j = 1; j <= L; j++) {
                    if (i + j >= N || map[i + j] != map[i + 1]) return;
                    vis[i + j] = true;
                }
            }
        }

        count++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            // 행검사
            check(i, true);
            // 열검사
            check(i, false);
        }

        System.out.println(count);
    }
}
