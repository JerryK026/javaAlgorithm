package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_14891_3 {

    static int[][] gears;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new int[4][8];

        int gearLen = gears.length;
        for (int i = 0; i < gearLen; i++) {
            gears[i] = Arrays.stream(br.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int idx = Integer.parseInt(input[0]) - 1;
            int direction = Integer.parseInt(input[1]);

            rotate(idx, direction);
        }

        int sum = 0;
        for (int i = 0, a = 1; i < 4; i++, a *=2) {
            sum += gears[i][0] * a;
        }

        System.out.println(sum);
    }

    private static void rotate(int idx, int direction) {
        int dirTmp = direction;
        for (int i = idx; i > 0; i--) {
            if (gears[i][6] == gears[i - 1][2]) break;

            dirTmp *= -1;
            rotateGear(i - 1, dirTmp);
        }

        dirTmp = direction;
        for (int i = idx; i < 3; i++) {
            if (gears[i][2] == gears[i + 1][6]) break;

            dirTmp *= -1;
            rotateGear(i + 1, dirTmp);
        }

        rotateGear(idx, direction);
    }

    private static void rotateGear(int idx, int direction) {
        int[] gear = gears[idx];
        int[] tmp = new int[8];

        // 시계방향
        if (direction == 1) {
            System.arraycopy(gear, 0, tmp, 1, gear.length - 1);
            tmp[0] = gear[7];
            gears[idx] = tmp;
            return;
        }

        System.arraycopy(gear, 1, tmp, 0, gear.length - 1);
        tmp[7] = gear[0];
        gears[idx] = tmp;
    }
}
