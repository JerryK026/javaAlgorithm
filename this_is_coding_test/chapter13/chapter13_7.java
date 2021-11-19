package this_is_coding_test.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class chapter13_7 {
    static int N, L, R;
    static int[][] arr;
    static int[][] unions;
    static boolean flag;

    static class Country {
        int x;
        int y;

        Country(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void open(int x, int y, int index) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int sum = arr[x][y];
        int cnt = 1;

        ArrayList<Country> countries = new ArrayList<>();
        Queue<Country> q = new LinkedList<>();
        q.offer(new Country(x, y));
        countries.add(new Country(x, y));
        unions[x][y] = index;

        while(!q.isEmpty()) {
            Country c = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + c.x;
                int ny = dy[i] + c.y;

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && unions[nx][ny] == -1) {
                    int sub = Math.abs(arr[c.x][c.y] - arr[nx][ny]);
                    if (L <= sub && sub <= R) {
                        unions[nx][ny] = index;
                        q.offer(new Country(nx, ny));
                        countries.add(new Country(nx, ny));
                        flag = true;
                        sum += arr[nx][ny];
                        cnt++;
                    }
                }
            }
        }

        for (int i = 0; i < countries.size(); i++) {
            Country c = countries.get(i);
            arr[c.x][c.y] = sum / cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        unions = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        while (true) {
            flag = false;
            int index = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    unions[i][j] = -1;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (unions[i][j] == -1) open(i, j, index++);
                }
            }

            if (!flag) break;
            cnt++;
        }

        System.out.println(cnt);
    }
}
