package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2908 {
    static String reverse(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int result = Math.max(
                Integer.parseInt(reverse(input[0])),
                Integer.parseInt(reverse(input[1]))
        );

        System.out.println(result);
    }
}
