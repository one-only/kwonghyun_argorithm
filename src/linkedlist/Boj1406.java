package linkedlist;

import java.io.*;
import java.util.*;

// 에디터 https://www.acmicpc.net/problem/1406
public class Boj1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = reader.readLine();

        int cmdNum = Integer.parseInt(reader.readLine());

        Stack<Character> rightStack = new Stack<>();
        Stack<Character> leftStack = new Stack<>();
        // 링크드 리스트에 한글자 씩 삽입
        for (int i = 0; i < inputStr.length(); i++) {
            leftStack.push(inputStr.charAt(i));
        }

        for (int i = 0; i < cmdNum; i++) {
            String cmd = reader.readLine();
            switch (cmd.charAt(0)) {
                case 'L':
                    if (!leftStack.isEmpty()) rightStack.push(leftStack.pop()); break;
                case 'D':
                    if (!rightStack.isEmpty()) leftStack.push(rightStack.pop()); break;
                case 'B':
                    if (!leftStack.isEmpty()) leftStack.pop(); break;
                case 'P':
                    leftStack.push(cmd.charAt(2)); break;
            }
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
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
        writer.flush();
    }
}
