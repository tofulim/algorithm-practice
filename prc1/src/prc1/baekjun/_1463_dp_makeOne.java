package prc1.baekjun;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;

public class _1463_dp_makeOne {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp[] = new int[1000001];
		dp[1]=0;
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0) dp[i]=Math.min(dp[i/2]+1,dp[i]);
			if(i%3==0) dp[i]=Math.min(dp[i/3]+1,dp[i]);
		}
		System.out.println(dp[n]);

	}

}