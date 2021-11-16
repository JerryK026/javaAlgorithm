package this_is_coding_test.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chapter13_3 {
    static class Loc {
        int num;
        int x;
        int y;
        Loc (int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        final int N = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][K + 1];
        ArrayList<Loc>[] virus = new ArrayList[K + 1];

        for (int i = 1; i < K + 1; i++) {
            virus[i] = new ArrayList<>();
        }

        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0) {
                    virus[arr[i][j]].add(new Loc(arr[i][j], i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        final int S = Integer.parseInt(st.nextToken());
        final int X = Integer.parseInt(st.nextToken());
        final int Y = Integer.parseInt(st.nextToken());

        Queue<Loc> q = new LinkedList<>();
        for (int i = 1; i < K + 1; i++) {
            for (int j = 0; j < virus[i].size(); j++) {
                q.add(virus[i].get(j));
            }
        }

        int flag = 0;
        int cnt = 0;
        while (cnt < S) {
            if (q.isEmpty()) break;
            Loc cur = q.poll();
            flag = cur.num;

            if (flag == K && cnt == 0) cnt++;
            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + cur.x;
                int ny = dy[j] + cur.y;

                if (0 < nx && nx <= N && 0 < ny && ny <= N) {
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = cur.num;
                        q.add(new Loc(cur.num, nx, ny));
                    }
                }
            }
        }

        System.out.println(arr[X][Y]);
    }
}
