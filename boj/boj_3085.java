package boj;

import java.io.*;
import java.util.Arrays;

public class boj_3085 {

    // C -> 0, P -> 1, Z -> 2, Y -> 3
    public static int decision(String s) {
        if(s.equals("C")) return 0;
        else if(s.equals("P")) return 1;
        else if(s.equals("Z")) return 2;
        else return 3;
    }

    public static int[][] swap1(int[][] s, int i, int j) {
        int[][] o = Arrays.copyOf(s, s.length);
        o[i][j] = s[i][j + 1];
        o[i][j + 1] = s[i][j];
        return o;
    }

    public static int[][] swap2(int[][] s, int i, int j) {
        int[][] o = Arrays.copyOf(s, s.length);
        o[i][j] = s[i + 1][j];
        o[i + 1][j] = s[i][j];
        return o;
    }

    public static int search(int[][] s) {
        int size = s.length;
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int result = 0;

        for(int i = 0; i < size - 1; i++) {
            for(int j = 0; j < size - 1; j++) {
               for(int k = j; k < size && s[i][j] == s[i][k]; k++) count2++;
               for(int k = i; k < size && s[i][j] == s[k][j]; k++) count3++;
               count1 = (count2 < count3)? count3: count2;
               if(result < count1) result = count1;
               count2 = 0;
               count3 = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] bom = new int[N][N];
        String[] sl;
        int tmp = 0;
        int c = 0;
        int[][] s_bom;

        for(int i = 0; i < N; i++) {
            sl = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                bom[i][j] = decision(sl[j]);
            }
        }

        for(int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1; j++) {
                s_bom = swap1(bom, i, j);
                tmp = search(s_bom);
                if (c < tmp) c = tmp;
                s_bom = swap2(bom, i, j);
                tmp = search(s_bom);
                if (c < tmp) c = tmp;
            }
        }

        bw.write(String.valueOf(c));
        bw.flush();
        bw.close();
    }
}
