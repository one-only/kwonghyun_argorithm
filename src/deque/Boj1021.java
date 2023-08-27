package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 회전하는 큐 https://www.acmicpc.net/problem/1021
public class Boj1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for (int i = 0; i < N; i++) {
            deque.addLast(i + 1);
        }

        int[] targets = new int[M];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            int targetIdx = deque.indexOf(targets[i]);
            int halfIdx = (deque.size() % 2 == 0) ?
                    (deque.size() / 2 - 1) : (deque.size() / 2);

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    deque.addLast(deque.pollFirst());
                    cnt ++;
                }
            } else {
                for (int j = 0; j < deque.size() - targetIdx; j++) {
                    deque.addFirst(deque.pollLast());
                    cnt ++;
                }
            }
            deque.pollFirst();
        }
        System.out.println(cnt);
    }
}
