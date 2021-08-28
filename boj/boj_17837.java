package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_17837 {
    static class Unit {
        int y;
        int x;
        int dir;

        Unit(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }

    static class Board {
        int val;
        Stack<Integer> s;

        Board(int val) {
            this.val = val;
            this.s = new Stack<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Board[][] arr = new Board[N][N];
        Unit[] unit = new Unit[K];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = new Board(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            unit[i] = new Unit(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
            arr[unit[i].y][unit[i].x].s.push(i);
        }

        boolean flag = true;

        for (int count = 1; flag; count++) {
            for (int i = 0; i < K; i++) {
                Unit u = unit[i];
                int dx = u.x;
                int dy = u.y;
                // 말의 방향을 확인한다.
                int dir = u.dir;
                switch (dir) {
                    case 1:
                        dx += 1;
                        break;
                    case 2:
                        dx -= 1;
                        break;
                    case 3:
                        dy -= 1;
                        break;
                    case 4:
                        dy += 1;
                        break;
                }
                // 움직일 타일이 2거나 보드 밖이라면 방향만 바꾼다.
                if (dy < 0 || N <= dy || dx < 0 || N <= dx || arr[dy][dx].val == 2) {
                    int size = arr[u.y][u.x].s.size();
                    for (int j = 0; j < size; j++) {
                        int tmp = arr[u.y][u.x].s.pop();
                        unit[tmp].dir = unit[tmp].dir % 2 == 0 ? unit[tmp].dir - 1 : unit[tmp].dir + 1;
                        q.offer(tmp);
                    }
                }

                // 움직일 타일이 0 혹은 1이라면 그냥 움직인다.
                else {
                    int tmp = -1;
                    while (tmp != i) {
                        tmp = arr[u.y][u.x].s.pop();
                        unit[tmp].x = dx;
                        unit[tmp].y = dy;
                        // 움직일 타일이 0일 경우 큐에 집어넣는다.
                        if (arr[dy][dx].val == 0) q.offer(tmp);
                            // 움직일 타일이 1일 경우 스택에 집어넣는다.
                        else arr[dy][dx].s.push(tmp);
                    }
                }
                while (!q.isEmpty()) {
                    arr[u.y][u.x].s.push(q.poll());
                }

                if (arr[u.y][u.x].s.size() == K) {
                    System.out.println(count);
                    flag = false;
                    break;
                }
            }
            // 움직이고 난 후, stack의 크기가 K라면 count를 출력한 후 종료한다.
            if (count == 1000) {
                System.out.println(-1);
                break;
            }
        }
    }
}
