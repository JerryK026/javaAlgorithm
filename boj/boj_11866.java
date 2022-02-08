package boj;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class boj_11866 {
    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final Queue<Integer> queue = new LinkedList<>();
        final String[] input = br.readLine().split(" ");

        final int N = Integer.parseInt(input[0]);
        final int K = Integer.parseInt(input[1]);

        for (int i = 1; i <= N; i++) queue.add(i);

        final StringBuilder sb = new StringBuilder();
        sb.append("<");
        while (!queue.isEmpty()) {
            for (int i = 0; i < K - 1; i++) queue.add(queue.poll());
            sb.append(queue.poll()).append(", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
