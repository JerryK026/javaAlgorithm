package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int status = 0;
        for(int i = 0; i < N; i++) {
            boolean check = false;
            if (status > i) {
                arr[i] = arr[status];
            } else {
                for (int j = status + 1; j < N; j++) {
                    if (arr[j] > arr[status]) {
                        arr[i] = arr[j];
                        status = j;
                        check = true;
                        break;
                    }
                }
                if(!check) {
                    arr[i] = -1;
                    status = i + 1;
                    check = false;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
