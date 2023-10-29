package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

// 괄호 https://www.acmicpc.net/problem/9012
public class Boj9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());


        StringBuilder sb = new StringBuilder();
        boolean end = false;
        for (int i = 0; i < T; i++) {
            Stack<Integer> ps = new Stack<>();
            String input = reader.readLine();
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) == '(') {
                    ps.push(1);
                } else {
                    try {
                        ps.pop();
                    } catch (EmptyStackException e) {
                        sb.append("NO\n");
                        end = true;
                        break;
                    }
                }
            }
            if (ps.isEmpty() && !end) {
                sb.append("YES\n");
            } else if (!end){
                sb.append("NO\n");
            }
            end = false;
        }
        System.out.println(sb);
    }
}
