package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class _4948_math_betrand {
	static boolean [] arr;
	static int max=123456*2;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		arr = new boolean [max+1];
		Arrays.fill(arr, false);
		int level=450;
		while(Math.pow(level, 2)<max) level++;
		era(level);
		String n;
		while(!(n=br.readLine()).equals("0")){
			int num=Integer.parseInt(n);
			sb.append(getPrime(num)+"\n");
		}
		System.out.print(sb.toString());

	}
	public static void era(int level) {
		for(int i=2;i<level;i++) {
			if(arr[i]) continue;
			for(int j=2;i*j<=max;j++) {
				arr[j*i]=true;
			}
		}
	}
	public static int getPrime(int start) {
		int answer=0;
		for(int i=start+1;i<=start*2;i++) {
			if(!arr[i]) answer++;
		}
		return answer;
	}

}
