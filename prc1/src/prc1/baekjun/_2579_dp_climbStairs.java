package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _2579_dp_climbStairs {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int []arr=new int[n+1]; 
		int []dp=new int[n+1];
		for(int i=1;i<=n;i++) arr[i]=Integer.parseInt(br.readLine());
		if(n>=1) {
			dp[1]=arr[1];

		}
		if(n>=2) {
			dp[2]=dp[1]+arr[2];

		}
		if(n>=3) {
			dp[3]=Math.max(arr[2]+arr[3],dp[1]+arr[3]);
		}
		if(n>=4) {
			for(int i=4;i<=n;i++) {
				dp[i]=Math.max(dp[i-2]+arr[i], dp[i-3]+arr[i]+arr[i-1]);
			}
		}
		System.out.println(dp[n]);

	}

}
