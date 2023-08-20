package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 패션왕 신해빈 https://www.acmicpc.net/problem/9375
public class Boj9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        int clothesNum = 0;
        HashMap<String, Integer> map;
        Iterator<HashMap> iterator;
        Integer ans;

        for (int i = 0; i < N; i++) {
            map = new HashMap<>();
            clothesNum = Integer.parseInt(reader.readLine());
            for (int j = 0; j < clothesNum; j++) {
                String category = reader.readLine().split(" ")[1];
                map.put(
                        category,
                        map.containsKey(category) ? map.get(category) + 1 : 1
                );
            }
            ans = 1;
            for (Map.Entry<String, Integer> entry :
                    map.entrySet()) {
                ans *= combination(entry.getValue() + 1, 1);
            }
            System.out.println(ans - 1);

        }

    }

    static int combination(Integer n, Integer r) {
        if (n == r || r == 0) return 1;
        else return combination(n-1, r-1) + combination(n-1, r);
    }
}
