package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import java.util.StringTokenizer;

// 덱 https://www.acmicpc.net/problem/10866
public class Boj10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        StringTokenizer st;
        String cmd;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            cmd = st.nextToken();
            switch (cmd) {
                case "push_front" :
                    deque.addFirst(Integer.parseInt(st.nextToken())); break;
                case "push_back" :
                    deque.addLast(Integer.parseInt(st.nextToken())); break;
                case "pop_front" :
                    System.out.println(deque.size() == 0 ? -1 : deque.pollFirst());
                    break;
                case "pop_back" :
                    System.out.println(deque.size() == 0 ? -1 : deque.pollLast());
                    break;
                case "size" :
                    System.out.println(deque.size()); break;
                case "empty" :
                    System.out.println(deque.isEmpty() ? 1 : 0); break;
                case "front" :
                    System.out.println(deque.size() == 0 ? -1 : deque.peekFirst());
                    break;
                case "back" :
                    System.out.println(deque.size() == 0 ? -1 : deque.peekLast());
                    break;
            }
        }
    }
}
