package this_is_coding_test.chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chapter12_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int half_len = input.length()/2;
        String left = input.substring(0, half_len);
        String right = input.substring(half_len);

        int len_sum = 0;
        int right_sum = 0;
        for(int i = 0; i < half_len; i++) {
            len_sum += left.charAt(i);
            right_sum += right.charAt(i);
        }

        String result = "READY";
        if (len_sum == right_sum) result = "LUCKY";
        System.out.println(result);
    }
}
