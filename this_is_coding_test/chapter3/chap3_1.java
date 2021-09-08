package this_is_coding_test.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chap3_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = {500, 100, 50, 10};

        for (int i = 0; i < 4; i++) {
            count += N / arr[i];
            N %= arr[i];
        }

        System.out.println(count);
    }
}
