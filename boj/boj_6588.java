package boj;

import java.io.*;
import java.util.ArrayList;

public class boj_6588 {
    static ArrayList<Integer> eratos(int num) {
        boolean[] e = new boolean[num + 1];
        ArrayList<Integer> r = new ArrayList<>();
        int sqrtn = (int) Math.sqrt((double) num + 1);

        for(int i = 2; i < sqrtn; i++) {
            if(e[i] == true) continue;
            r.add(i);

            for(int j = i + i; j < num + 1; j += i) {
                e[j] = true;
            }
        }
        r.remove(0);                // 짝수이므로 index 0인 2는 제거.

        return r;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String w = "Goldbach's conjecture is wrong.";

        ArrayList<Integer> p = eratos( 1000000);

        int cur = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int size = p.size();
        int num1, num2;
        int an1, an2;
        boolean exit;

        while (cur != 0) {
            an1 = 0;
            an2 = 0;

            for(int i = 0; i < size; i++) {
                exit = true;
                num1 = p.get(i);
                // 이렇게 일일이 연산하는 방법 말고 또 다른 방법이 없을까?
                // binary search로 목표 지점을 찾고 거기서 -- 하는 방법을 생각해 봤으나, 이 경우 오히려 연산이 더 많아질 수도 있음.
                for(int j = i; j < size; j++) {
                    num2 = p.get(j);
                    if(cur == num1 + num2) {
                        exit = false;
                        an1 = num1;
                        an2 = num2;
                        break;
                    }
                    else if(cur < num1 + num2) break;
                }
                if(exit == false) break;
            }

            if(an1 == 0) sb.append(w);
            else sb.append(String.format("%d = %d + %d\n", cur, an1, an2));
            cur = Integer.parseInt(bf.readLine());
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
