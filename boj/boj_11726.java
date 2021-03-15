package boj;

import java.io.*;

public class boj_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cur = 0;
        int count = 0;
        int tmp;

        if(n % 2 == 0) count++;

        while(n > 0) {
            tmp = 1;
            // 가로와 세로로 나눌 수 있으므로, 같은 것이 있는 순열로 해결할 수 있다. (가로 + 세로)! / (가로! * 세로!)
            for(int i = n + 1; i <= n + cur; i++) {
                tmp *= i;
                for(int j = 2; j <= cur; j++) {
                    tmp /= j;
                }
                tmp %= 10007;
            }
            count += tmp;
            n -= 2;
            cur += 1;
        }

        bw.write(String.valueOf(count % 10007));
        bw.flush();
        bw.close();
    }
}
