package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj_10855 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new ArrayDeque<>();
        int num = Integer.parseInt(bf.readLine());
        StringBuilder cur = new StringBuilder();
        String s;
        Integer output;

        for(int i = 0; i < num; i++) {
            cur.append(bf.readLine());
            s = cur.toString();
            if(s.equals("size")) {
                System.out.println(dq.size());
            }
            else if(s.equals("empty")) {
                System.out.println(dq.isEmpty()? 1 : 0);
            }
            else if(s.equals("front")) {
                output = dq.peekFirst();
                if(output == null) System.out.println(-1);
                else System.out.println(output);
            }
            else if(s.equals("back")) {
                output = dq.peekLast();
                if(output == null) System.out.println(-1);
                else System.out.println(output);
            }
            else if(s.split(" ")[0].equals("push_front")) {
                dq.addFirst(Integer.parseInt(s.split(" ")[1]));
            }
            else if(s.split(" ")[0].equals("push_back")) {
                dq.addLast(Integer.parseInt(s.split(" ")[1]));
            }
            else if(s.split(" ")[0].equals("pop_front")) {
                output = dq.pollFirst();
                if(output == null) System.out.println(-1);
                else System.out.println(output);
            }
            else if(s.split(" ")[0].equals("pop_back")) {
                output = dq.pollLast();
                if(output == null) System.out.println(-1);
                else System.out.println(output);
            }
            cur.setLength(0);
        }
    }
}
