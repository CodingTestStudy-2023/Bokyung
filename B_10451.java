import java.io.*;

public class Main {
    static boolean[] visited;
    static int count = 0;
    static int cycleCount = 0;
    static int[] nums;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            nums = new int[n+1];                      
            visited = new boolean[n+1];          
            String[] s = br.readLine().split(" "); 
            
            //순열 저장
            for(int j = 1; j <= n; j++){
                nums[j] = Integer.parseInt(s[j-1]);
            }

            for(int j = 1; j <= n; j++){
                dfs(j);
            }
            System.out.println(count);
            count = 0;
        }
        br.close();
    }

    static void dfs(int num){
        //System.out.printf("num = %d, count = %d, visited = %b, cycleCount = %d\n", num, count, visited[num], cycleCount);
        if(visited[num]){
            if(cycleCount != 0){
                count++;
                cycleCount = 0;
            }
            return;
        }else{
            cycleCount++;
            visited[num] = true;
            dfs(nums[num]);
        }
    }
}
