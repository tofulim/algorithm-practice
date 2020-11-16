package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class _1932_dp_intTriangle {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		int n=Integer.parseInt(br.readLine());
		int [][]arr=new int[n][];
		int [][]dp=new int[n][];
		for(int i=0;i<n;i++) {
			arr[i]=new int[i+1];
			dp[i]=new int[i+1];
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<i+1;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]=arr[0][0];
		for(int i=1;i<n;i++) {
			for(int j=0;j<arr[i].length;j++) {
				if(j==0) dp[i][j]=arr[i][j]+dp[i-1][j];
				else if(j==arr[i].length-1) dp[i][j]=arr[i][j]+dp[i-1][j-1];
				else {
					dp[i][j]=Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
					
				}
			}
		}
		int max=0;
		for(int num : dp[n-1]) max=num>max?num:max; 
		System.out.println(max);
	}

}
