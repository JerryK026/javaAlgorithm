package this_is_coding_test.chapter12;

public class chapter12_4 {
    static class Solution {
        // key를 넣으면 90도 회전해 반환한다.
        private int[][] keyRotation(int[][] key, int n) {

            int len = key.length;
            int[][] newKey = new int[len][len];

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    newKey[i][j] = key[j][len - 1 -i];
                }
            }

            return newKey;
        }

        // 들어맞으면 1, 안 들어맞으면 0을 반환한다.
        private boolean check(int[][] lock, int klen, int llen) {
            for (int i = 0; i < llen; i++) {
                for (int j = 0; j < llen; j++) {
                    if(lock[klen + i - 1][klen + j - 1] == 0) return false;
                }
            }
            return true;
        }

        public boolean solution(int[][] key, int[][] lock) {
            int klen = key.length;
            int llen = lock.length;
            int[][] newLock = new int[llen + 2 * klen][llen + 2 * klen];

            for (int i = 0; i < llen; i++) {
                for (int j = 0; j < llen; j++) {
                    newLock[i + klen - 1][j + klen - 1] = lock[i][j];
                }
            }

            for (int n = 0; n < 4; n++) {
                key = keyRotation(key, n);
                for (int i = 0; i < llen + klen - 1; i++) {
                    for (int j = 0; j < llen + klen - 1; j++) {

                        for (int a = 0; a < klen; a++) {
                            for (int b = 0; b < klen; b++) {
                                newLock[a + i][b + j] += key[a][b];
                            }
                        }

                        if(check(newLock, klen, llen)) return true;

                        for (int a = 0; a < klen; a++) {
                            for (int b = 0; b < klen; b++) {
                                newLock[a + i][b + j] -= key[a][b];
                            }
                        }

                    }
                }
            }

            return false;
        }
    }
}
