package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1978 {
    static boolean[] eratos(int num) {
        boolean[] e = new boolean[num + 1];
        e[0] = true;
        e[1] = true;
        int j;

        for(int i = 2; i < num + 1; i ++) {
            j = i + i;
            while (j < num + 1) {
                e[j] = true;
                j += i;
            }
        }

        return e;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        String[] nums = bf.readLine().split(" ");

        boolean[] e = eratos(1000);
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            if(!e[Integer.parseInt(nums[i])]) count++;
        }

        System.out.println(count);

    }
}
