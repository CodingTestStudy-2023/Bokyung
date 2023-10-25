import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static int [][] map;
    static int n;
    static int m; 
    //위, 아래, 왼쪽, 오른쪽
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};

   public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));

        String[] s = br.readLine().split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            s = br.readLine().split("");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(s[j]);
            }
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);

        br.close();
    }

    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;

        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i = 0; i < 4; i++){
                int nextX = now[0] + directionX[i];
                int nextY = now[1] + directionY[i];

                if(checkValid(nextX, nextY)){
                    q.add(new int[] {nextX, nextY});
                    visited[nextX][nextY] = true;
                    map[nextX][nextY] = map[now[0]][now[1]] + 1;
                }
            }
        }
    }

    static boolean checkValid(int x, int y){
        if(x < 0 || y < 0 || x > n-1 || y > m-1) return false;
        if(map[x][y] == 0 || visited[x][y] == true) return false;

        return true;
    }
}
