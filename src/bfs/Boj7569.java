package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 토마토 https://www.acmicpc.net/problem/7569
public class Boj7569 {
    static int N;
    static int M;
    static int H;
    static boolean[][][] visited;
    static int[][][] box;
    static int[] dx = new int[]{1, -1, 0, 0, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1, 0, 0};
    static int[] dz = new int[]{0, 0, 0, 0, 1, -1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(reader.readLine(), " ");
                for (int k = 0; k < M; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    if (input == 1) {
                        queue.add(new int[]{i, j, k});
                        visited[i][j][k] = true;
                    }
                    box[i][j][k] = input;
                }
            }
        }
        bfs();



    }
    static void bfs() {
        while (!queue.isEmpty()) {
            int[] currentNode = queue.poll();

            int x = currentNode[2];
            int y = currentNode[1];
            int z = currentNode[0];

            for (int i = 0; i < 6; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];

                if (
                        nextX < M && nextX >= 0
                        && nextY < N && nextY >= 0
                        && nextZ < H && nextZ >= 0
                        && box[nextZ][nextY][nextX] == 0
                        && !visited[nextZ][nextY][nextX]
                ) {
                    queue.add(new int[]{nextZ, nextY, nextX});
                    visited[nextZ][nextY][nextX] = true;
                    box[nextZ][nextY][nextX] = box[z][y][x] + 1;
                }
            }
        }
        int ans = -2;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        System.exit(0);
                    }
                    ans = Math.max(ans, box[i][j][k]);
                }
            }
        }
        if (ans == 1) {
            System.out.println(0);
        } else {
            System.out.println(ans - 1);
        }
    }
}
