package backtracking;

import java.io.*;
import java.util.StringTokenizer;

// 로또 https://www.acmicpc.net/problem/6603
public class Boj6603 {
    private static BufferedWriter writer;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                writer.flush();
                writer.close();
                break;
            }
            int[] S = new int[k];
            
            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] ans = new int[6];
            track(S, 0, ans, k, 0);
            writer.write("\n");
        }
    }
    
    private static void track(int[] S, int level, int[] ans, int k, int lastIndex) throws IOException {
        for (int i = lastIndex; i < k - 5 + level; i++) {
            ans[level] = S[i];
            if (level == 5) {
                for (int j = 0; j < 6; j++) {
                    writer.write(ans[j] + " ");
                }
                writer.write("\n");
            } else {
                track(S, level + 1, ans, k, i + 1);
            }
        }
    }
}
