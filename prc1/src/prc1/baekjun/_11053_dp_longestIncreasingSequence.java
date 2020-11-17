package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11053_dp_longestIncreasingSequence {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] arr = new int[n];
		int [] dp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) arr[i]=Integer.parseInt(st.nextToken());
		dp[0]=1;
		
		for(int i=1;i<n;i++) {
			dp[i]=1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && dp[i]<=dp[j]) dp[i]=dp[j]+1;
			}
		}
		int max=0;
		for(int a : dp) max=a>max?a:max;
		System.out.println(max);
		

	}

}
