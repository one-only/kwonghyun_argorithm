package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int N = Integer.parseInt(tokenizer.nextToken());
        int K = Integer.parseInt(tokenizer.nextToken());

        int[] token = new int[N];

        for(int i = 0; i < N; i++) {
            token[i] = Integer.parseInt(reader.readLine());
        }

        int cnt = 0;

        for(int i = N - 1; i >= 0; i--) {
            if(token[i] <= K) {
                cnt += (K / token[i]);
                K = K % token[i];
            }
        }
        System.out.println(cnt);
    }
}