package this_is_coding_test.chapter12;

public class chapter13_3 {
    static class Solution {
        public int solution(String s) {
            int len = s.length();
            int half = len / 2;
            StringBuilder sb = new StringBuilder();
            int min = len;

            for (int i = 1; i <= half; i++) {
                int count = 1;
                String cache = s.substring(0, i);
                String cur = "";

                for (int j = 1; j < len / i; j++) {
                    cur = s.substring(i * j, i * (j + 1));
                    if (cache.equals(cur)) {
                        count++;
                    } else {
                        if (count != 1) sb.append(count);
                        sb.append(cache);
                        cache = cur;
                        count = 1;
                    }
                }

                // 만약 나누어 떨어지지 않을 경우 나머지 계산을 수행한다.
                if (len % i != 0) {
                    cur = s.substring((len / i) * i);
                    if (cache.equals(cur)) {
                        count++;
                    } else {
                        if (count != 1) sb.append(count);
                        sb.append(cache);
                        count = 1;
                    }
                }

                // 마지막 비교를 수행하고 값을 초기화한다.
                if (count != 1) sb.append(count);
                sb.append(cur);
                if (min > sb.length()) min = sb.length();
                sb = new StringBuilder();

            }

            return min;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("problem 1 : " + s.solution("aabbaccc"));
        System.out.println("problem 2 : " + s.solution("ababcdcdababcdcd"));
        System.out.println("problem 3 : " + s.solution("abcabcdede"));
        System.out.println("problem 4 : " + s.solution("abcabcabcabcdededededede"));
        System.out.println("problem 5 : " + s.solution("xababcdcdababcdcd"));
    }
}
