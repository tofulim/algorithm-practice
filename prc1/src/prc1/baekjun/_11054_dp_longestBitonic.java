package prc1.baekjun;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class _11054_dp_longestBitonic {
	static int dp1[];
	static int dp2[];
	static int arr[];
	static int n;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp1=new int[n+1];
		dp2=new int[n+1];
		arr=new int[n+1];
		for(int i=1;i<=n;i++) arr[i]=Integer.parseInt(st.nextToken());
		LIS();
		LDS();
		for(int k=1;k<=n;k++) dp1[k]+=dp2[k];
		int max=0;
		for(int tmp:dp1) max=max>tmp?max:tmp;
		System.out.println(max-1);
	}
	public static void LIS() {
		for(int i=1;i<=n;i++) {
			dp1[i]=1;
			for(int j=1;j<i;j++) {
				if(arr[i]>arr[j]) dp1[i]=Math.max(dp1[i], dp1[j]+1);
			}
		}
	}
	public static void LDS() {
		for(int i=n;i>=1;i--) {
			dp2[i]=1;
			for(int j=n;j>i;j--) {
				if(arr[i]>arr[j]) dp2[i]=Math.max(dp2[i], dp2[j]+1);
			}
		}
	}

}
