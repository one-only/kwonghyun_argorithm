package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 하노이 탑 이동순서 https://www.acmicpc.net/problem/11729
public class Boj11729 {
    static int cnt = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        move(N, 1, 3, 2);
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    static void move(int N, int from, int to, int temp) {
        if (N == 1) {
            cnt++;
            sb.append(from + " " + to + "\n");
            return;
        } else {
            move(N - 1, from, temp, to);
            sb.append(from + " " + to + "\n");
            cnt++;
            move(N - 1, temp, to, from);
        }
    }

}
