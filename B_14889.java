import java.io.*;

public class Main {
   static int n;
   static int[][] s;
   static int min = Integer.MAX_VALUE;
   static boolean[] visit;

   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       n = Integer.parseInt(br.readLine());
       s = new int[n][n];
       visit = new boolean[n];

       for (int i = 0; i < n; i++) {
           String[] str = br.readLine().split(" ");
           for (int j = 0; j < n; j++) {
               s[i][j] = Integer.parseInt(str[j]);
           }
       }
       makeTeam(0, 0);
       System.out.println(min);
   }

   static void makeTeam(int idx, int depth) {
       if (depth == n/2) {
           calculateDiff();
           return;
       }

       for (int i = idx; i < n; i++) {
           if (!visit[i]) {
               visit[i] = true;
               makeTeam(i + 1, depth + 1);
               visit[i] = false;
           }
       }
   }

   static void calculateDiff() {
       int start = 0;
       int link = 0;
       for (int i = 0; i < n - 1; i++) {
           for (int j = i; j < n; j++) {
               if (visit[i] == true && visit[j] == true) {
                   start += s[i][j];
                   start += s[j][i];
               } else if (visit[i] == false && visit[j] == false) {
                   link += s[i][j];
                   link += s[j][i];
               }
           }
       }
       min = Math.min(Math.abs(start - link), min);
   }
}
