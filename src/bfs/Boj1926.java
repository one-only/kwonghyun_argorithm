package bfs;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 그림 https://www.acmicpc.net/problem/1926
public class Boj1926 {
    private static int[] dx = new int[]{1, -1, 0, 0};
    private static int[] dy = new int[]{0, 0, 1, -1};
    private static int[][] map;
    private static int[] initP;
    private static boolean[][] visited;
    private static int area;
    private static int maxArea;
    private static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[n][m];

        while (searchDrawing()[0] != -1) {
            area = 0;
            dfs(initP[0], initP[1]);
            cnt++;
            maxArea = maxArea < area ? area : maxArea;
        }
        System.out.printf("%d\n%d", cnt, maxArea);

    }
    private static void dfs(int x, int y) {
        visited[y][x] = true;
        area++;
        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            if (
                    X >= 0 && X < map[0].length
                            && Y >= 0 && Y < map.length
                            && !visited[Y][X]
                            && map[Y][X] == 1
            ){
                dfs(X, Y);
            }
        }
    }


    private static int[] searchDrawing() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (
                        map[i][j] == 1
                        && !visited[i][j]
                ) {
                    initP = new int[]{j, i};
                    return initP;
                }
            }
        }
        return new int[]{-1};
    }
}
