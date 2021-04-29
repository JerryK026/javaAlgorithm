package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] arr1 = new int[Integer.parseInt(st.nextToken())];
        int[] arr2 = new int[Integer.parseInt(st.nextToken())];
        int[] arr3 = new int[arr1.length + arr2.length];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < arr2.length; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        System.arraycopy(arr1, 0, arr3, 0, arr1.length);
        System.arraycopy(arr2, 0, arr3, arr1.length, arr2.length);
        Arrays.sort(arr3);
        for(int i = 0; i < arr3.length; i++) {
            sb.append(arr3[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
