package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 싸이버 개강총회 https://www.acmicpc.net/problem/19583
public class Boj19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine(), " :");

        double S = (Double.parseDouble(st.nextToken()) + Double.parseDouble(st.nextToken()) / 60.0);
        double E = (Double.parseDouble(st.nextToken()) + Double.parseDouble(st.nextToken()) / 60.0);
        double Q = (Double.parseDouble(st.nextToken()) + Double.parseDouble(st.nextToken()) / 60.0);

//        System.out.println("S = " + S);
//        System.out.println("E = " + E);
//        System.out.println("Q = " + Q);

        HashSet<String> names = new HashSet<>();


        int cnt = 0;
        String input;
        while ((input = reader.readLine()) != null && !input.isEmpty()) {
            st = new StringTokenizer(input, " :");
            double time = (Double.parseDouble(st.nextToken()) + Double.parseDouble(st.nextToken()) / 60.0F);
            String name = st.nextToken();
//            System.out.println("time = " + time +" name = " + name);
            if (time <= S) {
                names.add(name);
            } else if (time >= E && time <= Q && names.contains(name)) {
                names.remove(name);
                cnt++;
//                System.out.println(cnt);
            }
        }

        System.out.println(cnt);
    }
}
