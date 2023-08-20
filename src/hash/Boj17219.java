package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 비밀번호 찾기 https://www.acmicpc.net/problem/17219
public class Boj17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()); // 저장된 사이트 수
        int M = Integer.parseInt(st.nextToken()); // 비밀번호 찾으려는 사이트 수


        HashMap<String, String> map = new HashMap<>();

        // 해시맵에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine(), " ");
            map.put(st.nextToken(), st.nextToken());
        }

        // 맵에서 찾아서 출력
        for (int i = 0; i < M; i++) {
            System.out.println(map.get(reader.readLine()));
        }

    }
}
