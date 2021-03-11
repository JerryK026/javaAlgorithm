package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;;
    }

    public Node add(int data, Node prev) {
        Node newNode = new Node(data);
        prev.next = newNode;
        return newNode;
    }

    public int get() {
        return this.data;
    }
}

public class boj_1158 {
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        StringBuilder result = new StringBuilder("<");

        Node start = new Node(1);
        Node tmp = start;
        for(int i = 2; i < N + 1; i++) {
           tmp = start.add(i, tmp);
        }
        tmp.next = start;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < K - 1; j++) {
                tmp = tmp.next;
            }
            result.append(tmp.next.get() + ", ");
            tmp.next = tmp.next.next;
        }
        int len = result.length();
        result.delete(len-2,len);
        result.append(">");
        System.out.println(result);
    }
}
