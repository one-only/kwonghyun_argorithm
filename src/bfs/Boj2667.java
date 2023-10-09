package bfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// 단지번호붙이기 https://www.acmicpc.net/problem/2667
public class Boj2667 {
    private static int houseCnt;
    private static List<Integer> complexCnt = new ArrayList<>();
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    private static int[][] map;

    private static int[] currentNode = new int[]{0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            String newLine = reader.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.digit(newLine.charAt(j), 10);
            }
        }
        while (searchNewComplex()[0] != -1) {
            dfs(currentNode[0], currentNode[1]);
            complexCnt.add(houseCnt);
            houseCnt = 0;
        }
        complexCnt = complexCnt.stream().sorted().collect(Collectors.toList());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(complexCnt.size()) + "\n");
        for (int num : complexCnt) {
            writer.write(String.valueOf(num) + "\n");
        }
        writer.flush();
        writer.close();
    }
    private static int[] searchNewComplex() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 1) {
                    currentNode[0] = j; // x
                    currentNode[1] = i; // y
                    return currentNode;
                }
            }
        }
        return new int[]{-1, -1};
    }
    private static int dfs(int x, int y) {

        houseCnt++;
        map[y][x] = 0;

        for (int i = 0; i < 4; i++) {
            if (
                    x + dx[i] >= 0 && x + dx[i] < map.length
                    && y + dy[i] >= 0 && y + dy[i] < map.length
                    && map[y + dy[i]][x + dx[i]] == 1
            ) {
                dfs(x + dx[i], y + dy[i]);
            }
        }
        return houseCnt;
    }

    private static void printMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                System.out.printf("%d", map[i][j]);
            }
            System.out.println("\n");
        }
    }
}
