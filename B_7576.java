import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static Queue<int[]> q = new LinkedList<>();
    static int n;
    static int m;
    static int max = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String[] s = br.readLine().split(" ");
        m = Integer.parseInt(s[0]);
        n = Integer.parseInt(s[1]);

        map = new int[n][m];    
        boolean check = true;

        for(int i = 0; i < n; i++){
            s = br.readLine().split(" ");
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(s[j]);
                if(map[i][j] != 1) check = false;
                if(map[i][j] == 1) q.add(new int[]{i, j});
            }
        }

        br.close();

        //처음부터 모두 익은 토마토일 때
        if(check){
            System.out.println(0);
            return; 
        }
        
        //탐색
        bfs();

        //안 익은 토마토가 있는지 확인
        for(int i = 0; i < n; i++){;
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0){
                    check = true;
                    break;
                }
                max = Math.max(map[i][j], max);
            }
        }
        System.out.println(check ? -1 : max-1);
    }

    static void bfs(){
        while(!q.isEmpty()){
            int[] tomato = q.poll();

            for(int i = 0; i < 4; i++){
                int nextX = tomato[0] + dirX[i];
                int nextY = tomato[1] + dirY[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
                if(map[nextX][nextY] != 0) continue;

                q.add(new int[] {nextX, nextY});
                map[nextX][nextY] = map[tomato[0]][tomato[1]] + 1;
            }
        }
        return;
    }
}
