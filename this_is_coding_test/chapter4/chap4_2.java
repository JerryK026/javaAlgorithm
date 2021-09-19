package this_is_coding_test.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chap4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if (String.valueOf(i).contains("3") || String.valueOf(j).contains("3") || String.valueOf(k).contains("3")) {
                        count++;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
