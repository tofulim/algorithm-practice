package prc1.baekjun;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11057_dp_ascNum {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		long dp[][]=new long[n+1][10];
		Arrays.fill(dp[1],1);
		
		for(int i=2;i<=n;i++) {
			dp[i][0]=dp[i-1][0];
			dp[i][1]=dp[i][0];
			for(int j=1;j<10;j++) {
				dp[i][j]=(dp[i][j-1]+dp[i-1][j])%10007;
			}
		}
		long sum=0;
		for(long tmp:dp[n]) sum=(tmp+sum)%10007; 
		System.out.println(sum);
	}

}
