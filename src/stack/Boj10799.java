package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// 쇠막대기 https://www.acmicpc.net/problem/10799
public class Boj10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String ps = reader.readLine();
        ps = ps.replace("()", "*");
        int barCnt = 0;

        int cnt = 0;
        for (int i = 0; i < ps.length(); i++) {
            if (ps.charAt(i) == '*') {
                cnt += barCnt;
            } else if (ps.charAt(i) == '(') {
                barCnt++;
            } else if (ps.charAt(i) == ')') {
                barCnt--;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
