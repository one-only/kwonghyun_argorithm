package bfs;
// 안전 영역 https://www.acmicpc.net/problem/2468

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2468 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] initP;
    private static int safeAreaCnt;
    private static int maxSafeAreaCnt;
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};
    private static int flood;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        map = new int[N][N];
        int highestP = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                highestP = map[i][j] > highestP ? map[i][j] : highestP;
            }

        }

        for (int i = 1; i < highestP; i++) {
            flood = i;
            initP = new int[]{0, 0};
            safeAreaCnt = 0;
            visited = new boolean[N][N];
            while (searchSafeArea()[0] != -1) {
                dfs(initP[0], initP[1]);
                safeAreaCnt++;
            }
            maxSafeAreaCnt = maxSafeAreaCnt < safeAreaCnt ? safeAreaCnt : maxSafeAreaCnt;
        }

        System.out.println(maxSafeAreaCnt < 1 ? 1 : maxSafeAreaCnt);
    }

    private static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if (
                    X >= 0 && X < map.length
                    && Y >= 0 && Y < map.length
                    && map[Y][X] > flood
                    && visited[Y][X] == false
            ) {
                dfs(X, Y);
            }
        }
    }

    private static int[] searchSafeArea() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (
                        visited[i][j] == false
                        && map[i][j] > flood
                ) {
                    initP = new int[]{j, i};
                    return initP;
                }
            }
        }
        return new int[]{-1};

    }
}
