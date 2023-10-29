package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

// 파티 https://www.acmicpc.net/problem/1238
public class Boj1238 {
    static class Node implements Comparable<Node> {
        int city, w;

        Node(int city, int w) {
            this.city = city;
            this.w = w;
        }

        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
    static int n, m, x;
    static ArrayList<Node> list[];
    static int dist[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] t = br.readLine().split(" ");


        n = Integer.parseInt(t[0]);
        m = Integer.parseInt(t[1]);
        x = Integer.parseInt(t[2]);

        dist = new int[n + 1][n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], 987654321);
        }

        for (int i = 0; i < m; i++) {
            t = br.readLine().split(" ");
            int start = Integer.parseInt(t[0]);
            int end = Integer.parseInt(t[1]);
            int w = Integer.parseInt(t[2]);
            list[start].add(new Node(end, w));
        }

        for (int i = 1; i <= n; i++) {
            djistra(i);
        }


        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dist[i][x] + dist[x][i]);
        }
        System.out.println(max);
    }

    public static void djistra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean visited[] = new boolean[n + 1];
        pq.add(new Node(start, 0));
        dist[start][start] = 0;
        while (!pq.isEmpty()) {
            Node a = pq.poll(); // 시작 도시와 연결된 도시
            visited[a.city] = true;
            for (Node tmp : list[a.city]) {
                if (visited[tmp.city]) continue;
                if (dist[start][tmp.city] > dist[start][a.city] + tmp.w) {
                    dist[start][tmp.city] = dist[start][a.city] + tmp.w;
                    pq.add(new Node(tmp.city, dist[start][tmp.city]));
                }
            }
        }

    }
}


