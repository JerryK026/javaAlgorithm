package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class boj_1874 {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int num = sc.nextInt();
        int current;
        int cur_num = 1;
        String output = "";
        ArrayList<Integer> stack = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            current = sc.nextInt();
            if(!stack.isEmpty()) {
                if (cur_num == num + 1 && stack.get(stack.size() - 1) > current) {
                    output = "NO";
                    break;
                }
            }
            while(cur_num < num + 2) {
                if(!stack.isEmpty()) {
                    if (stack.get(stack.size() - 1) == current) {
                        if(cur_num == num + 1 && i == num - 1)
                            break;
                        stack.remove(stack.size() - 1);
                        output += "-\n";
                        break;
                    }
                }
                stack.add(cur_num);
                output += "+\n";
                cur_num++;
            }
        }
        System.out.println(output.trim());
    }
}
