package boj;

import java.io.*;
import java.util.StringTokenizer;

public class boj_1476 {
    public static boolean equal(int e, int s, int m) {
        if(e != 1) return false;
        else if(s != 1) return false;
        else if(m != 1) return false;
        else return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 1;

        while(!equal(E, S, M)) {
            if(E == 1) E = 15;
            else E--;
            if(S == 1) S = 28;
            else S--;
            if(M == 1) M = 19;
            else M--;
            count++;
        }
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
