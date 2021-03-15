package boj;

import java.io.*;

public class boj_1463 {
    static int N;
    static int count = 0;

    public static void d3() {
        N = N / 3;
        count++;
    }
    public static void d2() {
        N = N / 2;
        count++;
    }
    public static void sub() {
        N -= 1;
        count++;
    }
    public static void dec() {
        if ((N - 1) % 3 == 0) {
            sub();
            d3();
        }
        else {
            if (N % 2 != 0) {
                sub();
            }
            d2();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

         while (N > 3) {
             if (N % 3 == 0) {
                 d3();
             }
             else dec();
        }
         if (N > 1) count++;

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
