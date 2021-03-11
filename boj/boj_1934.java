package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1934 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int iter = Integer.parseInt(bf.readLine());
        for(int i = 0; i < iter; i++) {
            String s[] = bf.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]);
            int n2 = Integer.parseInt(s[1]);
            int lcm = n2;

            if (n2 < n1) {
                lcm = n1;
                n1 = n2;
                n2 = lcm;
            }

            while (lcm % n1 != 0) lcm += n2;
            System.out.println(lcm);
        }
    }
}
