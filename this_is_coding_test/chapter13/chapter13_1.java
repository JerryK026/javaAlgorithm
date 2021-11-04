package this_is_coding_test.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chapter13_1 {
    static class Move {
        int point;
        int cnt;

        Move (int point, int cnt) {
            this.point = point;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Move> q = new LinkedList<>();

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        final int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arr = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            arr[i] = new ArrayList();
        }

        // 0 : 아직 접근하지 못함. 1 : 접근한 적 있음. -1 : 최단거리가 아님.
        int[] shortest = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from].add(to);
        }

        q.offer(new Move(X, 0));

        while(!q.isEmpty()) {
            Move cur = q.poll();
            int point = cur.point;

            if (cur.cnt == K) {
                if (shortest[point] != -1) shortest[point] = 1;
            }
            else {
                shortest[point] = -1;
                for (int x : arr[point]) {
                    if (shortest[x] != -1 ) q.offer(new Move(x, cur.cnt + 1));
                }
            }
        }

        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            if (shortest[i] == 1) {
                System.out.println(i);
                cnt++;
            }
        }
        if (cnt == 0) System.out.println(-1);
    }
}
