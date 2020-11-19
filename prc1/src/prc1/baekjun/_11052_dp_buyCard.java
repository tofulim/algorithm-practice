package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11052_dp_buyCard {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n+1];
		int [] dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) arr[i]=Integer.parseInt(st.nextToken());
		
		int max=0;
		dp[0]=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				dp[i]=Math.max(dp[i], dp[i-j]+arr[j]);
			}
		}
		
		for(int a : dp) max=a>max?a:max;
		System.out.println(max);
		
	}

}