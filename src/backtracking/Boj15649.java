package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// N과 M (1) https://www.acmicpc.net/problem/15649
public class Boj15649 {
    private static BufferedWriter writer;
    private static int[] nums;
    private static int M;
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        nums = new int[N];
        for (int i = 1; i <= N; i++) {
            nums[i - 1] = i;
        }
//        System.out.println(Arrays.toString(nums));
        M = Integer.parseInt(st.nextToken());
        int[] ans = new int[M];
        search(0, 0, ans);
        writer.flush();
        writer.close();
    }

    static void search(int lastIdx, int level, int[] ans) throws IOException {
        for (int i = 0; i < N; i++) {
            int finalI = i;
            if (!Arrays.stream(Arrays.copyOfRange(ans, 0, level)).anyMatch(a -> a == nums[finalI])) {
                ans[level] = nums[i];
                if (level == M - 1) {
                    for (int j = 0; j < ans.length; j++) {
                        writer.write(ans[j] + " ");
                    }
                    writer.write("\n");

                } else {
                    search(lastIdx + 1, level + 1, ans);
                }
            }

        }
    }
}
