package this_is_coding_test.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class chap3_3 {
    // 가장 작은 수를 추출할 때 전부 정렬해서 0번째 값을 찾았다. => 최악의 경우 O(N^2)일 수도 있다.
    // 그냥 선형탐색을 하면 O(N)이니 그 방법이 더 좋다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = arr[i][0];
        }

        Arrays.sort(result);

        System.out.println(result[N - 1]);
    }
}
