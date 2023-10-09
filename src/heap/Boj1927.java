package heap;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

// 최소힙 https://www.acmicpc.net/problem/1927
public class Boj1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new PriorityQueue<>();
        int N = Integer.parseInt(reader.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(reader.readLine());
            if (temp == 0) {
                if (queue.isEmpty()) {writer.write("0\n");}
                else {writer.write(String.valueOf(queue.poll()) + "\n");}
            } else{
                queue.add(temp);
            }
        }
        writer.flush();
        writer.close();
    }
}
