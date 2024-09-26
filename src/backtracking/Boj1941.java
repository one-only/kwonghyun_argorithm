package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
// TODO 다시 볼것
// https://www.acmicpc.net/problem/1941
// 소문난 칠공주
public class Boj1941 {
    static boolean[][] map = new boolean[5][5];;
    static int ansCnt = 0;
    static int[] selectedNode;
    static int[] dr = new int[]{1, -1, 0, 0};
    static int[] dc = new int[]{0, 0, 1, -1};
    static boolean[] visited = new boolean[7];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String line = bf.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = line.charAt(j) == 'S';
            }
        }
        selectedNode = new int[7];

        dfs(0, 0);

        System.out.println(ansCnt);

    }

    static void dfs(int depth, int now) {
        if (depth == 7) {
            visited = new boolean[7];
            if (isConnected()) {
                ansCnt++;
            }
            return;
        }
        for (int i = now; i < 25 - 6 + depth; i++) {

            selectedNode[depth] = i;
            if (isValid(depth)) {
                dfs(depth + 1, i + 1);
            }

        }



    }
    static boolean isConnected() {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {selectedNode[0]/5, selectedNode[0]%5}); //가장 처음 slected[0] 넣기
        visited[0] = true;
        int conn = 1; //몇개 연결되어있는지

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i = 0 ; i < 4 ; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int ni = nr*5 + nc; //0~24의 다음 index

                if(
                       !(nr < 5 && nr >=0
                        && nc < 5 && nc >=0)
                ) continue;
                for(int j = 0 ; j < 7 ; j++) {
                    if(!visited[j] && selectedNode[j] == ni) {
                        q.add(new int[] {nr, nc});
                        visited[j] = true;
                        conn++;
                    }
                }
            }
        }

        return conn == 7;
    }

    static boolean isValid(int depth) {
        if (depth < 3) {
            return true;
        }
        int yCnt = 0;

        for (int i = 0; i <= depth; i++) {
            if (!getValueFromNode(selectedNode[i])) yCnt++;
        }
        return yCnt < 4;
    }
    static boolean getValueFromNode(int node) {
        return map[node / 5][node % 5];
    }
}
