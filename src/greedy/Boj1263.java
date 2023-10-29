package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 시간 관리 https://www.acmicpc.net/problem/1263
public class Boj1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            heap.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        int time = Integer.MAX_VALUE;
        while (!heap.isEmpty()) {
            int[] currentTask = heap.poll();
            if (time == Integer.MAX_VALUE) {
                time = currentTask[1] - currentTask[0];
            } else {
                time = Math.min(time, currentTask[1]);
                time -= currentTask[0];
                if (time < 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(time);
    }
}
