import java.io.*;
	
public class Main {
	  static int n;
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        addNumber("");
		br.close();
    }
    
    public static void addNumber(String str) {
        if(str.length() == n) {
            System.out.println(str);
			      System.exit(0);
        }
        
        for(int i = 1; i <= 3; i++) {
            if(checkPermutation(str+i)) {
                addNumber(str+i);
            }
        }
    }
  
    public static boolean checkPermutation(String str) {
        for(int i = 1; i <= str.length()/2; i++) {
            String str1 = str.substring(str.length() - i*2, str.length() - i);
            String str2 = str.substring(str.length() - i);
            if(str1.equals(str2)) return false;
        }
        return true;
    }
}
