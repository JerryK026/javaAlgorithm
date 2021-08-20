package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_3048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Character> qA = new Stack<>();
        Queue<Character> qB = new LinkedList<>();

        final int N1 = Integer.parseInt(st.nextToken());
        final int N2 = Integer.parseInt(st.nextToken());

        String cur = br.readLine();
        for (int i = 0; i < N1; i++) {
            qA.push(cur.charAt(i));
        }

        cur = br.readLine();
        for (int i = 0; i < N2; i++) {
            qB.offer(cur.charAt(i));
        }

        int time = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        if (N1 - time > 0) {
            for (int i = 0; i < N1 - time; i++) {
                sb.append(qA.pop());
            }
        }
        else {
            for (int i = 0; i < time - N1; i++) {
                if(!qB.isEmpty()) sb.append(qB.poll());
            }
            time = N1;
        }

        for (int i = 0; i < time; i++) {
            if(!qB.isEmpty()) sb.append(qB.poll());
            if(!qA.isEmpty()) sb.append(qA.pop());
        }

        while (!qB.isEmpty()) {
            sb.append(qB.poll());
        }

        while (!qA.isEmpty()) {
            sb.append(qA.pop());
        }

        System.out.println(sb);
    }
}
