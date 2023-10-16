package hash;

// 나는야 포켓몬 마스터 이다솜 https://www.acmicpc.net/problem/1620

import java.io.*;
import java.util.*;

public class Boj1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> monsters = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            String name = reader.readLine();
            monsters.put(name, String.valueOf(i));
            monsters.put(String.valueOf(i), name);
        }

        for (int i = 0; i < M; i++) {
            writer.write(monsters.get(reader.readLine()) + "\n");

        }
        writer.flush();
        writer.close();
    }
}
