package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _16194_dp_buyCard2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n+1];
		int [] dp = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<n+1;i++) dp[i]=arr[i]=Integer.parseInt(st.nextToken());
		
		dp[0]=0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				dp[i]=Math.min(dp[i], dp[i-j]+arr[j]);
			}
		}
		
		System.out.println(dp[n]);
	}

}
