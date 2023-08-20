package sort;

import java.io.*;
import java.util.Arrays;
// 수 정렬하기 4 https://www.acmicpc.net/problem/11931
public class Boj11931 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(reader.readLine());
        int[] ints = new int[N];
        for (int i = 0; i < N; i++) {
            ints[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(ints);
        for (int i = N - 1; i >= 0 ; i--) {
            writer.write(String.valueOf(ints[i]) + "\n");
        }
        writer.flush();
        writer.close();
    }
}
