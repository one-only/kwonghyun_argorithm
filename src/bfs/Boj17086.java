package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 아기상어 2 https://www.acmicpc.net/problem/17086
public class Boj17086 {
    static Queue<int[]> queue;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[][]  map;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if (input == 1) {
                    queue.add(new int[]{j, i});
                }
            }
        }
        bfs();

    }
    static void bfs() {
        int safeDist = 0;


        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();

            int x = currentNode[0];
            int y = currentNode[1];

            for (int i = 0; i < 8; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if (
                        nextX < M && nextX >= 0
                        && nextY < N && nextY >= 0
                        && map[nextY][nextX] == 0
                ) {
                    map[nextY][nextX] = map[y][x] + 1;
                    safeDist = Math.max(map[nextY][nextX], safeDist);
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        System.out.println(safeDist - 1);
    }

}
