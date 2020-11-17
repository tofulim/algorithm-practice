package prc1.baekjun;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _9461_dp_padovanSequence {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		int max=0;
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max=arr[i]>max?arr[i]:max;
		}
		long dp[] = new long[max+1];
		if(max>=1) dp[1]=1;
		if(max>=2) dp[2]=1;
		if(max>=3) dp[3]=1;
		if(max>=4) dp[4]=2;
		if(max>=5) dp[5]=2;
		if(max>5) {
			for(int i=6;i<=max;i++) {
				dp[i]=dp[i-1]+dp[i-5];
			}
		}
		for(int k=0;k<n;k++) {
			sb.append(dp[arr[k]]);
			sb.append("\n");
		}
		System.out.print(sb);
	}

}
