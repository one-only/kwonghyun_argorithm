package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
// 트리 순회 https://www.acmicpc.net/problem/1991
public class Boj1991 {
    static class Node{

        char left;
        char right;

        public Node( char left, char right) {
            this.left = left;
            this.right = right;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static List<Node>[]list;
    static StringBuilder sb= new StringBuilder();

    public static void main(String args[]) throws IOException {

        n= Integer.parseInt(br.readLine());

        list= new ArrayList[n];
        for(int i=0; i<n; i++){
            list[i]=new ArrayList<>();
        }


        for(int i=0; i<n; i++){
            String[] s = br.readLine().split(" ");
            char start = s[0].charAt(0);
            char left = s[1].charAt(0);
            char right = s[2].charAt(0);

            list[start-'A'].add(new Node(left,right));
        }

        pre(0);
        sb.append("\n");
        mid(0);
        sb.append("\n");
        post(0);

        System.out.println(sb.toString());

    }

    public static void pre(int start){

        for(Node node : list[start]){
            char left = node.left;
            char right = node.right;


            sb.append((char)(start+'A'));
            if(left!='.'){
                pre(left-'A');
            }
            if(right!='.'){
                pre(right-'A');
            }
        }

    }
    public static void mid(int start){
        for(Node node: list[start]){
            char left = node.left;
            char right = node.right;

            if(left!='.'){
                mid(left-'A');
            }
            sb.append((char)(start+'A'));
            if(right!='.'){
                mid(right-'A');
            }
        }
    }

    public static void post(int start){
        for(Node node: list[start]){
            char left = node.left;
            char right = node.right;

            if(left!='.'){
                post(left-'A');
            }
            if(right!='.'){
                post(right-'A');
            }
            sb.append((char)(start+'A'));
        }
    }
}