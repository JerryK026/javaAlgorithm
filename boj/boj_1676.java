package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0의 숫자는 * 10의 수라는 것. 10의 공약수는 2, 5이기 때문에 곱한 수의 2와 5로 나뉘어지는 수를 세면 10이 몇번 곱해졌는지 알 수 있다.

        int num = Integer.parseInt(br.readLine());
//        int two = 0;
        int five = 0;
//        for(int i = 2; i < num + 1; i *= 2) {
//            for(int j = i; j < num + 1; j += i) two++;
//        }
        for(int i = 5; i < num + 1; i *= 5) {
            for(int j = i; j < num + 1; j += i) five++;
        }
//        int ten = (two < five) ? five : two;
        // 생각해보니 5가 무조건 적어서 two는 셀 필요도 없다. 즉, 5의 개수만 세도 된다.
        System.out.println(five);
        /*
        int two = 0;
        int five = 0;
        int num = Integer.parseInt(br.readLine());
        int cur;

        for(int i = num; i > 0; i--) {
            cur = i;
            while (cur % 2 == 0) {
                cur /= 2;
                two++;
            }
            while (cur % 5 == 0) {
                cur /= 5;
                five++;
            }
        }
         */
    }
}
