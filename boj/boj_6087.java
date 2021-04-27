package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6087 {
    static Queue<loc> q = new LinkedList<>();
    static class loc {
        int x;
        int y;
        int cnt;
        int prev;
        // prev 1 : up, 2 : left, 3 : down, 4 : right
        loc(int x, int y, int cnt, int prev) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.prev = prev;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int[][] arr = new int[H][W];
        boolean[][] visited = new boolean[H][W];
        boolean flag = true;

        for(int i = 0; i < H; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < W; j++) {
                if(str[j].equals(".")) {
                    arr[i][j] = 0;
                }
                else if(str[j].equals("C")) {
                    arr[i][j] = 1;
                    if(flag) {
                        q.add(new loc(i, j, 0, 0));
                        flag = false;
                        visited[i][j] = true;
                    }
                }
                else {
                    arr[i][j] = -1;
                }
            }
        }

        System.out.println(bfs(arr, visited));
    }
    static int bfs(int[][] arr, boolean[][] visited) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] prevs = {1, 3, 2, 4};

        while (!q.isEmpty()) {
            loc cloc = q.poll();

            if(arr[cloc.x][cloc.y] == 1 && cloc.cnt != 0) {
                return cloc.cnt - 1;
            }
            for(int i = 0; i < 4; i++) {
                int nx = cloc.x + dx[i];
                int ny = cloc.y + dy[i];

                if(0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length) {
                    if (!visited[nx][ny] && arr[nx][ny] != -1) {
                        int mirrorCheck = 1;
                        if(prevs[i] == cloc.prev || cloc.prev == 0) {
                            mirrorCheck--;
                        }
                        q.add(new loc(nx, ny, cloc.cnt + mirrorCheck, prevs[i]));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return 0;
    }
}
