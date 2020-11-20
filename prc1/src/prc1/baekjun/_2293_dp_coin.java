package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class _2293_dp_coin {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int []arr=new int[n];
		int []dp=new int[k+1];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		dp[0]=1;
		for(int m=0;m<arr.length;m++) {
			for(int j=arr[m];j<=k;j++) {
					dp[j]+=dp[j-arr[m]];
			}
		}
		
		System.out.println(dp[k]);
	}

}
