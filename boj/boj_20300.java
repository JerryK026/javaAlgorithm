package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_20300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        ArrayList<Long> machines = new ArrayList<>();
        long result = 0;

        for (int i = 0; i < N; i++) machines.add(Long.parseLong(tmp[i]));

        Collections.sort(machines);

        if (N % 2 == 1) result = machines.remove(N - 1);

        for (int i = 0; i < N / 2; i++) {
            result = Math.max(result, machines.get(i) + machines.get(machines.size() -i -1));
        }

        System.out.println(result);
    }
}
