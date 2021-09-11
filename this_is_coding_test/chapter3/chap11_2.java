package this_is_coding_test.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chap11_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int len = s.length();
        int result = s.charAt(0) - '0';

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                continue;
            }
            if (result == 0) {
                result += Character.getNumericValue(s.charAt(i));
                continue;
            }
            result *= Character.getNumericValue(s.charAt(i));
        }

        System.out.println(result);
    }
}
