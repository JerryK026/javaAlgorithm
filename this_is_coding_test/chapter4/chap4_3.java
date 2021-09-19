package this_is_coding_test.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chap4_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        final int col = input.charAt(0) - 'a' + 1;
        final int row = input.charAt(1) - '0';

        int[] dx = {-2, -2, -1, 1, 2, 2, -1, 1};
        int[] dy = {-1, 1, 2, 2, -1, 1, -2, -2};
        int len = dx.length;
        int count = 0;

        for (int i = 0; i < len; i++) {
            int x = row + dx[i];
            int y = col + dy[i];
            if (0 < x && x < 9 && 0 < y && y < 9) count++;
        }

        System.out.println(count);
    }
}
