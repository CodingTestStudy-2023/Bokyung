import java.io.*;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dirX = {1, -1, 0, 0};
    static int[] dirY = {0, 0, 1, -1};
    static int n;
    static int m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            String[] s = br.readLine().split(" ");
            m = Integer.parseInt(s[0]);
            n = Integer.parseInt(s[1]);
            int beachu = Integer.parseInt(s[2]);
            int count = 0;

            map = new int[n][m];
            visited = new boolean[n][m];

            for(int j = 0; j < beachu; j++){
                s = br.readLine().split(" ");
                map[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;;
            }

            for(int j = 0; j < n; j++){
                for(int k = 0; k < m; k++){
                    if(map[j][k] == 1 && visited[j][k] == false){
                        dfs(j, k);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        br.close();
    }

    static void dfs(int x, int y){
        for(int i = 0; i < 4; i++){
            int nextX = x + dirX[i];
            int nextY = y + dirY[i];
            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) continue;
            if(map[nextX][nextY] == 0 || visited[nextX][nextY] == true) continue;
            visited[nextX][nextY] = true;
            dfs(nextX, nextY);
        }
        return;
    }
}
