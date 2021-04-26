package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_10815 {
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nArr = new int[N];
        for(int i = 0; i < N; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] mArr = new int[M];
        for(int i = 0; i < M; i++) {
            mArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);

        for(int i = 0; i < M; i++) {
            sb.append(bs(nArr, mArr[i], cnt) + " ");
        }
        System.out.println(sb.toString().trim());
    }

    static int bs(int[] nArr, int cur, int cnt) {
        int left = cnt;
        int right = nArr.length;
        int middle = 0;
        while (left <= right) {
            middle = (left + right) / 2;
            if(middle < 0 || nArr.length <= middle)
                return 0;
            if(cur == nArr[middle]) {
                cnt++;
                return 1;
            }
            else if(cur < nArr[middle]) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }

        return 0;
    }
}
