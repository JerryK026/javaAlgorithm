package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class boj_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] s = bf.readLine().split(" ");
        int n1 = Integer.parseInt(s[0]);
        int n2 = Integer.parseInt(s[1]);
        Vector<Integer> v1 = new Vector<>();
        Vector<Integer> v2 = new Vector<>();
        int tmp, gcd = 0;

        if(n2 < n1) {
            tmp = n2;
            n2 = n1;
            n1 = tmp;
        }

        for(int i = 1; i < n1 + 1; i++) {
            if(n1 % i == 0) v1.add(i);
            if(n2 % i == 0) v2.add(i);
        }

        for(int i = n1; i < n2 + 1; i++) {
            if(n2 % i == 0) v2.add(i);
        }
        boolean exit = false;

        for(int i = v1.size() - 1; i > -1; i--) {
            tmp = v1.get(i);
            for(int j = v2.size() - 1; j > -1; j--) {
                if(tmp == v2.get(j)) {
                    exit = true;
                    gcd = v2.get(j);
                    break;
                }
                if(tmp > v2.get(j)) break;
            }
            if(exit) break;
        }

        System.out.println(gcd + "\n" +n1 * n2 /gcd);

    }
}
