package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] triangle = new int[n][n];
        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for(int j = 0; j < i+1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        for(int i = 2; i <= n; i++) {
            for(int j = 0; j <= n-i; j++) {
                dp[n-i][j] = Math.max(dp[n-i+1][j], dp[n-i+1][j+1]) + triangle[n-i][j];
            }
        }

        System.out.println(dp[0][0]);
    }
}
