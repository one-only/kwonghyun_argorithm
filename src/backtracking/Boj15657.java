package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://acmicpc.net/problem/15657
// N과 M (8)
public class Boj15657 {
    static int N;
    static int M;
    static int[] arr;
    static int[] selected;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            selected = new int[M];
        }

        {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr = Arrays.stream(arr)
                    .map(i -> Integer.parseInt(st.nextToken()))
                    .sorted()
                    .toArray();
        }

        sb = new StringBuilder();
        dfs(0, 0);
        System.out.println(sb.toString());
    }

    static void dfs(int depth, int now) {
        if (depth == M) {
            Arrays.stream(selected).forEach(i -> sb.append(i + " "));
            sb.append("\n");
            return;
        }

        for (int i = now; i < N; i++) {
            selected[depth] = arr[i];
            dfs(depth + 1, i);
        }
    }
}
