package implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 빙고 https://www.acmicpc.net/problem/2578
public class Boj2578 {
    private static int bingo[][] = new int[5][5];
    private static int cnt;
    private static int turn;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int target;
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 5; j++) {
                target = Integer.parseInt(st.nextToken());
                mark(target);
                turn++;
                cnt = 0;
                checkBingo();
                if (cnt >= 3) {
                    System.out.println(turn);
                    System.exit(0);
                }

            }
        }
    }
    private static void mark(int target) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == target) {
                    bingo[i][j] = 0;
                }
            }
        }
    }

    private static void checkBingo() {
        // 열
        for (int i = 0; i < 5; i++) {
            int count0 = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0) count0++;
                if (count0 == 5) cnt++;
            }
        }

        // 행
        for (int i = 0; i < 5; i++) {
            int count0 = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0) count0++;
                if (count0 == 5) cnt++;
            }
        }

        // 대각 1, 2
        int count0 = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0) count0++;
            if (count0 == 5) cnt++;
        }

        count0 = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0) count0++;
            if (count0 == 5) cnt++;
        }
    }
}
