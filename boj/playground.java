package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class playground {
    static int key;

    static String caesar(String input) {
        StringBuilder sb = new StringBuilder();
        int len = input.length();
        int flag = 0;

        // 64 이하라면 26를 더하고 91 이상이라면 26를 뺀다. 입력이 65 ~ 90이기 때문에 loop를 돌 필요가 없다.
        for (int i = 0; i < len; i++) {
            int cur = input.charAt(i) + key;
            if (cur > 90) flag = -1;
            else if (cur < 65) flag = 1;
            else flag = 0;

            sb.append((char)(cur + (26 * flag)));
        }
        sb.append("\n");
        return sb.toString();
    }

    static String xor(String input) {
        StringBuilder sb = new StringBuilder();
        int len = input.length();

        for (int i = 0; i < len; i++) {
            int cur = input.charAt(i);
            sb.append((char)(cur ^ key));
        }
        sb.append("\n");
        return sb.toString();
    }

    static public void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String arr[] = new String[6];

        for (int i = 0; i < 6; i++) {
            arr[i] = br.readLine();
        }

        key = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 3; i++) {
            sb.append(caesar(arr[i]));
        }

        for(int i = 3; i < 6; i++) {
            sb.append(xor(arr[i]));
        }

        String result = sb.toString().trim();
        System.out.println(result);
    }
}

