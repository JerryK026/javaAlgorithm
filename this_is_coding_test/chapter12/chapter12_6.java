package this_is_coding_test.chapter12;
import java.util.*;

public class chapter12_6 {
    static class Solution {
        static class Struct implements Comparable<Struct> {
            int x;
            int y;
            int kind;

            private Struct(int x, int y, int kind) {
                this.x = x;
                this.y = y;
                this.kind = kind;
            }

            @Override
            public int compareTo(Struct s) {
                if (this.x < s.x) return -1;
                else if (this.x > s.x) return 1;
                else {
                    return this.y - s.y;
                }
            }
        }

        private boolean check(int[][] arr, int type, int x, int y, int n) {
            // 기둥은 바닥 위에 있거나 보의 한쪽 끝 부분 위에 있거나, 또는 다른 기둥 위에 있어야 합니다.
            if (type == 0) {
                if (y == 0) return true;
                else if (x > 0 && (arr[x - 1][y] == 1 || arr[x][y] == 1)) return true;
                else if (y > 0 && arr[x][y - 1] == 0) return true;
                return false;
            }
            // 보는 한쪽 끝 부분이 기둥 위에 있거나, 또는 양쪽 끝 부분이 다른 보와 동시에 연결되어 있어야 합니다.
            if (y > 0 && (arr[x][y - 1] == 0 || arr[x + 1][y - 1] == 0)) return true;
            if (x > 0 && (arr[x - 1][y] == 1 && arr[x + 1][y] == 1)) return true;

            return false;
        }

        public int[][] solution(int n, int[][] build_frame) {
            final int rl = build_frame.length;
            final int cl = 4;

            // 0부터 n까지의 크기이므로 1을 더한다.
            n++;

            int[][] arr = new int[n][n];
            boolean[][] pil = new boolean[n][n];
            boolean[][] beam = new boolean[n][n];

            // 정보를 담기 위한 배열인 arr의 값을 채운다. -1은 아무것도 없다는 의미이다.
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = -1;
                }
            }

            for (int i = 0; i < rl; i++) {
                int x = build_frame[i][0];
                int y = build_frame[i][1];
                int type = build_frame[i][2];
                int order = build_frame[i][3];

                // 삭제 명령을 수행한다.
                if (order == 0) {
                    arr[x][y] = -1;
                    for (int a = 0; a < n; a++) {
                        for (int b = 0; b < n; b++) {
                            if (type == 0) {
                                if(pil[a][b] && !check(arr, type, a, b, n)) {
                                    b = n;
                                    a = n;
                                    arr[x][y] = type;
                                }
                            } else {
                                if(beam[a][b] && !check(arr, type, a, b, n)) {
                                    b = n;
                                    a = n;
                                    arr[x][y] = type;
                                }
                            }
                        }
                    }
                    continue;
                }

                // 설치 명령을 수행한다.
                if (check(arr, type, x, y, n)) arr[x][y] = type;
                if (type == 0) pil[x][y] = true;
                else beam[x][y] = true;
            }

            int count = 0;
            ArrayList<Struct> sarr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 보 혹은 기둥의 정보가 담긴 경우 담는다.
                    if (arr[i][j] != -1) {
                        count++;
                        sarr.add(new Struct(i, j, arr[i][j]));
                    }
                }
            }

            Collections.sort(sarr);

            // count의 수 만큼 원소가 존재할 것
            int[][] answer = new int[count][3];

            for (int i = 0; i < count; i++) {
                Struct s = sarr.get(i);
                answer[i][0] = s.x;
                answer[i][1] = s.y;
                answer[i][2] = s.kind;
            }

            return answer;
        }
    }
}
