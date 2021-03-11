package boj;

import java.io.*;

public class boj_10872 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int result = 1;

        for(int i = num; i > 0; i--) result *= i;
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
    }
}
