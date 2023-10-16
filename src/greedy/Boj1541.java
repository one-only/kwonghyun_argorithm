package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 잃어버린 괄호 https://www.acmicpc.net/problem/1541
public class Boj1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String eq = reader.readLine();
        List<Character> operators = new ArrayList<>();
        List<Integer> operands = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < eq.length(); i++) {
            if (i == eq.length() - 1) {
                sb.append(eq.charAt(i));
                operands.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
            } else if (Character.isDigit(eq.charAt(i))) {
                sb.append(eq.charAt(i));
            } else {
                operands.add(Integer.parseInt(sb.toString()));
                sb = new StringBuilder();
                operators.add(eq.charAt(i));
            }
        }
        int ans = operands.get(0);
        boolean previous = true;
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals('-')) {
                previous = false;
            }
            if (previous) {
                ans += operands.get(i + 1);
            } else {
                ans -= operands.get(i + 1);
            }
        }
        System.out.println(ans);
    }
}
