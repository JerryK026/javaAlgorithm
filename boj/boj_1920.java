package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            int cur = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);
            sb.append(BinarySearch(arr, cur) + "\n");
        }

        System.out.println(sb.toString());
    }

    static int BinarySearch(int[] arr, int cur) {
        int left = 0;
        int right = arr.length - 1;
        int middle = 0;

        while(left <= right) {
            middle = (left + right) / 2;
            if(cur == arr[middle]) return 1;
            if(cur < arr[middle]) right = middle - 1;
            else left = middle + 1;
        }

        return 0;
    }
}
