package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 나이순 정렬 https://www.acmicpc.net/problem/10814
public class Boj10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        User[] users = new User[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            users[i] = new User(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        Arrays.sort(users);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            writer.write(users[i].toString());
        }
        writer.flush();
        writer.close();
    }

    private static class User implements Comparable<User>{
        int age;
        String name;

        User(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public String toString() {
            return String.format("%d %s\n", this.age, this.name);
        }

        @Override
        public int compareTo(User o) {
            return this.age - o.age;
        }
    }
}
