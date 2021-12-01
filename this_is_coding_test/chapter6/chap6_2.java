package this_is_coding_test.chapter6;

public class chap6_2 {
    public static void main(String[] args) {

        int[] arr = {3, 5};
        int tmp = arr[0];
        arr[0] = arr[1];
        arr[1] = tmp;

        System.out.println(arr[0] + " " + arr[1]);
    }
}
