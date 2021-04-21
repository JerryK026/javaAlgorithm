package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_15649 {
    static ArrayList<String> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] nArr = new int[N];
        boolean[] check = new boolean[N];

        for(int i = 0; i < N; i++) {
            nArr[i] = i + 1;
        }

        makeNum(nArr, M, check, new StringBuilder());

        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    static void makeNum(int[] nArr, int M, boolean[] check, StringBuilder sb) {
        for(int i = 0; i < nArr.length; i++) {
            if(!check[i]) {
                sb.append(nArr[i] + " ");
                check[i] = true;
                if (sb.length() == 2 * M) {
                    result.add(sb.toString());
                    sb.delete(sb.length() - 2, sb.length());
                    check[i] = false;
                } else {
                    makeNum(nArr, M, check, new StringBuilder(sb));
                    sb.delete(sb.length() - 2, sb.length());
                    check[i] = false;
                }
            }
        }
    }
}
