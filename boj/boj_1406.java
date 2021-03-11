package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1406 {
    static StringBuilder P(StringBuilder input, String add, int pointer) {
        StringBuilder output = new StringBuilder(input.insert(pointer, add));
        return output;
    }
    static StringBuilder B(StringBuilder input, int pointer) {
        StringBuilder output = new StringBuilder(input.delete(pointer - 1, pointer));
        return output;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(bf.readLine());
        int num = Integer.parseInt(bf.readLine());

        StringBuilder input = new StringBuilder(), cur = new StringBuilder();
        int pointer = s.length();
        StringBuilder tmp;

        for(int i = 0; i < num; i++) {
            input.append(bf.readLine());
            cur.append(input.substring(0,1));
            String c = cur.toString();
            if(c.equals("L")) {
                if(pointer != 0)
                    pointer--;
            }
            else if(c.equals("D")) {
                if(pointer != s.length()) {
                    pointer++;
                }
            }
            else if(c.equals("B")) {
                if(pointer != 0) {
                    s.replace(0,s.length() + 1, B(s, pointer).toString());
                    pointer--;
                }
            }
            else if(c.equals("P")) {
                s.replace(0,s.length() + 1, P(s, input.toString().split(" ")[1], pointer).toString());
                pointer++;
            }
            input.setLength(0);
            cur.setLength(0);
        }
        System.out.println(s);
    }
}
