package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//양치기 꿍 https://www.acmicpc.net/problem/3187
public class Boj3187 {
    static char[][] map;
    static boolean[][] visited;
    static int R; // 새로 y
    static int C; // 가로 x
    static int[] snw = {0, 0};
    static int[] dx = {1, -1, 0 ,0};
    static int[] dy = {0, 0, 1, -1};
    static int[] nextNode;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            String line = reader.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        while (searchNextNode()) {
            int[] cnt = dfs(nextNode, new int[]{0, 0});
            if (cnt[0] > cnt[1]) { // 양이 더 많으면
                snw[0] += cnt[0];
            } else { // 늑대가 많거나 같을때
                snw[1] += cnt[1];
            }
        }
        System.out.println(snw[0] + " " + snw[1]);

    }

    static int[] dfs(int[] node, int[] cnt) {
        int x = node[0];
        int y = node[1];

        visited[y][x] = true;
        if (map[y][x] == 'k') {
            cnt[0]++;
        } else if (map[y][x] == 'v') {
            cnt[1]++;
        }

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (
                    nextX < C && nextX >= 0
                    && nextY < R && nextY >= 0
                    && !visited[nextY][nextX]
                    && map[nextY][nextX] != '#'
            ) {
                dfs(new int[]{nextX, nextY}, cnt);
            }
        }
        return cnt;
    }

    static boolean searchNextNode() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if ((map[i][j] == 'v' || map[i][j] == 'k') && !visited[i][j] ) {
                    nextNode =new int[]{j, i};
                    return true;
                }
            }
        }
        return false;
    }
}
