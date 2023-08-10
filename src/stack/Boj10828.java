package stack;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int cmdNum = Integer.parseInt(reader.readLine());
        StringTokenizer st;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < cmdNum; i++) {
            st = new StringTokenizer(reader.readLine());
            StringBuilder temp = new StringBuilder();
            String cmd = st.nextToken();
            switch (cmd) {
                case "push": stack.push(st.nextToken()); break;
                case "pop": temp = new StringBuilder((stack.isEmpty() ? "-1" : stack.pop()) + "\n"); break;
                case "size": temp = new StringBuilder(String.valueOf(stack.size()) + "\n"); break;
                case "empty": temp = new StringBuilder((stack.isEmpty() ? "1" : "0") + "\n"); break;
                case "top": temp = new StringBuilder((stack.isEmpty() ? "-1" : stack.peek()) + "\n"); break;
            }
            if (!temp.equals(null))
                writer.write(String.valueOf(temp));
        }
        writer.flush();
        writer.close();


    }

}
