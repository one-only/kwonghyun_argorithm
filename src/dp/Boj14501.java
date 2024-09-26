package dp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Boj14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N+10];
        int[] P = new int[N+10];
        int[] dp = new int[N+10];
        int max = 0;
        String[] str;
        for (int i = 1; i <=N; i++) {
            str = br.readLine().split(" ");
            T[i] = Integer.parseInt(str[0]);
            P[i] = Integer.parseInt(str[1]);
        }
        //------------입력부------------//


        for (int i = 1; i <=N+1; i++) {
            dp[i] = Math.max(dp[i], max);
            dp[T[i]+i] = Math.max(dp[T[i]+i],P[i]+dp[i]);
            max = Math.max(max, dp[i]);

        }
        System.out.println(max);
    }
}
