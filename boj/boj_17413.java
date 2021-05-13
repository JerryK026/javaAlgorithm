package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class boj_17413 {
    static void pop_until_deque_empty(Deque d, StringBuilder sb) {
        while (!d.isEmpty()) {
            sb.append(d.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // Stack 용 Deque
        Deque<Character> deque = new ArrayDeque<>();
        // push -> 맨 앞에 (Stack. LIFO).  add, offer, put -> 맨 뒤에 (Queue, FIFO)
        // peek -> 맨 앞 element.
        // poll (Queue), pop (Stack) -> 맨 앞 element.
        // poll을 0번째 index만 하므로, stack을 구현하려면 0번째 idx에 넣고, queue를 구현하려면 마지막 idx에 넣는 식.
        StringBuilder result = new StringBuilder();

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '<') {
                // 태그를 시작하기 전에 deque에 값이 들어있다면 우선 입력.
                pop_until_deque_empty(deque, result);
                // 태그의 내용은 전부 입력
                while (s.charAt(i) != '>') {
                    result.append(s.charAt(i++));
                    continue;
                }
                result.append('>');
                continue;
            }
            // 공백일 경우 단어 끝이므로 모두 입력
            if (s.charAt(i) == ' ') {
                pop_until_deque_empty(deque, result);
                result.append(' ');
                continue;
            }
            deque.push(s.charAt(i));
        }

        pop_until_deque_empty(deque, result);

        System.out.println(result.toString());
    }
}
