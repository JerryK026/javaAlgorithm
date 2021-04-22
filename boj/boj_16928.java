package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[100];
        int[] cache = new int[100];
        boolean[] flag = new boolean[100];

        for(int i = 0; i < 100; i++) {
            arr[i] = i;
            cache[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken()) - 1;
        }

        cache[0] = 0;
        for(int i = 1; i < 7; i++) {
            cache[i] = 1;
            go(arr, cache, i, flag);
        }

        for(int i = 7; i < 100; i++) {
            int tmp = cache[i];
            for(int j = 6; j >= 0; j--) {
                tmp = tmp < cache[i - j] ? tmp : cache[i - j];
            }
            if(tmp != cache[i]) cache[i] = tmp + 1;
            if(!go(arr, cache, i, flag)) {
                i = arr[i];
            }
        }
        System.out.println(cache[99]);
    }

    public static boolean go(int[] arr, int[] cache, int idx, boolean[] flag) {
        boolean check = true;
        if(arr[idx] != idx) {
            if(cache[arr[idx]] >= cache[idx]) {
                cache[arr[idx]] = cache[idx];
                if(arr[idx] < idx && !flag[arr[idx]]) {
                    check = false;
                    flag[arr[idx]] = true;
                }
            }
            go(arr, cache, arr[idx], flag);
            }
        if(check) {
            // 뱀 안 탔으면 true 반환
            return true;
        }
        else {
            // 뱀 탔으면 false 반환
            return false;
        }
    }
}
