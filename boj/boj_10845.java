package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class boj_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder cur = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();
        Integer output;
        String s;

        for(int i = 0; i < n; i++) {
            cur.append(bf.readLine());
            s = cur.substring(0,3);
            if(s.equals("pus")) {
                queue.add(Integer.parseInt(cur.substring(5)));
            }
            else if(s.equals("pop")) {
                output = queue.poll();
                if(output == null) System.out.println(-1);
                else System.out.println(output);
                output = 0;
            }
            else if(s.equals("siz")) {
                System.out.println(queue.size());
            }
            else if(s.equals("emp")) {
                System.out.println(queue.isEmpty() ? 1: 0);
            }
            else if(s.equals("fro")) {
                output = queue.peek();
                if(output == null) System.out.println(-1);
                else System.out.println(output);
            }
            else if(s.equals("bac")) {
                if(queue.size() == 0) System.out.println(-1);
                else System.out.println(queue.get(queue.size() - 1));
            }
            cur.setLength(0);
        }
    }
}
