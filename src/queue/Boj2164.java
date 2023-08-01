package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 카드2 https://www.acmicpc.net/problem/2164
public class Boj2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int cardNum = Integer.parseInt(reader.readLine());
        int recentPoll = -1;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= cardNum; i++) {
            queue.add(i);
        }
        while (queue.size() > 1) {
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.println(queue.poll());

    }
}
