package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class boj_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        StringBuilder ord = new StringBuilder();
        int input = 0;

        ArrayList<Integer> stack = new ArrayList<Integer>();
        int ssize = 0;

        for(int i = 0; i < num; i++) {
            ord.append(bf.readLine());
            if(ord.toString().contains("push")) {
                input = Integer.parseInt(ord.toString().split(" ")[1]);
                stack.add(input);
                ssize++;
            }
            else if(ord.toString().equals("pop")) {
                if (ssize == 0)
                    System.out.println(-1);
                else {
                    System.out.println(stack.remove(ssize - 1));
                    ssize--;
                }
            }
            else if(ord.toString().equals("size")) {
                System.out.println(ssize);
            }
            else if(ord.toString().equals("empty")) {
                if(ssize == 0)
                    System.out.println(1);
                else
                    System.out.println(0);
            }
            else if(ord.toString().equals("top")) {
                if (ssize == 0)
                    System.out.println(-1);
                else
                    System.out.println(stack.get(ssize - 1));
            }
            ord.setLength(0);
        }
    }
}
