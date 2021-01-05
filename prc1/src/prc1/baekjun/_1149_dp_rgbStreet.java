package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class _1149_dp_rgbStreet {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n =Integer.parseInt(br.readLine());
		int arr[][] = new int[n][3];
		int dp[][]=new int[n][3];
		
		for(int i=0;i<n;i++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) arr[i][j]=Integer.parseInt(st.nextToken());
		}
		if(n>=1) {
			dp[0][0]=arr[0][0];
			dp[0][1]=arr[0][1];
			dp[0][2]=arr[0][2];
		}
		if(n>=2) {
			dp[1][0]=Math.min(arr[0][1]+arr[1][0], arr[0][2]+arr[1][0]);
			dp[1][1]=Math.min(arr[0][0]+arr[1][1], arr[0][2]+arr[1][1]);
			dp[1][2]=Math.min(arr[0][0]+arr[1][2], arr[0][1]+arr[1][2]);
		}
		if(n>2) {
			for(int i=2;i<n;i++) {
				dp[i][0]=Math.min(dp[i-1][1]+arr[i][0], dp[i-1][2]+arr[i][0]);
				dp[i][1]=Math.min(dp[i-1][0]+arr[i][1], dp[i-1][2]+arr[i][1]);				
				dp[i][2]=Math.min(dp[i-1][0]+arr[i][2], dp[i-1][1]+arr[i][2]);
			}
		}
		
		int min=Integer.MAX_VALUE;
		for(int i=0;i<3;i++) {
			min=Math.min(min, dp[n-1][i]);
		}
		System.out.println(min);
		
		
	}

}
