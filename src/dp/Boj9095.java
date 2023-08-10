package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 3; i < 11; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] +dp[i - 3];
        }

        int inputNum = Integer.parseInt(reader.readLine());
        for (int i = 0; i < inputNum; i++) {
            System.out.println(
                    dp[Integer.parseInt(reader.readLine()) - 1]
            );

        }
    }
}
