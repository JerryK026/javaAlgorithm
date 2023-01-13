package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class boj_14891_4 {

    static int[][] gears;
    static Queue<Order> q;
    static boolean[][] visited;


    private abstract static class Order {
        int dir;
        int idx;
        int before;

        public Order(int dir, int idx, int before) {
            this.dir = dir;
            this.idx = idx;
            this.before = before;
        }

        public abstract void rotate();
    }

    private static class LeftOrder extends Order {

        public LeftOrder(int dir, int idx, int before) {
            super(dir, idx, before);
        }

        @Override
        public void rotate() {
            if (idx > 0 && before != gears[idx - 1][2]) {
                q.add(new LeftOrder(dir * -1 , idx - 1, gears[idx - 1][6]));
            }

            rotateGear(idx, dir);
        }
    }

    private static class RightOrder extends Order {

        public RightOrder(int dir, int idx, int before) {
            super(dir, idx, before);
        }

        @Override
        public void rotate() {
            if (idx < 3 && before != gears[idx + 1][6]) {
                q.add(new RightOrder(dir * - 1, idx + 1, gears[idx + 1][2]));
            }

            rotateGear(idx, dir);
        }
    }


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
        visited = new boolean[K][4];

        q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int idx = Integer.parseInt(input[0]) - 1;
            int direction = Integer.parseInt(input[1]);

            if (idx > 0 && gears[idx][6] != gears[idx - 1][2]) {
                q.add(new LeftOrder(direction * -1, idx - 1, gears[idx - 1][6]));
            }

            if (idx < 3 && gears[idx][2] != gears[idx + 1][6]) {
                q.add(new RightOrder(direction * -1, idx + 1, gears[idx  + 1][2]));
            }

            while (!q.isEmpty()) {
                q.poll().rotate();
            }

            rotateGear(idx, direction);
        }

        int sum = 0;
        for (int i = 0, a = 1; i < 4; i++, a *=2) {
            sum += gears[i][0] * a;
        }

        System.out.println(sum);
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
