package this_is_coding_test.chapter13;
import java.util.*;

public class chapter13_4 {
    class Solution {
        public String[] separater(String p) {
            String[] answer = new String[2];
            int lCnt = 0;
            int rCnt = 0;

            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == '(') lCnt++;
                else rCnt++;

                if (lCnt == rCnt) {
                    answer[0] = p.substring(0, i + 1);
                    answer[1] = p.substring(i + 1);
                    break;
                }
            }

            return answer;
        }

        public boolean isCorrect(String p) {
            Stack<Character> s = new Stack<>();

            for (int i = 0; i < p.length(); i++) {
                char cur = p.charAt(i);
                if (cur == ')') {
                    if (s.isEmpty()) return false;
                    s.pop();
                    continue;
                }
                s.push(cur);
            }

            return true;
        }

        public String solution(String p) {
            if (p.equals("")) return "";
            String[] uv = separater(p);
            String u = uv[0];
            String v = uv[1];

            if (isCorrect(u)) return u + solution(v);

            String answer = "(" + solution(v) + ")";
            u = u.substring(1, u.length() - 1);
            String tmp = "";
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == '(') tmp += ")";
                else tmp += "(";
            }
            return answer + tmp;
        }
    }
}
