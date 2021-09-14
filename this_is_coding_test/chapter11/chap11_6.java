package this_is_coding_test.chapter11;

import java.util.*;

public class chap11_6 {
    static class Food {
        int time;
        int idx;
        public Food(int time, int idx) {
            this.time = time;
            this.idx = idx;
        }
    }

    Comparator<Food> timeComp = new Comparator<>() {
        public int compare(Food a, Food b) {
            return a.time - b.time;
        }
    };

    Comparator<Food> idxComp = new Comparator<>() {
        public int compare(Food a, Food b) {
            return a.idx - b.idx;
        }
    };

    public int solution(int[] food_times, long k) {
        List<Food> lst = new LinkedList<Food>();
        int n = food_times.length;

        for (int i = 0; i < n; i++) {
            lst.add(new Food(food_times[i], i + 1));
        }

        lst.sort(timeComp);

        int cache = 0;
        int i = 0;
        for (Food f: lst) {
            long diff = f.time - cache;
            if (f.time != 0) {
                long spend = diff * n;
                if (spend > k) {
                    k %= n;
                    lst.subList(i, food_times.length).sort(idxComp);
                    return lst.get(i + (int)k).idx;
                } else {
                    k -= spend;
                    cache = f.time;
                }
            }
            i++;
            n--;
        }

        return -1;
    }
}