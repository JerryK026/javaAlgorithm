package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 1. 톱니바퀴가 왼쪽 혹은 오른쪽으로 회전할지 결정한다
 * 2-1. 좌측 톱니바퀴의 우측 이와 현재 톱니바퀴의 왼쪽 이를 비교해 다르면 반대 방향으로 회전한다
 * 2-2. 다르다면 멈춘다
 * 2-3. 2-2의 결과가 나올 때까지 비교한다
 * 3. 우측도 마찬가지로 전파해 나간다
 * 4. 모든 회전이 끝난 뒤 정상 이의 값을 활용해 계산한다
 */

interface Spanner<E> {
    void rotate(LinkedList<E> teeth);
}

enum Direction {
    CLOCKWISE(1, (teeth) -> teeth.addFirst(teeth.removeLast())),
    COUNTERCLOCKWISE(-1, (teeth -> teeth.addLast(teeth.removeFirst())));

    private int val;
    private Spanner spanner;

    Direction(int val, Spanner spanner) {
        this.val = val;
        this.spanner = spanner;
    }

    public Direction convert() {
        if (this.equals(CLOCKWISE)) return COUNTERCLOCKWISE;
        return CLOCKWISE;
    }

    public <E> void rotate(LinkedList<E> teeth) {
        spanner.rotate(teeth);
    }

    public static Direction from(int val) {
        return Arrays.stream(values())
                .filter(d -> d.val == val)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못 입력된 방향"));
    }
}

class Gear {
    private static final int TOP_TOOTH = 0;
    private static final int RIGHT_TOOTH = 2;
    private static final int LEFT_TOOTH = 6;

    private static final int S = 1;
    private static final int N = 0;

    private LinkedList<Integer> teeth;
    private Gear left;
    private Gear right;

    public Gear(String[] teeth) {
        this(Arrays.stream(teeth)
                .map(s -> Integer.parseInt(s))
                .collect(Collectors.toList()));
    }

    public Gear(List<Integer> teeth) {
        this.teeth = new LinkedList<>(teeth);
    }

    public void setLeft(Gear left) {
        this.left = left;
    }

    public void setRight(Gear right) {
        this.right = right;
    }

    public void rotate(Direction direction) {
        if (left != null) left.rotateLeft(direction.convert(), teeth.get(LEFT_TOOTH));
        if (right != null) right.rotateRight(direction.convert(), teeth.get(RIGHT_TOOTH));

        direction.rotate(teeth);
    }

    public void rotateLeft(Direction direction, int clientLeftVal) {
        if (teeth.get(RIGHT_TOOTH) == clientLeftVal) return;

        if (left != null) left.rotateLeft(direction.convert(), teeth.get(LEFT_TOOTH));
        direction.rotate(teeth);
    }

    public void rotateRight(Direction direction, int clientRightVal) {
        if (teeth.get(LEFT_TOOTH) == clientRightVal) return;

        if (right != null) right.rotateRight(direction.convert(), teeth.get(RIGHT_TOOTH));
        direction.rotate(teeth);
    }

    public int calculate() {
        if (teeth.get(TOP_TOOTH) == S) return 1;

        return 0;
    }
}

public class boj_14891 {
    private static final int GEAR_NUM = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Gear> gears = new ArrayList<>();
        for (int i = 0; i < GEAR_NUM; i++) {
            gears.add(new Gear(br.readLine().split("")));
        }

        placeGears(gears);

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int gearIdx = Integer.parseInt(input[0]) - 1;
            Direction direction = Direction.from(Integer.parseInt(input[1]));

            gears.get(gearIdx).rotate(direction);
        }

        int a = 1;
        int sum = 0;
        for (int i = 0; i < GEAR_NUM; i++) {
            sum += gears.get(i).calculate() * a;
            a *= 2;
        }

        System.out.println(sum);
    }

    private static void placeGears(List<Gear> gears) {
        gears.get(0).setRight(gears.get(1));

        int len = GEAR_NUM - 1;
        for (int i = 1; i < len; i++) {
            Gear cur = gears.get(i);
            cur.setLeft(gears.get(i - 1));
            cur.setRight(gears.get(i + 1));
        }

        gears.get(len).setLeft(gears.get(len - 1));
    }
}
