package prc1.baekjun;
import java.util.*;
import java.io.*;

public class _14501_bruteforce_retire {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int [][] arr=new int[n+1][2]; 
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<2;j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		int [] dp = new int[n+1];
		Arrays.fill(dp, 0);
		
		for(int k=1;k<=n;k++) {
			int time=arr[k][0];
			if(time==1) dp[k]=Math.max(dp[k], dp[k-1]+arr[k][1]); //당일치기 가능한 일
			else {
				if(k+time-1>n) { //그날거 시간이 넘 커서 사용을 못할경우 그날을 소비되게 해야함
					dp[k]=Math.max(dp[k], dp[k-1]);
					continue;
				}
				dp[k]=Math.max(dp[k], dp[k-1]); //예정된 일이 없다면 전날것을 참조
				dp[k+time-1]=Math.max(dp[k+time-1],dp[k-1]+arr[k][1]); //미래에 예상금액
				//자기자신과 비교해서 어느 것이 더 이득인지 확인
			}	
		}
		Arrays.sort(dp);
		System.out.println(dp[n]);
	}
	

}
