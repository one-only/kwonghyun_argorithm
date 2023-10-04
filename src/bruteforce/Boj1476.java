package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 날짜 계산 https://www.acmicpc.net/problem/1476
public class Boj1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int e = 1;
        int s = 1;
        int m = 1;
        int cnt = 1;

        while (
                e != E
                || s != S
                || m != M
        ) {
            e = e == 15 ? 1 : e + 1;
            s = s == 28 ? 1 : s + 1;
            m = m == 19 ? 1 : m + 1;
            cnt++;
        }

        System.out.println(cnt);

    }
}
