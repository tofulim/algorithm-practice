package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class _1699_dp_sumofSqrt {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int dp[]=new int[n+1];
		
		dp[0]=0;
		for(int i=1;i<=n;i++) {
			int m=(int)Math.sqrt(i);
			if(i==m*m) {
				dp[i]=1;
				continue;
			}
			else {
				dp[i]=dp[m*m]+dp[i-m*m];
				while(--m>0) {
					dp[i]=Math.min(dp[m*m]+dp[i-m*m], dp[i]);
				}	
			}
		}

		System.out.println(Arrays.toString(dp));
		System.out.println(dp[n]);
	}

}
