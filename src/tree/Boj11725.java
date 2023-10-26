package tree;

import java.util.ArrayList;
import java.util.Scanner;
//트리의 부모 찾기 https://www.acmicpc.net/problem/11725
public class Boj11725{
    static ArrayList<Integer>[] list;
    static int[] parents;
    static boolean[] check;
    static void dfs(int v) {
        check[v]=true;
        for(int node : list[v]) {
            if(!check[node]) {
                parents[node] = v;
                dfs(node);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //노드 개수
        parents=new int[N+1];
        check = new boolean[N+1];
        list = new ArrayList[N+1];

        for(int i=1;i<=N;i++)
            list[i] = new ArrayList<Integer>();

        for(int i=1;i<N;i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();

            list[node1].add(node2);
            list[node2].add(node1);
        }
        dfs(1);
        for(int i=2;i<=N;i++)
            System.out.println(parents[i]);
    }


}