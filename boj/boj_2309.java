package boj;

import java.io.*;
import java.util.Arrays;

public class boj_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] hegiht = new int[9];
        int sum = 0;
        int d;
        boolean b = true;

        for (int i = 0; i < 9; i++) {
            hegiht[i] = Integer.parseInt(br.readLine());
            sum += hegiht[i];
        }

        d = sum - 100;

        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(hegiht[i] + hegiht[j] == d) {
                    hegiht[i] = 0;
                    hegiht[j] = 0;
                    b = false;
                    break;
                }
            }
            if(!b) break;
        }

        Arrays.sort(hegiht);

        for(int i = 2; i < 9; i++) {
            bw.write(String.valueOf(hegiht[i]));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
