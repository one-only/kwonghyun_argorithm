package heap;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
// 절댓값 힙 https://www.acmicpc.net/problem/11286
public class Boj11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int comparison = Math.abs(o1) - Math.abs(o2);
                if (comparison == 0) {
                    return o1 - o2;
                } else {
                    return comparison;
                }
            }
        });
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(reader.readLine());
            if (cmd == 0) {
                writer.write((queue.isEmpty() ? 0 : queue.poll()) + "\n");
            } else {
                queue.add(cmd);
            }
        }
        writer.flush();
        writer.close();
    }
}
