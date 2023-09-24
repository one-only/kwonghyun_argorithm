package sort;

import java.io.*;
import java.util.Arrays;

//접미사 배열 https://www.acmicpc.net/problem/11656
public class Boj11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String S = reader.readLine();

        int lenS = S.length();
        String[] postfixes = new String[lenS];

        for (int i = 0; i < lenS; i++) {
            postfixes[i] = S.substring(i);
        }

        Arrays.sort(postfixes);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < lenS; i++) {
            writer.write(postfixes[i] + "\n");
        }
        writer.flush();
        writer.close();
    }
}
