package binarysearch;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 차집합 https://www.acmicpc.net/problem/1822
public class Boj1822 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int nA = stoi(st.nextToken());
        int nB = stoi(st.nextToken());

        HashSet<Integer> setA = new HashSet<>();

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < nA; i++) {
            setA.add(stoi(st.nextToken()));
        }

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < nB; i++) {
            setA.remove(stoi(st.nextToken()));
        }

        List<Integer> targetList = setA.stream().collect(Collectors.toList());

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(setA.size()) + '\n');
        targetList.stream()
                .sorted()
                .forEach(i -> {
                    try {
                        writer.write(String.valueOf(i) + ' ');
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        writer.flush();
        writer.close();
    }

    private static int stoi(String target) {
        return Integer.parseInt(target);
    }
}
