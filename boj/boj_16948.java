package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16948 {
    static class location {
        int r;
        int c;
        int cnt;
        location(int r, int c, int cnt) {
           this.r = r;
           this.c = c;
           this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        boolean[][] cache = new boolean[N][N];

        System.out.println(bfs(N, r1, c1, r2, c2, cache));
    }

    static int bfs(int N, int r1, int c1, int r2, int c2, boolean[][] cache) {
        Queue<location> q = new LinkedList<>();
        q.add(new location(r1, c1, 0));
        int[] dr = {0, -2, -2, 0, 0, 2, 2};
        int[] dc = {0, 1, -1, 2, -2, 1, -1};

        while (!q.isEmpty()) {
            location cur = q.poll();

            for (int i = 0; i < 7; i++) {
                if(cur.r + dr[i] == r2 && cur.c + dc[i] == c2) {
                    if(i == 0) {
                        return cur.cnt;
                    }
                    return cur.cnt + 1;
                }
                if(i != 0 && 0 <= cur.r + dr[i] && 0 <= cur.c + dc[i] && cur.r + dr[i] < N && cur.c + dc[i] < N
                && !cache[cur.r + dr[i]][cur.c + dc[i]]) {
                    q.add(new location(cur.r + dr[i], cur.c + dc[i], cur.cnt + 1));
                    cache[cur.r + dr[i]][cur.c + dc[i]] = true;
                }
            }
        }
        return -1;
    }
}
