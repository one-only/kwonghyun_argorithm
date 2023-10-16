package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 카드 합체 놀이 https://www.acmicpc.net/problem/15903
public class Boj15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Queue<Long> cards = new PriorityQueue<>();

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < n; i++) {
            cards.add(Long.parseLong(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            long sum = cards.poll() + cards.poll();
            cards.add(sum);
            cards.add(sum);
        }
        long sum = 0;

        for (Long card : cards) {
            sum += card;
        }
        System.out.println(sum);
    }
}
