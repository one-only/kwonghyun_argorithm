package hash;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

// 듣보잡 https://www.acmicpc.net/problem/1764
public class Boj1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(reader.readLine());
        }

        List<String> names = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = reader.readLine();
            if (set.contains(name)) {
                names.add(name);
            }
        }
        names = names.stream().sorted().collect(Collectors.toList());
        writer.write(String.valueOf(names.size()) + "\n");
        for (String name : names) {
            writer.write(name + "\n");
        }
        writer.flush();
        writer.close();
    }
}
