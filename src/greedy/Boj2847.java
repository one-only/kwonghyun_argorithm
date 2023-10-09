package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 게임을 만든 동준이 https://www.acmicpc.net/problem/2847
public class Boj2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int[] points = new int[N];
        for (int i = 0; i < N; i++) {
            points[i] = Integer.parseInt(reader.readLine());
        }

        int cnt = 0;
        for (int i = N - 2; i >= 0; i--) {
            while (points[i] >= points[i + 1]) {
                points[i]--;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
