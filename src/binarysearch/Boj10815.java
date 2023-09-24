package binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 숫자 카드 https://www.acmicpc.net/problem/10815
public class Boj10815 {
    private static int[] inputInts;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(reader.readLine());
        inputInts = new int[N];

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        for (int i = 0; i < N; i++)
            inputInts[i] = Integer.parseInt(st.nextToken());
        inputInts = Arrays.stream(inputInts).sorted().toArray();

        int M = Integer.parseInt(reader.readLine());
        int[] targetInts = new int[M];

        st = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < M; i++)
            targetInts[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            writer.write(String.valueOf(isIncluded(targetInts[i])) + ' ');
        }
        writer.flush();
        writer.close();
    }

    private static int isIncluded(int target) {
        int start = 0;
        int finish = inputInts.length -1;
        int mid;

        while (start <= finish) {
            mid = (finish + start) / 2;
            if (inputInts[mid] == target) {
                return 1;
            } else if (inputInts[mid] > target) {
                finish = mid -1;
            } else if (inputInts[mid] < target) {
                start = mid + 1;
            }
        }
        return 0;
    }
}
