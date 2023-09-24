package sort;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 국영수 https://www.acmicpc.net/problem/10825
public class Boj10825 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));

        int N = stoi(reader.readLine());

        Grade[] grades = new Grade[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");
            grades[i] = new Grade(st.nextToken(), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
        }
        Arrays.sort(grades);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            writer.write(grades[i].name + "\n");
        }
        writer.flush();
        writer.close();
    }

    private static int stoi(String target) {
        return Integer.parseInt(target);
    }

    private static class Grade implements Comparable<Grade>{
        String name;
        int kor;
        int eng;
        int math;

        Grade (String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }

        @Override
        public int compareTo(Grade o) {

            if (this.kor < o.kor) return 1;
            else if (this.kor > o.kor) return -1;
            else {
                if (this.eng > o.eng) return 1;
                else if (this.eng < o.eng) return -1;
                else {
                    if (this.math < o.math) return 1;
                    else if (this.math > o.math) return -1;
                    else {
                        return this.name.compareTo(o.name);
                    }
                }
            }
        }
    }
}
