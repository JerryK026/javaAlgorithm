package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public int size;
    public int msize;

    public int[][] turn(int[][] key) {
        int[][] turned_key = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = size - 1; j >= 0; j--) {
                turned_key[j][i] = key[i][j];
            }
        }
        return turned_key;
    }

    public int[][] right(int[][] key) {
        for(int i = size - 2; i >= 0; i--) {
            for(int j = 0; j < size; j++) {
                key[i + 1][j] = key[i][j];
            }
        }
        for(int i = 0; i < size; i++) {
            key[0][i] = 0;
        }
        return key;
    }

    public int[][] left(int[][] key) {
        for(int i = 1; i < size; i++) {
            for(int j = 0; j < size; j++) {
                key[i - 1][j] = key[i][j];
            }
        }
        for(int i = 0; i < size; i++) {
            key[size - 1][i] = 0;
        }
        return key;
    }

    public int[][] down(int[][] key) {
        for(int i = 0; i < size; i++) {
            for(int j = size - 2; j >= 0; j--) {
                key[i][j + 1] = key[i][j];
            }
        }
        for(int i = 0; i < size; i++) {
            key[i][0] = 0;
        }
        return key;
    }

    public int[][] up(int[][] key) {
        for(int i = 0; i < size; i++) {
            for(int j = 1; j < size; j++) {
                key[i][j - 1] = key[i][j];
            }
        }
        for(int i = 0; i < size; i++) {
            key[i][size - 1] = 0;
        }
        return key;
    }

    public boolean ans(int[][] key, int[][] mk) {
        int s = key.length;
        for(int i = 0; i < s; i++) {
            for(int j = 0; j < s; j++) {
                if(key[i][j] + mk[i][j] != 1) return false;
            }
        }
        return true;
    }

    public int[][] set(int[][] key) {
        int[][] mk = new int[size * 3][size * 3];

        for(int i = 0; i < key.length; i++) {
            for(int j = 0; j < key.length; j++) {
                mk[i][j] = key[i][j];
            }
        }

        return mk;
    }

    public int[][] set2(int[][] mk) {
        int [][] tmp = new int[mk.length][mk.length];

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                tmp[i][j] = mk[i][j];
            }
        }
        return tmp;
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        size = key.length;
        int[][] mk = set(key);
        int[][] tmp = set2(mk);
        size = mk.length;
        int count = 0;

        for(int i = 0; i <= 3; i++) {
            for(int j = 0; j < key.length; j++) {
                for (int k = 0; k < key.length; k++) {
                    if (ans(lock, mk)) return true;
                    if (count < key.length) {
                        mk = right(mk);
                        count++;
                    } else {
                        mk = left(mk);
                        count++;

                        if (count == key.length * 2) count = 0;
                    }
                    if (ans(lock, mk)) return true;
                }
                mk = down(mk);
                if (ans(lock, mk)) return true;
            }
            mk = tmp;
            mk = turn(mk);
            tmp = set2(mk);
            count = 0;
        }

        return answer;
    }
}

public class kakao_blind_2020_no3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[][] key = new int [3][3];
        int[][] lock = new int [3][3];

        for(int i = 0; i < 3; i++) {
            for(int j = 0; st.hasMoreTokens(); j++) {
                key[i][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; st.hasMoreTokens(); j++) {
                lock[i][j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
        }

        Solution s = new Solution();
        System.out.println(s.solution(key, lock));
    }
}