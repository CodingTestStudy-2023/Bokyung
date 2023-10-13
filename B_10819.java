import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		int answer = 0;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] st = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++){
			arr[i] = Integer.parseInt(st[i]);
		}

		Arrays.sort(arr);
		ArrayList<Integer> al = new ArrayList<>();
		boolean check = false;
		for(int i = 0; i <= (arr.length-1) / 2; i++){
			if(i == arr.length / 2 && arr.length % 2 == 1){
				al.add(Math.abs(al.get(0) - arr[i]) > Math.abs(al.get(al.size()-1) - arr[i]) ?  0 : al.size(), arr[i]);
			}else if(check == false){   //큰 수 맨 앞, 작은 수 맨 뒤
				al.add(0, arr[n-1-i]);
				al.add(al.size(), arr[i]);
			}else if(check == true){    //큰 수 맨 뒤, 작은 수 맨 앞
				al.add(0, arr[i]);
				al.add(al.size(), arr[n-1-i]);
			}
			check = !check;
		}

		for(int i = 0; i < n-1; i++){
			answer += Math.abs(al.get(i) - al.get(i+1));
		}
		System.out.println(answer);
        br.close();
	}
}
