package this_is_coding_test.chapter6;

public class chap6_1 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for (int i = 0; i < n; i++) {
            int idx = i;
            for (int j = i; j < n; j++) {
                if (arr[idx] < arr[j]) idx = j;
            }
            int tmp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = tmp;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}