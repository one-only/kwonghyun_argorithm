package linkedlist;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

// 요세푸스 문제 https://www.acmicpc.net/problem/1158
public class Boj1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int N = Integer.parseInt(input.split(" ")[0]);
        int K = Integer.parseInt(input.split(" ")[1]);

        List<Integer> table = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
                table.add(i);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write("<");
        // datumIndex부터 몇 번째인지 세기
        int datumIndex = 0;
        // deleteIndex를 지움
        int deleteIndex = K - 1;
        while (table.size() > 1) {
            // datumIndex 부터 K번째 수가 한바퀴 돌아야 되는 경우 조정
            deleteIndex = (datumIndex + K - 1) % table.size();
            writer.write(table.get(deleteIndex).toString()+", ");
            table.remove(deleteIndex);
            datumIndex = deleteIndex < table.size() ? deleteIndex : 0;
        }
        writer.write(table.get(0)+">");
        writer.flush();
        writer.close();
    }
}
