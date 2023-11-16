package heap;

import java.io.*;
import java.util.StringTokenizer;

// 카드 문자열 https://www.acmicpc.net/problem/13417
public class Boj13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(reader.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if (sb.isEmpty()) {
                    sb.append(st.nextToken());
                } else {
                    String newChar = st.nextToken();
                    if (sb.charAt(0) >= newChar.charAt(0)) {
                        sb.insert(0,newChar);
                    } else {
                        sb.append(newChar);
                    }
                }
            }
            writer.write(sb.toString());
            writer.write("\n");
        }
        writer.flush();
        writer.close();
    }
}
