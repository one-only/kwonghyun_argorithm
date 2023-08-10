package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        int inputInt;
        for (int i = 0; i < K; i++) {
            inputInt = Integer.parseInt(reader.readLine());
            if (inputInt == 0) stack.pop();
            else stack.push(inputInt);
        }
        int sum = 0;
        while (!stack.isEmpty())
            sum += stack.pop();
        System.out.println(sum);

    }
}
