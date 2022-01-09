package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Building {
    int height;
    int cnt;
    Building(int height, int cnt) {
        this.height = height;
        this.cnt = cnt;
    }
}

public class boj_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Building> stack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        String[] towers = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(towers[i]);
            while (!stack.empty() && stack.peek().height < cur) stack.pop();

            if (stack.empty()) {
                sb.append("0 ");
                stack.push(new Building(cur, i + 1));
                continue;
            }

            sb.append(stack.peek().cnt).append(" ");
            stack.push(new Building(cur, i + 1));
        }

        System.out.println(sb.toString());
    }
}
