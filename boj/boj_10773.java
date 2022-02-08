package boj;

import java.io.*;
import java.util.Stack;

public class boj_10773 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final Stack<Integer> stack = new Stack();
        final int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            int cur = Integer.parseInt(br.readLine());

            if (cur == 0) {
                stack.pop();
                continue;
            }

            stack.push(cur);
        }

        int result = 0;
        while (!stack.isEmpty()) result += stack.pop();

        System.out.println(result);
    }
}
