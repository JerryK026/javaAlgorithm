package boj;

import java.util.Scanner;

public class boj_9093 {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int num = sc.nextInt();
        sc.nextLine();
        String output;
        for(int i = 0; i < num; i++) {
            output = "";
            String input = sc.nextLine();
            String[] tokens = input.split(" ");
            for (int j = 0; j < tokens.length; j++) {
                for(int k = tokens[j].length() - 1; k > -1; k--) {
                    output += tokens[j].charAt(k);
                }
                output += " ";
            }
            System.out.println(output);
        }
    }
}
