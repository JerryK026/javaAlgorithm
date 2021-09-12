package this_is_coding_test.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chap11_3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char cache = '\0';
        int len = s.length();
        int zcount = 0;
        int ocount = 0;

        for (int i = 0; i < len; i++) {
            if (cache != s.charAt(i)) {
                if (s.charAt(i) == '0') zcount++;
                else ocount++;
                cache = s.charAt(i);
            }
        }

        System.out.println(Math.min(zcount, ocount));
    }
}
