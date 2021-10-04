package this_is_coding_test.chapter12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class chapter12_7 {
    private static ArrayList<Loc[]> chickens = new ArrayList<>();
    static class Loc {
        int x;
        int y;
        Loc (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void getChicken(ArrayList<Loc> al, int m, int depth, int tar, int[] cur) {
        if (depth == m) {
            Loc[] tmp = new Loc[m];
            for (int i = 0; i < m; i++) {
                tmp[i] = al.get(cur[i]);
            }
            chickens.add(tmp);
            return;
        }
        if (tar == al.size()) return;
        cur[depth] = tar;
        getChicken(al, m, depth + 1, tar + 1, cur);
        getChicken(al, m, depth, tar + 1, cur);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Loc> chi = new ArrayList<>();
        ArrayList<Loc> hou = new ArrayList<>();

        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) {
                    chi.add(new Loc(i, j));
                } else if (arr[i][j] == 1) {
                    hou.add(new Loc(i, j));
                }
            }
        }

        getChicken(chi, M, 0, 0, new int[M]);
        int chiLen = chickens.size();
        int houLen = hou.size();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < chiLen; i++) {
            Loc[] curArr = chickens.get(i);

            int[] shortest = new int[houLen];

            for (int j = 0; j < houLen; j++) {
                shortest[j] = Integer.MAX_VALUE;
            }

            for (int j = 0; j < houLen; j++) {
                for (int k = 0; k < M; k++) {
                    Loc cur = curArr[k];
                    int tmp = Math.abs(cur.x - hou.get(j).x) + Math.abs(cur.y - hou.get(j).y);
                    if (shortest[j] > tmp) shortest[j] = tmp;
                }
            }

            int tmp = 0;
            for (int j = 0; j < shortest.length; j++) {
                tmp += shortest[j];
            }
            if (result > tmp) result = tmp;
        }

        System.out.println(result);
    }
}
