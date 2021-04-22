package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16928 {
    static class Token {
        int idx;
        int cnt;
        Token(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[100];
        for(int i = 0; i < 100; i++) {
            arr[i] = i;
        }

        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            arr[Integer.parseInt(st.nextToken()) - 1] = Integer.parseInt(st.nextToken()) - 1;
        }

        bfs(arr);
    }

    static void bfs(int[] arr) {
        Queue<Token> q = new LinkedList<>();
        Token t = new Token(0, 0);
        q.add(t);
        boolean flag = false;

        while (!q.isEmpty()) {
            t = q.poll();
            for(int i = 0; i < 7; i++) {
                if(t.idx == 100) {
                    flag = true;
                    break;
                }
                else if(arr[t.idx] != t.idx){
                    q.add(new Token(arr[t.idx] + i, t.cnt + 1));
                }
                else {
                    q.add(new Token(t.idx + i, t.cnt + 1));
                }
            }

            if(flag) {
                break;
            }
        }

        System.out.println(t.cnt);
    }
}
