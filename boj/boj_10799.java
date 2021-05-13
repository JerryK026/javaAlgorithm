package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// () 이 꼴일 때는 레이저를 쏜다. Stack을 이용해서 쇠막대기가 겹쳐지는 걸 표현한다.
// 만약, )를 만나면 pop하고, idx - 1가 (일 경우, 레이저임을 알 수 있다. 레이저로 자르면, 더해지는 쇠막대기의 수는 겹쳐진 쇠막대기의 수와 같다.
// 즉, stack의 size와 같다는 의미이다. 만약, (가 아니라면 쇠막대기가 끝났다는 의미이므로 count + 1 해주면 된다.

// 아니면 Stack은 현재의 상태를 저장한다는 성질을 이용해서, 이전의 index를 읽는 게 아니라, 이전의 정보까지 담는 방식으로 구현할 수도 있다.
// 이전에 저장한 방식이 (였는지)였는지 저장하고, 현재 저장한 값이 (였는지)였는지 저장하는 식으로도 해결 가능하다.
// 아니면 변수 flag를 설정해 놓고 사용할 수도 있다.

public class boj_10799 {
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Character> deque = new ArrayDeque<>();
        int count = 0;
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '(') {
                deque.push('(');
                continue;
            }
            // )일 경우 pop
            deque.pop();
            if (input.charAt(i - 1) == '(') {
                count += deque.size();
            } else {
                // 쇠막대기가 끝난 경우
                count++;
            }
            continue;

        }

        System.out.println(count);
    }
}
