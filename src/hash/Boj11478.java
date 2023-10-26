package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// 서로 다른 부분 문자열의 개수 https://www.acmicpc.net/problem/11478
public class Boj11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            for (int j = i + 1; j <= input.length(); j++) {
                set.add(input.substring(i, j));
            }
        }
        System.out.println(set.size());
    }
}
