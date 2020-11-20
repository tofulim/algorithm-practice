package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11055_dp_biggestSequence {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int dp[]=new int[n+1];
		int arr[]=new int[n+1];
		
		for(int i=1;i<=n;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		for(int i=1;i<=n;i++) {
			dp[i]=arr[i];
			for(int j=1;j<i;j++) {
				if(arr[j]<arr[i]) dp[i]=Math.max(dp[i], arr[i]+dp[j]);
			}
			
		}
		int max=0;
		for(int m: dp) max=max>m?max:m;
		System.out.println(max);
		
	}

}
