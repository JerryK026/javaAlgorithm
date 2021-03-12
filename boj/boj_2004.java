package boj;

import java.io.*;

public class boj_2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        int two = 0;
        int five = 0;

        int start_2 = n-m;
        int start_5 = n-m;
        while (start_2 % 2 != 0) start_2++;
        while (start_5 % 5 != 0) start_5++;

        for(int i = 2; i < n + 1; i *= 2) {
            for(int j = start_2; j < n + 1; j += i) two++;
        }
        for(int i = 5; i < n + 1; i *= 5) {
            for(int j = start_5; j < n + 1; j += i) five++;
        }
        for(int i = 2; i < m + 1; i *= 2) {
            for(int j = i; j < m + 1; j += i) two--;
        }
        for(int i = 5; i < m + 1; i *= 5) {
            for(int j = i; j < m + 1; j += i) five--;
        }

        int ten = (two < five) ? five : two;
        bw.write(String.valueOf(ten));
        bw.flush();
        bw.close();
    }
}
