package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj2583Dfs {
    private class Node {
        int y; int x;
        Node(int x, int y) {
            this.y = y;
            this.x = x;
        }
    }
    // 다음으로 탐색할 노드(현재에서 상하좌우)
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    // 문제 입력받을 판
    private int[][] paper;
    // 방문여부 표시할 판
    private boolean[][] visited;
    // 영역의 넓이 표시할 변수
    private int area;
    // 각 영역들 기록할 곳
    private List<Integer> areas = new ArrayList<Integer>();

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

        int cnt = 0;
        visited = new boolean[M][N];

        // 새로운 빈공간 찾기
        for (int j = 0; j < M; j++) {
            for (int i = 0; i < N; i++) {
                if (
                        // 방문한적 없는 노드인지
                        !visited[j][i]
                        // 비어있는 노드인지
                        && paper[j][i] == 0
                ) {
                    // 새로운 빈공간 탐색을 위해 초기화
                    cnt++;
                    visited[j][i] = true;
                    area = 1;
                    // dfs
                    dfs(new Node(i, j));
                    // 탐색 끝난 부분의 넓이 기록하기
                    areas.add(area);

                }
            }
        }
        // 정답 출력
        System.out.println(cnt);
        Collections.sort(areas);
        for (int i = 0; i < cnt; i++) {
            System.out.printf("%d ",areas.get(i));
        }
    }

    public void dfs(Node node) {
        int x = node.x;
        int y = node.y;

        for (int i = 0; i < 4; i++) {
            if (
                    // 검색할 노드가 범위안에 들어오는지
                    y + dy[i] < paper.length && y+ dy[i] >= 0
                    && x + dx[i] < paper[0].length && x + dx[i] >= 0
                    // 검색할 노드가 비어 있는지
                    && paper[y + dy[i]][x + dx[i]] == 0
                    // 방문한적 없는 노드인지
                    && !visited[y + dy[i]][x + dx[i]]
            ) {
                // 현재 노드에서 방문 가능한 노드가 있으면 방문처리
                visited[y + dy[i]][x + dx[i]] = true;
                // 방문할 때마다 해당 구역의 넓이 ++
                area++;
                // dfs
                dfs(new Node(x + dx[i], y + dy[i]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Boj2583Dfs boj = new Boj2583Dfs();
        boj.solution();
    }
}
