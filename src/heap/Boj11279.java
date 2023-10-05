package heap;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Boj11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1,o2);
            }
        });
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
