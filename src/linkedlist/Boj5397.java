package linkedlist;

import java.io.*;
import java.util.Stack;

// 키로거 https://www.acmicpc.net/problem/5397
public class Boj5397 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pwNum = Integer.parseInt(reader.readLine());
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int j = 0; j < pwNum; j++) {
            String inputStr = reader.readLine();
            Stack<Character> rightStack = new Stack<>();
            Stack<Character> leftStack = new Stack<>();

            for (int i = 0; i < inputStr.length(); i++) {
                switch (inputStr.charAt(i)) {
                    case '<':
                        if (!leftStack.isEmpty()) rightStack.push(leftStack.pop()); break;
                    case '>':
                        if (!rightStack.isEmpty()) leftStack.push(rightStack.pop()); break;
                    case '-':
                        if (!leftStack.isEmpty()) leftStack.pop(); break;
                    default:
                        leftStack.push(inputStr.charAt(i)); break;
                }
            }
            int iterLeft = leftStack.size();
            int iterRight = rightStack.size();
            StringBuilder stringBuilder = new StringBuilder();
            // leftStack은 순서 뒤집기 해줘야 해서 StringBuilder 사용
            for (int i = 0; i < iterLeft; i++) {
                stringBuilder.append(leftStack.pop());
            }
            stringBuilder.reverse();
            writer.write(stringBuilder.toString());
            for (int i = 0; i < iterRight; i++) {
                writer.write(rightStack.pop());
            }
            writer.write("\n");
        }
        writer.flush();
    }
}
