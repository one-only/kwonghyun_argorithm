package hash;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

// 회사에 있는 사람 https://www.acmicpc.net/problem/7785
public class Boj7785 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        HashSet<String> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            String name = st.nextToken();
            if (hashSet.contains(name)) {
                hashSet.remove(name);
            } else {
                hashSet.add(name);
            }
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        List<String> names = new ArrayList<>(hashSet);
        names = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (String name : names) {
            writer.write(name + "\n");
        }
        writer.flush();
        writer.close();
    }
}
