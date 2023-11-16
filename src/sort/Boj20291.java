package sort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// 파일 정리 https://www.acmicpc.net/problem/20291
public class Boj20291 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < N; i++) {
            String ext = reader.readLine().split("\\.")[1];
            map.put(ext, map.getOrDefault(ext, 0) + 1);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Map.Entry<String, Integer>> mapEntryList = new ArrayList<>(map.entrySet());
        for (Map.Entry<String, Integer> entry : mapEntryList) {
            writer.write(entry.getKey() + " " + entry.getValue() + "\n");
        }
        writer.flush();
        writer.close();
    }
}
