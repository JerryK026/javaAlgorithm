package this_is_coding_test.chapter3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class chap11_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] fear = new int[N];
        int group = 0;

        for (int i = 0; i < N; i++) {
            fear[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(fear);

        int count = 0;
        for (int i = 0; i < N; i++) {
            count++;
            if (count >= fear[i]) {
                group++;
                count = 0;
            }
        }

        System.out.println(group);
    }
}
