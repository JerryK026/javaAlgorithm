package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_8979 {
    static private class Country {
        int gold;
        int silver;
        int copper;
        Country(int gold, int silver, int copper) {
            this.gold = gold;
            this.silver = silver;
            this.copper = copper;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Country> map = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), new Country(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int count = 1;
        int Kg = map.get(K).gold;
        int Ks = map.get(K).silver;
        int Kc = map.get(K).copper;

        for (int i : map.keySet()) {
            if (K == i) continue;
            if (map.get(i).gold > Kg) {
                count++;
                continue;
            }
            else  if (map.get(i).gold == Kg) {
                if (map.get(i).silver > Ks) {
                    count++;
                    continue;
                }
                else if (map.get(i).silver == Ks) {
                    if (map.get(i).copper > Kc) {
                        count++;
                        continue;
                    }
                }
            }
        }

        System.out.println(count);
    }
}
