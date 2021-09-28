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
                    // == 0이면 return false했을 때는 97점 나왔는데 그 이유는?
                    if(lock[klen + i - 1][klen + j - 1] != 1) return false;
                }
            }
            return true;
        }

        public boolean solution(int[][] key, int[][] lock) {
            int klen = key.length;
            int llen = lock.length;
            // llen + (klen - 1) * 2가 아닌 이유는?
            int[][] newLock = new int[llen + 2 * klen][llen + 2 * klen];

            for (int n = 0; n < 4; n++) {
                key = keyRotation(key, n);
                for (int i = 0; i < llen + klen - 1; i++) {
                    for (int j = 0; j < llen + klen - 1; j++) {

                        // newLock 초기화
                        for (int a = 0; a < llen; a++) {
                            for (int b = 0; b < llen; b++) {
                                newLock[a + klen - 1][b + klen - 1] = lock[a][b];
                            }
                        }

                        // Lock에 key 넣어보기
                        for (int a = 0; a < klen; a++) {
                            for (int b = 0; b < klen; b++) {
                                newLock[a + i][b + j] += key[a][b];
                            }
                        }

                        if(check(newLock, klen, llen)) return true;

                    }
                }
            }

            return false;
        }
    }
}
