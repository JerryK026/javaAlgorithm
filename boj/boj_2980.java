package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_2980 {

    static class Traffic {
        int D;
        int R;
        int G;

        public Traffic(int D, int R, int G) {
            this.D = D;
            this.R = R;
            this.G = G;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int N = Integer.parseInt(st.nextToken());
        final int L = Integer.parseInt(st.nextToken());

        Traffic[] arr = new Traffic[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Traffic(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int len = arr.length;
        int D = 0, R = 0, G = 0;

        for (int i = 0; i < len; i++) {
            time += arr[i].D - D;

            D = arr[i].D;
            R = arr[i].R;
            G = arr[i].G;

            int tmp = time % (R + G);
            if (tmp < R) time += R - tmp;
        }

        time += L - D;
        System.out.println(time);
    }
}
