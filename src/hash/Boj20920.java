package hash;

import java.io.*;
import java.util.*;

// 영어 암기는 괴로워 https://www.acmicpc.net/problem/20920
public class Boj20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = reader.readLine();
            if (word.length() < M) continue;
            if (words.containsKey(word)) {
                words.put(word, words.get(word) + 1);
            } else {
                words.put(word, 1);
            }
        }

        List<Map.Entry<String, Integer>> wordsEntries = new LinkedList<>(words.entrySet());
        wordsEntries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                int comparison1 = o2.getValue().compareTo(o1.getValue());
                if (comparison1 == 0) {
                    int comparison2 = o2.getKey().length() - o1.getKey().length();
                    if (comparison2 == 0) {
                        return o1.getKey().compareTo(o2.getKey());
                    }
                    return comparison2;
                }
                return comparison1;
            }
        });


        for (Map.Entry<String, Integer> entry :wordsEntries) {
            writer.write(entry.getKey() + "\n");
        }
        writer.flush();
        writer.close();
    }
}
