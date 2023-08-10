package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2583Bfs {
    private class Node {
        int y; int x;
        Node(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    private int[][] paper;
    private boolean[][] visited;
    private int area;
    private List<Integer> areas = new ArrayList<Integer>();
    private Queue<Node> queue;

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int M = Integer.parseInt(st.nextToken()); // 행
        int N = Integer.parseInt(st.nextToken()); // 열
        int K = Integer.parseInt(st.nextToken());
        // 빈 종이 만들기
        paper = new int[M][N];
        // 입력 받아서 종이 그리기
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(reader.readLine());
            int xStart = Integer.parseInt(st.nextToken());
            int yStart = Integer.parseInt(st.nextToken());
            int xEnd = Integer.parseInt(st.nextToken());
            int yEnd = Integer.parseInt(st.nextToken());

            for (int j = yStart; j < yEnd; j++) {
                for (int k = xStart; k < xEnd; k++) {
                    paper[j][k] = 1;
                }
            }
        }
        // 잘 입력 됐느지 확인
//        for (int i = 0; i < M; i++) {
//            System.out.println(Arrays.toString(paper[i]));
//        }

        int cnt = 0;
        visited = new boolean[M][N];

        // 새로운 빈공간 찾기
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (
                        !visited[j][i]
                                && paper[j][i] == 0
                ) {
                    // 새로운 빈공간 탐색을 위해 초기화
                    cnt++;
                    queue = new LinkedList<>();
                    queue.add(new Node(i, j));
                    visited[j][i] = true;
                    area = 1;
                    bfs(queue.poll());
                }
            }
        }
        System.out.println(cnt);
        Collections.sort(areas);
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%d ",areas.get(i));
        }
    }

    public void bfs(Node node) {
        int x = node.x;
        int y = node.y;

        for (int i = 0; i < 4; i++) {
            if (
                    y + dy[i] < paper.length && y+ dy[i] >= 0
                    && x + dx[i] < paper[0].length && x + dx[i] >= 0
                    && paper[y + dy[i]][x + dx[i]] == 0
                    && !visited[y + dy[i]][x + dx[i]]
            ) {
                // 현재 노드에서 방문 가능한 노드가 있으면 모두 방문처리 후 queue에 담기
                visited[y + dy[i]][x + dx[i]] = true;
                // 방문할 때마다 해당 구역의 넓이 ++
                area++;
                queue.add(new Node(x + dx[i], y + dy[i]));
            }
        }
        // 현재 노드에서 방문할 노드가 없고 queue도 비어있으면 끝
        if (queue.isEmpty()) {
            areas.add(area);
            return;
        }
        // 계속 탐색
        bfs(queue.poll());
    }

    public static void main(String[] args) throws IOException {
        Boj2583Bfs boj = new Boj2583Bfs();
        boj.solution();
    }
}
