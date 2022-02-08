package boj;

import java.io.*;
import java.util.Stack;

public class boj_4949 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        final StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals(".")) {
            final Stack<Character> stack = new Stack<>();
            boolean flag = true;

            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);
                if (cur == '(' || cur == '[') stack.push(cur);

                if (cur == ')') {
                    if (stack.isEmpty() || stack.peek() == '[') {
                        flag = false;
                        continue;
                    }
                    stack.pop();
                }

                if (cur == ']') {
                    if (stack.isEmpty() || stack.peek() == '(') {
                        flag = false;
                        continue;
                    }
                    stack.pop();
                }
            }

            if (stack.isEmpty() && flag) sb.append("yes\n");
            else sb.append("no\n");
        }

        System.out.println(sb.toString());
    }
}
