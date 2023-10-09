package bfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 나이트의 이동 https://www.acmicpc.net/problem/7562
public class Boj7562 {

    private static int[][] map;
    private static int[][] currentXY;
    private static boolean[][] visited;
    private static int[] dx = {2, 2, 1, -1, -2, -2, -1, 1};
    private static int[] dy = {1, -1, -2, -2, -1, 1, 2, 2};
    private static Queue<int[]> queue;
    private static int[] initXY;
    private static int[] targetXY;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {

            int mapSize = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine());
            initXY = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            st = new StringTokenizer(reader.readLine());
            targetXY = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            map = new int[mapSize][mapSize];

            bfs();

            writer.write(String.valueOf(map[targetXY[1]][targetXY[0]]) + "\n");

        }
        writer.flush();
        writer.close();
    }

    private static void bfs() {
        queue = new LinkedList<>();
        visited = new boolean[map.length][map.length];
        queue.add(initXY);
        visited[initXY[1]][initXY[0]] = true;
        while (!queue.isEmpty()) {
            int[] currentXY = queue.poll();
            if (currentXY[0] == targetXY[0] && currentXY[1] == targetXY[1]) {break;}

            for (int i = 0; i < 8; i++) {
                int X = currentXY[0] + dx[i];
                int Y = currentXY[1] + dy[i];
                if (
                        X >= 0 && X < map.length
                                && Y >= 0 && Y < map.length
                                && map[Y][X] == 0
                                && visited[Y][X] == false
                ) {
                    map[Y][X] = map[currentXY[1]][currentXY[0]] + 1;
                    visited[Y][X] = true;
                    queue.add(new int[]{X, Y});
                }
            }
        }
    }
}
