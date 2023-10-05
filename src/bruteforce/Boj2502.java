package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 떡먹는 호랑이 https://www.acmicpc.net/problem/2502
public class Boj2502 {
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int dayCnt = Integer.parseInt(st.nextToken());
        int breadCnt = Integer.parseInt(st.nextToken());

        arr = new int[dayCnt];
        arr[0] = 1;
        arr[1] = 2;

        for (int i = 2; i < (dayCnt > 4 ? dayCnt - 2 : dayCnt); i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        int a = 0; int b = 0;
        if (dayCnt == 3) {
            a = 1; b = 1;
        } else if (dayCnt == 4) {
            a = 1; b = 2;
        } else {
            a = arr[dayCnt - 4];
            b = arr[dayCnt - 3];
        }

        for (int i = 1; i < breadCnt; i++) {
            for (int j = 2; j < breadCnt; j++) {
                if (i < j) {
                    if (i * a + j * b == breadCnt) {
                        System.out.println(i);
                        System.out.println(j);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
