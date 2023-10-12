import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		//첫째줄
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);
		
		//둘째줄
		String[] sts = br.readLine().split(" ");
		int[] cards = new int[n];
		for(int i = 0; i < n; i++){
			cards[i] = Integer.parseInt(sts[i]);
		}

		int sum = 0;

		for(int i = 0; i < n-2; i++){
			for(int j = i+1; j < n-1; j++){
				for(int k = j+1; k < n; k++){
					int temp = cards[i] + cards[j] + cards[k];
					if(Math.abs(m - temp) < Math.abs(m - sum) && m >= temp){
						sum = temp;
					}
				}
			}
		}

		System.out.println(sum);
        br.close();
	}
}
