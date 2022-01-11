package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Stack;

public class boj_1918 {
    static Stack<String> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    static int trans(String cur) {
        if (cur.equals("*") || cur.equals("/")) return 1;
        if (cur.equals("+") || cur.equals("-")) return 2;
        if (cur.equals("(")) return 3;
        return -1;
    }

    static void det(String cur) {
        if (cur.equals("(")) {
            openBracket();
            return;
        }
        if (cur.equals(")")) {
            closeBracket(cur);
            return;
        }
        rank(cur);
    }

    static void openBracket() {
        stack.push("(");
    }

    static void closeBracket(String cur) {
        String top = "";
        while (!(top = stack.pop()).equals("(")) sb.append(top);
    }

    static void rank(String cur) {
        if (stack.isEmpty()) {
            stack.push(cur);
            return;
        }

        if (trans(stack.peek()) > trans(cur)) {
            stack.push(cur);
            return;
        }

        while (!stack.isEmpty() && trans(stack.peek()) <= trans(cur)) {
            sb.append(stack.pop());
        }
        stack.push(cur);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> opers = List.of(new String[]{"+", "-", "*", "/", ")", "("});
        String[] input = br.readLine().split("");

        for (int i = 0; i < input.length; i++) {
            if (!opers.contains(input[i])) {
                sb.append(input[i]);
                continue;
            }

            det(input[i]);
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb.toString());
    }
}
