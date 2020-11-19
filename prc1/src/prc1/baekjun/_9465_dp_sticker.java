package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _9465_dp_sticker {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int size;
		for(int i=0;i<n;i++) {
			size = Integer.parseInt(br.readLine());
			int [] arr1 = new int[size+1];
			int [] arr2 = new int[size+1];
			int [][] dp = new int[size+1][2];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1;j<=size;j++) arr1[j]=Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=size;j++) arr2[j]=Integer.parseInt(st.nextToken());
			sb.append(go_dp(arr1,arr2,dp));
			sb.append("\n");
		}
		System.out.print(sb);
		
		

	}
	public static int go_dp(int []arr1, int []arr2, int [][]dp) {
		int answer=0;
		if(dp.length>=2) {
			dp[1][0]=arr1[1];
			dp[1][1]=arr2[1];
		}
		if(dp.length>=3) {
			dp[2][0]=arr2[1]+arr1[2];
			dp[2][1]=arr1[1]+arr2[2];
		}
		if(dp.length>=4) {
			for(int i=3;i<dp.length;i++) {
				dp[i][0]=Math.max(dp[i-1][1], dp[i-2][1])+arr1[i];
				dp[i][1]=Math.max(dp[i-1][0], dp[i-2][0])+arr2[i];
			}
		}
		answer=Math.max(dp[dp.length-1][0], dp[dp.length-1][1]);
		return answer;
	}

}
