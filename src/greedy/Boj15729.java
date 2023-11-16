package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
// 방탈출 https://www.acmicpc.net/problem/15729
public class Boj15729 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        boolean[] switches = new boolean[N];
        boolean[] targets = new boolean[N];
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < N; i++) {
            targets[i] = st.nextToken().equals("0") ? false : true;
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (switches[i] != targets[i]) {
                switches[i] = !switches[i];
                if (i < N - 1) {
                    switches[i + 1] = !switches[i + 1];
                }
                if (i < N - 2) {
                    switches[i + 2] = !switches[i + 2];
                }
                cnt++;
            }
        }
        System.out.println(cnt);

    }

}
