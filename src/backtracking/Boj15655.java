package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/15655
// N과 M (6)
public class Boj15655 {
    static int[] arr;
    static int[] selected;
    static boolean[] visited;
    static StringBuilder sb;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        StringTokenizer ints = new StringTokenizer(bf.readLine());
        arr = new int[N];
        arr = Arrays.stream(arr)
                .map(i -> Integer.parseInt(ints.nextToken()))
                .sorted()
                .toArray();

        selected = new int[M];
        sb = new StringBuilder();
        visited = new boolean[N];
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
            if (!visited[i]) {
                selected[depth] = arr[i];
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
