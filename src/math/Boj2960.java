package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 에라토스테네스의 체 https://www.acmicpc.net/problem/2960
public class Boj2960 {
    private static int cnt = 0;
    private static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        getPrimes(N);
    }

    private static void getPrimes(int target) {
        HashSet<Integer> temp = new HashSet<>();
        for (int i = 2; i <= target; i++) {
            temp.add(i);
        }
        while (!temp.isEmpty()) {
            int targetNum = temp.stream().min(Integer::compare).orElse(Integer.MAX_VALUE);
            removeMultiples(temp, targetNum);
        }
    }

    private static HashSet<Integer> removeMultiples(HashSet<Integer> numbers, int target) {
        int maxNum = numbers.stream().max(Integer::compare).orElse(Integer.MIN_VALUE);

        for (int i = 1; i * target <= maxNum; i++) {
            if (numbers.contains(i * target)) {
                numbers.remove(i * target);
                cnt++;
                if (cnt == K) {
                    System.out.println(i * target);
                    System.exit(0);
                }
            }
        }
        return numbers;
    }
}
