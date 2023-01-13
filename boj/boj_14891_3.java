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
        int cache = gears[idx][6];
        for (int i = idx; i > 0; i--) {
            if (cache == gears[i - 1][2]) break;

            dirTmp *= -1;
            // 회전하기 전 정보를 기억
            cache = gears[i - 1][6];
            rotateGear(i - 1, dirTmp);
        }

        dirTmp = direction;
        cache = gears[idx][2];
        for (int i = idx; i < 3; i++) {
            if (cache == gears[i + 1][6]) break;

            dirTmp *= -1;
            cache = gears[i + 1][2];
            rotateGear(i + 1, dirTmp);
        }

        rotateGear(idx, direction);
    }

    private static void rotateGear(int idx, int direction) {
        int[] tmp = new int[8];

        // 시계방향
        if (direction == 1) {
            System.arraycopy(gears[idx], 0, tmp, 1, gears[idx].length - 1);
            tmp[0] = gears[idx][7];
            gears[idx] = tmp;
            return;
        }

        System.arraycopy(gears[idx], 1, tmp, 0, gears[idx].length - 1);
        tmp[7] = gears[idx][0];
        gears[idx] = tmp;
    }
}
