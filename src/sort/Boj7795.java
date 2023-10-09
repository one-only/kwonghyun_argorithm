package sort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 먹을 것인가 먹힐 것인가 https://www.acmicpc.net/problem/7795
public class Boj7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T =  stoi(reader.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int N = stoi(st.nextToken());
            int M = stoi(st.nextToken());

            Integer[] A = new Integer[N];
            Integer[] B = new Integer[M];

            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = stoi(st.nextToken());
            }
            Arrays.sort(A, Collections.reverseOrder());

            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = stoi(st.nextToken());
            }
            Arrays.sort(B, Collections.reverseOrder());

            int cnt = 0;
            int lastMaxIdx = 0;

            for (int j = 0; j < N; j++) {
                for (int k = lastMaxIdx; k < M; k++) {
                    if (A[j] > B[k]) {
                        cnt += M - k;
                        lastMaxIdx = k;
                        break;
                    }
                }
            }
            writer.write(String.valueOf(cnt) + "\n");
        }
        writer.flush();
        writer.close();
    }

    private static int stoi(String target) {
        return Integer.parseInt(target);
    }

}
