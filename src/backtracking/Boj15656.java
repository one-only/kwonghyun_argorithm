package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://acmicpc.net/problem/15656
// N과 M (7)
public class Boj15656 {
    static int[] arr;
    static int[] selected;
    static StringBuilder sb;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
        }

        arr = new int[N];
        {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr = Arrays.stream(arr)
                    .map(i -> Integer.parseInt(st.nextToken()))
                    .sorted()
                    .toArray();
        }
        sb = new StringBuilder();
        selected = new int[M];
        dfs(0);
        System.out.println(sb.toString());
    }

    static void dfs(int depth) {
        if (depth == M) {
            Arrays.stream(selected)
                    .forEach(i -> sb.append(i + " "));
            sb.append("\n");
            return;
        }

        Arrays.stream(arr).forEach(i -> {
                selected[depth] = i;
                dfs(depth + 1);
            }
        );
    }
}
