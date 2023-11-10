import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> list[] = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] parent = new int[n+1];
        
        for(int i = 0; i < n+1; i++){
            list[i] = new ArrayList<>();
        }

        //데이터 입력
        for(int i = 0; i < n-1; i++){
            String[] s = br.readLine().split(" ");
            int a = Integer.parseInt(s[0]);
            int b = Integer.parseInt(s[1]);
            if(a == 1 || b == 1){
                int max = Math.max(a,b);
                q.add(max);
                parent[max] = 1;
                visited[max] = true;
            }
            else {
                list[a].add(b);
                list[b].add(a);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            for(int i : list[node]){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                    parent[i] = node;
                }
            }
        }
        
        for(int i = 2; i < n+1; i++){
            System.out.println(parent[i]);
        }

        br.close();
    }
}
