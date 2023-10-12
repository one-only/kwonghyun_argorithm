package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 부분수열의 합 https://www.acmicpc.net/problem/1182
public class Boj1182 {
    private static int cnt;
    private static int N;
    private static int S;
    private static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine(), " ");
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        System.out.println(S == 0 ? cnt - 1 : cnt);
    }

    private static void dfs(int idx, int sum) {
        if (idx == N) {
            if (sum == S) {
                cnt++;
            }
            return;
        }
        dfs(idx + 1, sum + nums[idx]);
        dfs(idx + 1, sum);
    }
}
