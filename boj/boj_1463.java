package boj;

import java.io.*;

public class boj_1463 {
    static int N;
    static int count = 0;

    // 나눗셈은 몫, 나머지, 3보다 작은 수 때문에 복잡 -> 1에서부터 곱하는 식으로 가면 나눗셈이랑 같다는 데서 착안
    // 어차피 count의 수만 세면 됨
    // 33 같은 경우 33 -> 11 -> 10 -> 9 -> 3 -> 1 이렇게 되므로 해당 방법대론 안됨

    // 이 방법도 안됨 1000 -> 999 -> ... 이렇게 하면 8가 나오는데
    // 1091 -> 1009 -> 509 -> ... 이렇게 되므로 13이 됨.
    // 어떤 기준으로 3을 나누고 2를 나눠야 할지 모르겠음 ㅇㅅㅇ

    public static void d3() {
        N = N / 3;
        count++;
    }
    public static void d2() {
        N = N / 2;
        count++;
    }
    public static void sub() {
        N -= 1;
        count++;
    }
    public static void dec() {
        if ((N - 1) % 3 == 0) {
            sub();
            d3();
        }
        else {
            if (N % 2 != 0) {
                sub();
            }
            d2();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

         while (N > 3) {
             if (N % 3 == 0) {
                 d3();
             }
             else dec();
        }
         if (N > 1) count++;

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
    }
}
