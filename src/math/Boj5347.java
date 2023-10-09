package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

//LCM 최소공배수 https://www.acmicpc.net/problem/5347
public class Boj5347 {

    private static int[][] inputInts; // 입력받은 정수 배열
    private static int maxInt = 0; // 입력받은 숫자 중 최댓값
    private static int[] primes; // 입력받은 숫자 중 최댓값의 제곱근보다 작은 소수의 배열
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        inputInts = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            inputInts[i][0] = a;
            inputInts[i][1] = b;
            maxInt = Math.max(maxInt, Math.max(a, b));
        }

        getPrimes(maxInt);

        for (int i = 0; i < N; i++) {
            List<Integer> commonDivisors = new ArrayList<>();
            int a = inputInts[i][0];
            int b = inputInts[i][1];

            for (int j = 0; j < primes.length; j++) {
                while (a % primes[j] == 0 && b % primes[j] == 0) {
                    a /= primes[j];
                    b /= primes[j];
                    commonDivisors.add(primes[j]);
                }
            }
//            BigInteger lcm = BigInteger.valueOf((long) a * b);
//            for (Integer commonDivisor : commonDivisors) {
//                lcm = lcm.multiply(BigInteger.valueOf(commonDivisor));
//            }
            long lcm = ( (long) a) * ((long) b);
            for (Integer commonDivisor : commonDivisors) {
                lcm *= commonDivisor;
            }
            System.out.println(lcm);
        }
    }

    private static int[] getPrimes(int target) {
        int halfTarget = (target/2 + 1);
        List<Integer> temp = new ArrayList<>();
        for (int i = 2; i < halfTarget; i++) {
            temp.add(i);
        }
        Iterator<Integer> iterator = temp.iterator();
        List<Integer> primesList = new ArrayList<>();

        for (int i = 2; i < halfTarget; i++) {
            while (iterator.hasNext()) {
                if (iterator.next() == i) {
                    primesList.add(i);
                    temp = removeMultiples(temp, i);
                }
            }
        }
        primes = temp.stream().mapToInt(Integer::intValue).toArray();
        return primes;
    }

    private static List<Integer> removeMultiples(List<Integer> numbers, int targetNumber) {
        List<Integer> result = new ArrayList<>();

        for (Integer number : numbers) {
            if (number % targetNumber != 0 || number == targetNumber) {
                result.add(number);
            }
        }
        return result;
    }
}
