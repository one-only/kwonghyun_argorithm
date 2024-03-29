package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/15663
// N과 M (9)
// TODO 다시 해볼 것
public class Boj15663 {
    static int N;
    static int M;
    static int[] arr;
    static int[] selected;
    static HashSet<String> ans = new LinkedHashSet<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N];
            visited = new boolean[N];
            selected = new int[M];
        }
        {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            arr = Arrays.stream(arr)
                    .map(i -> Integer.parseInt(st.nextToken()))
                    .sorted()
                    .toArray();
        }

        dfs(0);
        String collected = ans.stream().collect(Collectors.joining());
        System.out.println(collected);
    }

    static void dfs(int depth) {
        if (depth == M) {
            StringBuilder intSb = new StringBuilder();
            Arrays.stream(selected).forEach(i -> intSb.append(i+" "));
            intSb.append("\n");
            ans.add(intSb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            selected[depth] = arr[i];
            visited[i] = true;
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
