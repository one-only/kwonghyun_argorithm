package sort;

import java.io.*;
import java.util.*;

// 좌표 정렬하기 https://www.acmicpc.net/problem/11650
public class Boj11650 {
    private static class Node implements Comparable<Node>{
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Node o) {
            if (this.x > o.x) return 1;
            else if (this.x == o.x && this.y > o.y) return 1;
            else if (this.x == o.x && this.y > o.y) return 0;
            else return -1;
        }

        @Override
        public String toString() {
            return String.format("%d %d", this.x, this.y);
        }


    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        Node[] nodes = new Node[N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st =  new StringTokenizer(reader.readLine(), " ");
            Node node = new Node(
                    Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())
            );
            nodes[i] = node;
        }
        Arrays.sort(nodes);
        for (Node node :
                nodes) {
            writer.write(node.toString() + "\n");
        }
        writer.flush();
        writer.close();

    }
}
