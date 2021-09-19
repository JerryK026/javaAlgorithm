package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class playground {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[5];
        String key;
        int[] keyArr;
        int keyLen;

        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }

        key = br.readLine();
        keyLen = key.length();
        keyArr = new int[keyLen];
        for (int i = 0; i < keyLen; i++) {
            keyArr[i] = key.charAt(i) - 'A';
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int len = arr[i].length();
            int pointer = 0;
            for (int j = 0; j < len; j++) {
                char cur = (char) (arr[i].charAt(j) + keyArr[pointer++]);
                if (pointer == keyLen) pointer = 0;

                int flag = 0;
                if ('A' > cur) flag = 1;
                else if ('Z' < cur) flag = -1;
                cur += (26 * flag);
                sb.append(cur);
            }
            sb.append("\n");
        }
        String result = sb.toString().trim();
        System.out.println(result);
    }
}

