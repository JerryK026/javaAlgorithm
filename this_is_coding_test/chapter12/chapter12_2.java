package this_is_coding_test.chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class chapter12_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        List<Character> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        int len = input.length();
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if(Character.isDigit(input.charAt(i))) sum += input.charAt(i) - '0';
            else list.add(input.charAt(i));
        }

        Collections.sort(list);

        for (Character cur : list) {
            sb.append(cur);
        }
        if(sum != 0) sb.append(sum);

        System.out.println(sb.toString());
    }
}
