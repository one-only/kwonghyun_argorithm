package backtracking;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

// 암호만들기 https://www.acmicpc.net/problem/1759
public class Boj1759 {
    private static BufferedWriter writer;
    private static Character[] letters;
    private static HashSet<Character> moum
            = new HashSet<>(Arrays.asList('a', 'i', 'o', 'u', 'e'));
    private static int C;
    private static int L;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine(), " ");
        letters = new Character[C];
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(letters);
        Character[] temp = new Character[L];
        dfs(0, 0, temp);
        writer.flush();
        writer.close();

    }

    private static boolean checkValidation(Character[] target) {
        int moumCnt = (int) Arrays.stream(target)
                .filter(c -> moum.contains(c))
                .count();

        return moumCnt >= 1 && moumCnt <= L - 2;
    }

    private static void dfs(int lastIdx, int level, Character[] temp) throws IOException {
        if (level == L) {
            if (checkValidation(temp)) {
                for (int i = 0; i < L; i++) {
                    writer.write(temp[i].toString());
                }
                writer.write("\n");
            }
            return;
        }


        for (int i = lastIdx; i < C; i++) {
            //System.out.printf("level: %d, i: %d\n", level, i);
            temp[level] = letters[i];
            dfs(i + 1, level + 1, temp);
        }
    }
}
