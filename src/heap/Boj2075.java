package heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
// N번째 큰 수 https://www.acmicpc.net/problem/2075
public class Boj2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                ints.add(Integer.parseInt(st.nextToken()));
            }
        }
        Collections.sort(ints, Collections.reverseOrder());
        System.out.println(ints.get(N - 1));
    }
}
