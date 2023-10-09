package bruteforce;

import java.io.*;
import java.util.Arrays;

// 백설공주와 일곱 난쟁이 https://www.acmicpc.net/problem/3040
public class Boj3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] dwarfs = new int[9];
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(reader.readLine());
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 1; j < 9; j++) {
                if (i >= j) continue;
                int[] temp = dwarfs.clone();
                temp[i] = 0;
                temp[j] = 0;
                int sum = Arrays.stream(temp).sum();
                if (sum == 100) {
                    for (int k = 0; k < 9; k++) {
                        if (temp[k] != 0) {
                            writer.write(String.format("%d\n", temp[k]));
                        }
                    }
                    writer.flush();
                    writer.close();
                    System.exit(0);
                }
            }
        }
    }
}
