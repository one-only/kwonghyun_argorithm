package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

// 다음수 구하기 https://www.acmicpc.net/problem/2697
public class Boj2697 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        for (int i = 0; i < N; i++) {
            String A = reader.readLine();
            PriorityQueue<String> queue = new PriorityQueue<>();
            int index = 0;
            String firstSmallDigit = "a";
            String nextBigDigit = "a";
            for (int j = A.length() - 1; j > 0; j--) {
                if (A.charAt(j) <= A.charAt(j - 1)) {
                    queue.add(String.valueOf(A.charAt(j)));
                } else {
                    queue.add(String.valueOf(A.charAt(j)));
                    index = j - 1;
                    ArrayList<String> list = new ArrayList<>();
                    list.addAll(queue);
                    firstSmallDigit = String.valueOf(A.charAt(index));

                    for (String letter : list) {
                        if (letter.compareTo(firstSmallDigit) > 0) {
                            queue.remove(letter);
                            queue.add(firstSmallDigit);
                            nextBigDigit = letter;
                            break;
                        }
                    }
                    break;
                }
            }
            if (firstSmallDigit.equals("a")) {
                System.out.println("BIGGEST");
                continue;
            } else {
                StringBuilder sb = new StringBuilder(A.substring(0, index));
                sb.append(nextBigDigit);
                while (!queue.isEmpty()) {
                    sb.append(queue.poll());
                }
                System.out.println(sb.toString());
            }
        }
    }
}
