package queue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 큐2 https://www.acmicpc.net/problem/18258
public class Boj18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 시간 초과 안 하려고 BufferedWriter 초기화
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        // 명령어 갯수
        int cmdNum = Integer.parseInt(reader.readLine());

        // 출력 해야 할 값 초기화
        int returnInt = -2;
        // 큐 마지막 값 초기화
        int last = 0;

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < cmdNum; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String cmd = tokenizer.nextToken();
            switch (cmd) {
                case "push" :
                    last = Integer.parseInt(tokenizer.nextToken());
                    queue.add(last);
                    returnInt = -2;
                    break;
                case "pop" :
                    returnInt = queue.isEmpty() ? -1 : queue.poll();
                    break;
                case "size" :
                    returnInt = queue.size();
                    break;
                case "empty" :
                    returnInt = queue.isEmpty() ? 1 : 0;
                    break;
                case "front" :
                    returnInt = queue.isEmpty() ? -1 : queue.peek();
                    break;
                case "back" :
                    returnInt = queue.isEmpty() ? -1 : last;
                    break;
            }
            if (returnInt != -2)
                writer.write(Integer.valueOf(returnInt) + "\n");
        }
        writer.flush();
    }
}
