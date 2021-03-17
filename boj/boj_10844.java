package boj;

import java.io.*;
import java.util.LinkedList;

/*
        처음에 쓴 방법 : 1에선 0으로 갈 수 있고, 2에선 0, 1로 갈 수 있고, ... 9에선 8로 갈 수 있고 이런 식으로 함수를 호출하게 해서 count하려고 했었다.
        -> 시간 초과. 마지막에 10억으로 나누는데 이건 최소 10억 이상의 count가 존재한다는 뜻이다. count를 더해가며 세면 10억회가 넘어가므로 최소 10초 이상이라는
        소리이기 때문에 방법을 바꿔야 한다.
*/
/*
        9 17 32 61 116
        0으로 갔을 때나 9로 갔을 때는 뻗는 가지 수가 1개 나머지는 2개.
        만약 0, 9도 2개를 뻗는다고 가정하고 세본다면,
        1 -> 2^0 * 10
        2 -> 2^1 * 10
        3 -> 2^2 * 10
        ... 이런 꼴일 것. 즉, 여기서 0이나 9로 뻗는 가지수를 세서 빼면 된다.
*/
/*
이 때, 0의 경우에는 0으로 시작하는 경우의 수 전부도 빼주어야 한다. 따라서,
2*9 + 2*9
*/
public class boj_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
    }
}
