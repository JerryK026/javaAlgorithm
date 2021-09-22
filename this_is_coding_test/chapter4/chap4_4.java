package this_is_coding_test.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chap4_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[][] cache = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dA = {0, 1, 0, -1};
        int[] dB = {-1, 0, 1, 0};

        int cnt = 1;
        int tmp = 0;
        while (true) {
            int r = A + dA[d];
            int c = B + dB[d];
            if (0 <= r && r < N && 0 <= c && c < M && arr[r][c] == 0 && cache[r][c] == 0) {
                A = r;
                B = c;
                cache[A][B] = 1;
                cnt++;
                tmp = -1;
            }
            else {
                if (tmp == 4) {
                    r = A - dA[d];
                    c = B - dB[d];
                    if (arr[r][c] == 0) {
                        A = r;
                        B = c;
                    } else break;
                }
            }
            d = d == 0 ? 3 : d - 1;
            tmp++;
        }

        System.out.println(cnt);
    }
}
