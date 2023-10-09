package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// 도영이가 만든 맛있는 음식 https://www.acmicpc.net/problem/2961
public class Boj2961 {
    private static List<List> powerSet;
    private static long min = Long.MAX_VALUE;
    static class Dish {
        long sour;
        long bitter;
        Dish (int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        Dish[] dishes = new Dish[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            dishes[i] = new Dish(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        powerSet = new LinkedList<>();
        powerSet.add(new LinkedList<Dish>());
        getPowerSet(dishes, 0, dishes.length);
    }
    private static void getPowerSet(Dish[] dishes, int idx, int end) {

        if (idx == end) {
            System.out.println(min);
            System.exit(0);
        }

        for (List<Dish> set : powerSet) {
            System.out.println("부분집합 수: "+powerSet.size());

            set.add(dishes[idx]);
            int bitter = 0;
            int sour = 1;
            for (Dish dish : set) {
                bitter += dish.bitter;
                sour *= dish.sour;
                System.out.printf("쓴맛: %d 신맛: %d\n", dish.bitter, dish.sour);
                System.out.printf("누적 쓴맛: %d 누적 신맛: %d\n", bitter, sour);
            }
            int sub = Math.abs(bitter - sour);
            min = sub < min ? sub : min;
            //System.out.println(min);
            if (min == 0) {
                System.out.println(min);
                System.exit(0);
            }
        }
        powerSet.add(new LinkedList<Dish>());

        getPowerSet(dishes, ++idx, end);
    }
}
