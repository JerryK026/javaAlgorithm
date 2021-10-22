package this_is_coding_test.chapter5;

import java.util.ArrayList;
import java.util.LinkedList;

public class chap5_1 {
    static ArrayList<int[]> graph;
    static boolean[] visited;
    static LinkedList<Integer> queue = new LinkedList<>();

    private static void setGraph() {
        graph = new ArrayList();
        graph.add(new int[]{});
        graph.add(new int[]{2, 3, 8});
        graph.add(new int[]{1, 7});
        graph.add(new int[]{1, 4, 5});
        graph.add(new int[]{3, 5});
        graph.add(new int[]{3, 4});
        graph.add(new int[]{7});
        graph.add(new int[]{2, 6, 8});
        graph.add(new int[]{1, 7});
    }

    private static void setVisited() {
        visited = new boolean[graph.size()];
    }

    private static void dfs(int i) {
        visited[i] = true;
        System.out.print(" " + i);

        int[] cur = graph.get(i);
        for (int j : cur) if (!visited[j]) dfs(j);
    }

    private static void bfs(int i) {
        visited[i] = true;
        queue.offer(i);

        while (!queue.isEmpty()) {
            int j = queue.poll();
            int[] cur = graph.get(j);
            System.out.print(" " + j);

            for (int k : cur) {
                if (!visited[k]) {
                    queue.offer(k);
                    visited[k] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int start = 1;
        setGraph();
        setVisited();

        System.out.print("dfs : ");
        dfs(start);

        System.out.print("\nbfs : ");
        setVisited();
        bfs(start);
    }
}
