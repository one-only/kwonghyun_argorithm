package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐 https://www.acmicpc.net/problem/10845
public class Boj10845 {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cmdNum = Integer.parseInt(reader.readLine());
        // 큐 만들기
        Queue<Integer> queue = new LinkedList<>();
        // 마지막 값 기록할 변수 만들기
        int last = 0;

        for (int i = 0; i < cmdNum; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String cmd = tokenizer.nextToken();
            switch (cmd) {
                case "push":
                    last = Integer.parseInt(tokenizer.nextToken());
                    queue.add(last);
                    break;
                case "pop":
                    System.out.println(queue.isEmpty() ? -1 : queue.poll());
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
                case "empty":
                    System.out.println(queue.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(queue.isEmpty() ? -1 : queue.peek());
                    break;
                case "back":
                    System.out.println(queue.isEmpty() ? -1 : last);
                    break;
            }
        }

    }
}

/*
15
push 1
push 2
front
back
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
front

 */