package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_15683 {
    static class loc {
        int row;
        int col;
        int status;
        loc (int row, int col, int status) {
            this.row = row;
            this.col = col;
            this.status = status;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<loc> q = new LinkedList<>();

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        boolean[][] room = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                    switch (arr[i][j]) {
                        case 0:
                            break;
                        case 1:
                            for (int k = 0; k < 4; k++) {
                                q.offer(new loc(i, j, k));
                            }
                            break;
                        case 2:
                            for (int k = 4; k < 6; k++) {
                                q.offer(new loc(i, j, k));
                            }
                            break;
                        case 3:
                            for (int k = 6; k < 10; k++) {
                                q.offer(new loc(i, j, k));
                            }
                            break;
                        case 4:
                            for (int k = 10; k < 14; k++) {
                                q.offer(new loc(i, j, k));
                            }
                            break;
                        case 5:
                            q.offer(new loc(i, j, 14));
                            break;
                    }
                    if(arr[i][j] != 0)room[i][j] = true;
            }
        }

        int min = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            loc cur = q.poll();

        }


    }
}
