package hash;

import java.io.*;
import java.util.*;

// 걸그룹 마스터 준석이 https://www.acmicpc.net/problem/16165
public class Boj16165 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<String[]> idols = new ArrayList<String[]>();

        for (int i = 0; i < N; i++) {
            String teamName = reader.readLine();
            int teamNum = Integer.parseInt(reader.readLine());
            for (int j = 0; j < teamNum; j++) {
                idols.add(new String[]{teamName, reader.readLine()});
            }
        }

        Collections.sort(idols, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int keyComparison = o1[0].compareTo(o2[0]);
                if (keyComparison == 0) {
                    return o1[1].compareTo(o2[1]);
                } else {
                    return keyComparison;
                }
            }});


        for (int i = 0; i < M; i++) {
            String quiz = reader.readLine();
            int quizFlag = Integer.parseInt(reader.readLine());
            if (quizFlag == 0) {
                for (String[] idol : idols) {
                    if (idol[0].equals(quiz)) {
                        writer.write(idol[1] + "\n");
                    }
                }
            } else {
                for (String[] idol : idols) {
                    if (idol[1].equals(quiz)) {
                        writer.write(idol[0] + "\n");
                        break;
                    }
                }
            }
        }
        writer.flush();
        writer.close();
    }
}
