package this_is_coding_test.chapter13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chapter13_6 {
    static int N;
    static boolean answer = false;
    static ArrayList<Teacher> al = new ArrayList<>();

    static class Teacher {
        int x;
        int y;
        Teacher(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void obstacle(int cnt, int[][] arr) {
        if (cnt == 3) {
            if (check(arr)) answer = true;
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 2) {
                    arr[i][j] = 3;
                    obstacle(cnt + 1, arr);
                    arr[i][j] = 2;
                }
            }
        }
    }

    private static boolean check(int[][] arr) {
        for (int i = 0; i < al.size(); i++) {
            Teacher t = al.get(i);

            for (int dx = t.x; dx < N; dx++) {
                if (arr[dx][t.y] == 0) return false;
                if (arr[dx][t.y] == 3) break;
            }

            for (int dx = t.x; dx > -1; dx--) {
                if (arr[dx][t.y] == 0) return false;
                if (arr[dx][t.y] == 3) break;
            }

            for (int dy = t.y; dy < N; dy++) {
                if (arr[t.x][dy] == 0) return false;
                if (arr[t.x][dy] == 3) break;
            }

            for (int dy = t.y; dy > -1; dy--) {
                if (arr[t.x][dy] == 0) return false;
                if (arr[t.x][dy] == 3) break;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        // Student : 0, Teacher : 1, X : 2, Obstacle : 3
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String token = st.nextToken();
                if (token.equals("S")) arr[i][j] = 0;
                else if (token.equals("T")) {
                    arr[i][j] = 1;
                    al.add(new Teacher(i, j));
                }
                else arr[i][j] = 2;
            }
        }

        obstacle(0, arr);

        String can;
        if (answer) can = "YES";
        else can = "NO";

        System.out.println(can);

    }
}
