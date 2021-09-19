package this_is_coding_test.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chap4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        int len = arr.length;

        int x = 1, y = 1;
        for (int i = 0; i < len; i++) {
            switch (arr[i]) {
                case "L":
                    if (y > 1) y--;
                    break;
                case "R":
                    if (y < N) y++;
                    break;
                case "U":
                    if (x > 1) x--;
                    break;
                case "D":
                    if (x < N) x++;
                    break;
            }
        }

        System.out.printf("%d %d", x, y);
    }
}
