package boj;

import java.util.Scanner;

public class boj_9012 {
    final static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int num = sc.nextInt();
        sc.nextLine();
        int size;

        for (int i = 0; i < num; i++) {
            String flag = "YES";
            StringBuffer input = new StringBuffer();
            input.append(sc.nextLine());
            size = input.length();
            if(size % 2 == 1) {
                flag = "NO";
                System.out.println(flag);
                continue;
            }
            for(int j = 0; j < size; j++) {
                if(input.charAt(size - 1) != ')') {
                    flag = "NO";
                    break;
                }
                else if(input.charAt(0) != '(') {
                    flag = "NO";
                    break;
                }
                if (input.charAt(j) == ')') {
                    if (input.charAt(j - 1) == '(') {
                        input.deleteCharAt(j);
                        input.deleteCharAt(j - 1);
                        j = 0;
                        size -= 2;
                    } else {
                        flag = "NO";
                        break;
                    }
                }
            }
            System.out.println(flag);
        }
    }
}
