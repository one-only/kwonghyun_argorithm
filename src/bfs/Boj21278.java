package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 호석이 두마리 치킨 https://www.acmicpc.net/problem/21278
public class Boj21278 {
    static Queue<Integer> queue;
    static HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
    static int[] visited;
    static TreeSet<int[]> ansSet;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i < N + 1; i++) {
            graph.put(i, new LinkedList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            int input1 = Integer.parseInt(st.nextToken());
            int input2 = Integer.parseInt(st.nextToken());
            graph.get(input1).add(input2);
            graph.get(input2).add(input1);
        }

        ansSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int cntComparison = o1[2] - o2[2];
                if (cntComparison == 0) {
                    int smallNumComparison = o1[0] - o2[0];
                    if (smallNumComparison == 0) {
                        int bigNumComparison = o1[1] - o2[1];
                        return bigNumComparison;
                    } else {
                        return smallNumComparison;
                    }
                } else {
                    return cntComparison;
                }
            }
        });

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j < N + 1; j++) {
                queue = new LinkedList<>();
                visited = new int[N + 1];
                for (int k = 1; k < N + 1; k++) {
                    visited[k] = -1;
                }
                queue.add(i);
                queue.add(j);
                visited[i] = 0;
                visited[j] = 0;
                int[] result = new int[]{i, j, bfs()};
                ansSet.add(result);
            }
        }
        int[] ans = ansSet.pollFirst();
        System.out.printf("%d %d %d", ans[0], ans[1], ans[2]);
    }

    static int bfs() {
        int cnt = 0;
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int node : graph.get(currentNode)) {
                if (visited[node] == -1) {
                    visited[node] = visited[currentNode] + 1;
                    queue.add(node);
                    cnt += 2 * visited[node];
                }
            }
        }
        return cnt;
    }
}
